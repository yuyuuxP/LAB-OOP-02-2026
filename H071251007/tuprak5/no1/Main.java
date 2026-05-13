package tuprak5.no1;

public class Main {
    // Syarat 4 (Main)
    // - buat objek KaryawanTetap melakukan absen() beberapa 
    //   kali, lalu panggil hitungGaji() dengan bonus
    // - buat objek KaryawanKontrak melakukan absen() lebih dari 20 kali 
    //   dan tampilkan total gajinya

    public static void main(String[] args) {
        KaryawanTetap yuyu = new KaryawanTetap("Yuyu", "yuyu123", 5000000, 500000);
        KaryawanKontrak wahyu = new KaryawanKontrak("Wahyu", "wahyu321", 250000);
        yuyu.absen();
        yuyu.absen();
        yuyu.absen();
        yuyu.absen();
        
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen();
        wahyu.absen(); // absen ke-20
        wahyu.absen();
        wahyu.absen();
        
        // Perintah Soal
        System.out.println("Gaji " + yuyu.getNama() + ": " + yuyu.hitungGaji());
        System.out.println("Gaji " + yuyu.getNama() + " (dengan bonus): " + yuyu.hitungGaji(500000));
        System.out.println("Gaji " + wahyu.getNama() + ": " + wahyu.hitungGaji());
        System.out.println(" ");


        // Perintah iseng
        // System.out.println("Gaji " + yuyu.getNama() + ": " + yuyu.hitungGaji()); // tanpa bonus
        // yuyu.hitungGaji(1000000); // ada bonus

        // System.out.println("Gaji " + wahyu.getNama() + ": " + wahyu.hitungGaji());
        // System.out.println(" ");
    }
}
