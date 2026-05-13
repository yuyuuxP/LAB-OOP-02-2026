package tuprak5.no1;

// syarat 1 di soal:
// - atribut nama, idKaryawan, dan jumlahKehadiran(int) bersifat private
// - ada method konkrit absen() -> menambah jumlah kehadiran tiap dipanggil
// - method abstrak hitungGaji()

abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran = 0;

    public Karyawan(String nama, String idKaryawan){
        this.nama = nama;
        this.idKaryawan = idKaryawan;
    }

    public void absen(){
        this.jumlahKehadiran++;
    }

    public abstract double hitungGaji();

    public String getNama(){
        return nama;
    }

    public String getIdKaryawan(){
        return idKaryawan;
    }

    public int getJumlahKehadiran(){
        return jumlahKehadiran;
    }

}
