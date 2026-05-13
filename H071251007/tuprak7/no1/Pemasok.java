package tuprak7.no1;

import java.util.Random;

public class Pemasok implements Runnable {
    private final Gudang gudang;
    private final Random random = new Random();

    public Pemasok(Gudang gudang, String nama) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = random.nextInt(5) + 1;
                gudang.tambahStok(jumlah);
                Thread.sleep(1000 + random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            System.out.println("Pemasok berhenti bekerja :v");
        }
    }
}
