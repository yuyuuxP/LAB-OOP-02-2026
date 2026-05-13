package tuprak5.no1;

// Syarat 2 
// - atribut: gajiPokok dan tunjanganMakan
// - logika method hitungGaji(): Total Gaji = gajiPokok + (tunjanganMakan * jumlahKehadiran)
// - overloading method: buat method hitungGaji(double bonusKinerja) 
//   yg mengembalikan: (Total Gaji + bonusKinerja)

public class KaryawanTetap extends Karyawan{
    double gajiPokok;
    double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, int gajiPokok, int tunjanganMakan){
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    public double hitungGaji(){
        return gajiPokok + (tunjanganMakan * getJumlahKehadiran());
    }

    public double hitungGaji(double bonusKinerja){
        return hitungGaji() + bonusKinerja;
    }

    // PERINTAH MODIF AKA ISENG
    // public double hitungGaji(){
    //     System.out.println("\nKehadiran " + getNama() + ": " + getJumlahKehadiran());
    //     System.out.println("Menghitung total gaji...");
    //     return gajiPokok + (tunjanganMakan * getJumlahKehadiran());
    // }

    // public void hitungGaji(double bonusKinerja){
    //     double bonus = hitungGaji() + bonusKinerja;
    //     System.out.println("Gaji " + getNama() + " (dengan bonus): " + bonus);
    // }
}
