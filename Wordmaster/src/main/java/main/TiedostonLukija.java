package main;

import java.io.*;
import wordmaster.Sana;
import wordmaster.Sanasto;

public class TiedostonLukija {

    Sanasto sanasto;

    /**
     *
     */
    public TiedostonLukija() {

        this.sanasto = new Sanasto();

    }

    /**
     *
     * @return @throws Exception
     */
    public boolean lueTiedosto() throws Exception {

        try {
            File fileDir = new File("kotus_sanat_karsittu.txt");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF-8"));

            String str;
            while ((str = in.readLine()) != null) {

                Sana sana = new Sana(str);

                sanasto.lisaaSana(sana);

//Tiedostokirjoitin kirjoitin = new Tiedostokirjoitin();
//                TiedostonLukija.avaa("teksti.txt");
//                TiedostonLukija.kirjoita(str);
//
//                TiedostonLukija.sulje();
            }

            in.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}

//    public static boolean avaa(String tiedostonimi) {
//        /* Avaa tekstitiedoston tiedostonimi kirjoittamista
//         varten. Palauttaa arvon false jos syntyy poikkeus.*/
//        try {
//            kirjoitettavaTiedosto = new PrintWriter(new FileOutputStream(tiedostonimi), true);
//        } catch (Exception poikkeus) {
//            return false;
//        }
//        return true;
//    }
//    public static boolean kirjoita(String kirjoitettavaMerkkijono) {
//        /* Kirjoittaa merkkijonon. Palauttaa arvon false
//         jos syntyy poikkeus.*/
//        try {
//            kirjoitettavaTiedosto.println(kirjoitettavaMerkkijono);
//        } catch (Exception poikkeus) {
//            return false;
//        }
//        return true;
//    }
//    public static boolean sulje() {
//        /* Sulkee tiedoston. Palauttaa poikkeuksen sattuessa
//         falsen.*/
//        try {
//            kirjoitettavaTiedosto.close();
//        } catch (Exception poikkeus) {
//            return false;
//        }
//        return true;
//
//    }
//}

