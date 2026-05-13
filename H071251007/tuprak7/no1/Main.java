package tuprak7.no1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Gudang gudangPusat = new Gudang(50);

        ExecutorService pemasokPool = Executors.newFixedThreadPool(2);
        ExecutorService kurirPool = Executors.newFixedThreadPool(3);
        
        for (int i = 1; i <= 2; i++) {
            pemasokPool.execute(new Pemasok(gudangPusat, "Pemasok-" + i));
        }

        for (int i = 1; i <= 3; i++) {
            kurirPool.execute(new Kurir(gudangPusat, "Kurir-" + i));
        }

        Thread monitorThread = new Thread(new Monitoring(gudangPusat));
        monitorThread.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Menghentikan Sistem... ---");
        pemasokPool.shutdownNow();
        kurirPool.shutdownNow();
        monitorThread.interrupt();

        try {
            pemasokPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Sistem logistik selesai.");
    }
}
