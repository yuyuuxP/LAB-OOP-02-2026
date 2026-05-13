package tuprak7.no1;

public class Gudang {
    private int stok = 0;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println("[!] " + " Pemasok menunggu, gudang penuh...");
            wait();
        }
        stok += jumlah;
        System.out.println("[+] " + " Pemasok menambah stok sebanyak " + jumlah + ". Stok saat ini: " + stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) throws InterruptedException {
        while (stok < jumlah) {
            System.out.println("[-] " + " Kurir menunggu, stok tidak cukup...");
            wait();
        }
        stok -= jumlah;
        System.out.println("[*] " + " Kurir mengambil sebanyak " + jumlah + ". Stok saat ini: " + stok);
        notifyAll();
    }

    public int getStok() { return stok; }
    public int getKapasitasMaksimal() { return kapasitasMaksimal; }
}
