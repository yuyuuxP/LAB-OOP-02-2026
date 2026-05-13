package tuprak5.no2;

public class SmartLamp extends PerangkatElektronik implements KontrolSuara{
    public SmartLamp(String merk, int dayaListrik){
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi(){
        System.out.println("Lampu " + merk + " siap dipakai");
    }

    @Override
    public void prosesPerintah(String perintah){
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        }
    }
}