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
//        sanasto.luoOtos(25);
//        System.out.println(sanasto.luoRandomSana());
        Peli peli = new Peli();
//        peli.lisaaMerkki(0, 0, 'W');
//        peli.lisaaMerkki(0, 9, 'E');
//        peli.lisaaMerkki(3, 3, 'K');
//        peli.lisaaMerkki(12, 0, 'Y');
//        peli.lisaaMerkki(12, 9, 'O');
//        Sana kissa = new Sana("kissa");
        peli.sijoitaSana(sanasto.luoRandomSana());

//        System.out.println(peli.palauta(0, 0));
//        System.out.println(peli.palauta(3, 4));
        peli.tulosta();

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
