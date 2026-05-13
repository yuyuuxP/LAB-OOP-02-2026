package tuprak7.no1;

public class Monitoring implements Runnable {
    private final Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int stok = gudang.getStok();
                int maks = gudang.getKapasitasMaksimal();
                double persen = ((double) stok / maks) * 100;
                
                int barisProgressBar = 20; 
                int filled = (int) (persen / (100 / barisProgressBar));
                
                StringBuilder bar = new StringBuilder("[");
                for (int i = 0; i < barisProgressBar; i++) {
                    if (i < filled) bar.append("#");
                    else bar.append("-");
                }
                bar.append("]");

                System.out.printf("\nStatus Gudang: %s %.0f%%\n\n", bar.toString(), persen);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Monitoring dihentikan...");
        }
    }
}
