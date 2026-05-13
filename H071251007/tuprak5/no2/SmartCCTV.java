package tuprak5.no2;

public class SmartCCTV extends PerangkatElektronik implements InteraksiInternet{
    public SmartCCTV(String merk, int daya){
        super(merk, daya);
    }

    @Override
    public void cekFungsi(){
        System.out.println("CCTV " + merk + " sedang memantau");
    }

    @Override
    public void hubungkanWifi(){
        System.out.println("Mengirim data ke server...");
    }
}
