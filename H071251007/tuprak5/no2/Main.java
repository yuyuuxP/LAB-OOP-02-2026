package tuprak5.no2;

// Syarat
// - melakukan instansiasi pada 3 kelas
// - kelas speaker harus menjalankan semua perintah, baik abstract hingga interface
// - kelas lampu tidak boleh memiliki perintah dari method wifi

public class Main {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("philips", 20);
        SmartCCTV cctv = new SmartCCTV("xiomi", 40);
        SmartSpeaker speaker = new SmartSpeaker("bardan", 10);

        System.out.println("\n=== Instansiasi Lampu ===");
        lampu.cekFungsi();
        lampu.prosesPerintah("nyala");
        lampu.infoPower();

        System.out.println("\n=== Instansiasi CCTV ===");
        cctv.cekFungsi();
        cctv.hubungkanWifi();
        cctv.infoPower();

        System.out.println("\n=== Instansiasi Speaker ===");
        speaker.hubungkanWifi();
        speaker.cekFungsi();
        speaker.prosesPerintah("Putar musik Disenchanted by My Chemical Romance");
        speaker.infoPower();
        System.out.println(" ");
    }
}
