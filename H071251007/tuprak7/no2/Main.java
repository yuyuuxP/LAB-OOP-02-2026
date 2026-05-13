package tuprak7.no2;

import java.util.concurrent.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int jumlahDokumen = 10;
        int jumlahThread = 4;

        // Thread-safe map untuk menyimpan hasil kolektif
        ConcurrentHashMap<String, DocumentResult> hasilIndexing = new ConcurrentHashMap<>();
        
        // ExecutorService untuk manajemen thread
        ExecutorService executor = Executors.newFixedThreadPool(jumlahThread);
        
        // Barrier untuk memastikan program utama menunggu semua thread selesai
        CountDownLatch latch = new CountDownLatch(jumlahDokumen);
        
        DataProcessor processor = new DataProcessor();
        long startTimeGlobal = System.currentTimeMillis();

        System.out.println("--- Memulai Proses Indexing ---\n");

        for (int i = 1; i <= jumlahDokumen; i++) {
            String namaDokumen = "Dokumen_" + (char)('A' + (i - 1)) + ".txt";
            
            executor.execute(() -> {
                try {
                    long startTimeDoc = System.currentTimeMillis();
                    
                    // Proses indexing
                    int jumlahKata = processor.process(namaDokumen);
                    
                    long duration = System.currentTimeMillis() - startTimeDoc;
                    String threadName = Thread.currentThread().getName();

                    // Simpan ke wadah kolektif
                    DocumentResult result = new DocumentResult(namaDokumen, jumlahKata, threadName, duration);
                    hasilIndexing.put(namaDokumen, result);

                    // Monitoring Progress Real-time
                    System.out.printf("[%s] Selesai memproses %s (%d kata)\n", 
                                      threadName, namaDokumen, jumlahKata);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown(); // Kurangi hitungan barrier
                }
            });
        }

        try {
            // Menunggu hingga semua dokumen (10) selesai diproses
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        tampilkanLaporanAkhir(hasilIndexing);
    }

    private static void tampilkanLaporanAkhir(ConcurrentHashMap<String, DocumentResult> hasil) {
        System.out.println("\n--- Klasemen Akhir Indexing ---");
        System.out.printf("%-15s | %-15s | %-12s\n", "Nama Dokumen", "Thread", "Durasi (ms)");
        System.out.println("----------------------------------------------------------");

        int totalKata = 0;
        long totalDurasi = 0;

        for (DocumentResult res : hasil.values()) {
            System.out.printf("%-15s | %-15s | %-12d\n", 
                              res.getFileName(), res.getThreadName(), res.getDuration());
            totalKata += res.getWordCount();
            totalDurasi += res.getDuration();
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Total Kata Keseluruhan : " + totalKata);
        System.out.printf("Rata-rata Waktu Proses: %.2f ms\n", (double) totalDurasi / hasil.size());
    }
}