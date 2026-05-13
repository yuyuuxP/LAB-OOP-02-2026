package tuprak5.no2;

public class SmartSpeaker extends PerangkatElektronik implements KontrolSuara, InteraksiInternet{
    public SmartSpeaker(String merk, int dayaListrik){
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi(){
        System.out.println("SmartSpeaker " + merk + " menunggu perintah...");
    }

    @Override
    public void hubungkanWifi(){
        System.out.println("SmartSpeaker mencari sinyal wifi...");
    }

    @Override
    public void prosesPerintah(String perintah){
        System.out.println("SmartSpeak menjalankan perintah: " + perintah);
    }
}
