package tuprak5.no2;

// Syarat
// - memiliki atribut: merk dan dayaListrik
// - method abstract cekFungsi()
// - method konkrit infoPower() -> menampilkan pesan bahwa perangkat sedang menyedot 
//   daya sebesar X watt

abstract class PerangkatElektronik {
    String merk;
    int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik){
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public abstract void cekFungsi();

    public void infoPower(){
        System.out.println("Perangkat sedang menyedot daya sebesar " + dayaListrik + " watt");
    }
}

interface InteraksiInternet {
    public void hubungkanWifi();
}

interface KontrolSuara {
    public void prosesPerintah(String perintah);
}