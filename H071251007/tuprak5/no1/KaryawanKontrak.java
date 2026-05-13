package tuprak5.no1;

// syarat 3
// - atribut: upahPerhari
// - logika hitungGaji(): Total Gaji = upahPerHari * jumlahKehadiran
// - validasi: jika jumlahKehairan > 20 hari maka berikan bonus tambahan flat Rp 500.000

public class KaryawanKontrak extends Karyawan {
    double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari){
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji(){
        int kehadiran = getJumlahKehadiran();
        double totalGaji = upahPerHari * kehadiran;
        if (kehadiran > 20){
            totalGaji += 500000;

        }
        return totalGaji;
    }


    // PERINTAH MODIF
    // public double hitungGaji(){
    //     int kehadiran = getJumlahKehadiran();
    //     double totalGaji = upahPerHari * kehadiran;
    //     System.out.println("\nKehadiran " + getNama() + ": " + kehadiran);
    //     if (kehadiran > 20){
    //         System.out.println("Selamat kamu dapat bonus karna rajin!");
    //         totalGaji += 500000;

    //     }
    //     return totalGaji;
    // }
}
