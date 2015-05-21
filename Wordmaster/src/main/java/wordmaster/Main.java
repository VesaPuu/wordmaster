package wordmaster;

import java.io.FileNotFoundException;

public class Main {

    static TiedostonLukija tl;
    static Sanasto sanasto;

    public static void main(String[] args) throws FileNotFoundException, Exception {

        Main.tl = new TiedostonLukija();
        Main.sanasto = new Sanasto();
        tl.lueTiedosto();
//        sanasto.tulostaSanat();
        sanasto.luoOtos(25);
        sanasto.luoRandomSana();
//        Kentta k = new Kentta();
//        k.tulosta();
//        Sana.teeAnagrammi(sanasto.getSana(6).getSana());
//        Sana uusi = new Sana("kissakala");
//        System.out.println(uusi);
//        System.out.println(uusi.getPituus());
//        Pelaaja mikko = new Pelaaja("Mikko");
//        System.out.println(mikko);

//        sanasto.tulostaSanat();
    }

}
