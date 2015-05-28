package main;

import java.io.FileNotFoundException;
import wordmaster.Peli;
import wordmaster.Sanasto;

/**
 *
 * @author Vesa
 */
public class Main {

    static TiedostonLukija tl;
    static Sanasto sanasto;

    /**
     *
     * @param args
     * @throws FileNotFoundException
     * @throws Exception
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {

        Main.tl = new TiedostonLukija(); // luodaan uusi Tiedostonlukija-olio
        Main.sanasto = new Sanasto(); // luodaan uusi Sanasto-olio
        tl.lueTiedosto();
//        sanasto.tulostaSanat();
//        sanasto.luoOtos(25);
//        System.out.println(sanasto.luoRandomSana());
        Peli peli = new Peli(); // luodaan uusi Peli-olio
        peli.sijoitaSana(Main.sanasto.luoRandomSana()); // testataan satunnaisen sanan sijoittamista peliruudukkoon
//        System.out.println(peli.palauta(0, 0));
//        System.out.println(peli.palauta(3, 4));
        peli.tulosta(); // testataan peliruudukon tulostamista

//        Sana.teeAnagrammi(sanasto.getSana(6).getSana());
//        Sana uusi = new Sana("kissakala");
//        System.out.println(uusi);
//        System.out.println(uusi.getPituus());
//        Pelaaja mikko = new Pelaaja("Mikko");
//        System.out.println(mikko);
//        sanasto.tulostaSanat();
    }

}
