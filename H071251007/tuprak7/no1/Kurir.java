package tuprak7.no1;

import java.util.Random;

public class Kurir implements Runnable {
    private final Gudang gudang;
    private final Random random = new Random();

    public Kurir(Gudang gudang, String nama) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = random.nextInt(3) + 1;
                gudang.ambilStok(jumlah);
                Thread.sleep(2000 + random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            System.out.println("Kurir berhenti bekerja :D");
        }
    }
}
