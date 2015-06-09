package wordmaster;

import java.util.Random;

/**
 * Piilosana-luokkaa tarvitaan Piilosana-pelin taulukon luomiseen. Luokan
 * välineillä taulukkoon voidaan sijoittaa sanoja satunnaisesti merkki
 * kerrallaan ja palauttaa tieto siitä, mikä merkki on missäkin taulukon
 * solussa.
 *
 * @author Vesa
 */
public class Piilosana {

    public static char[][] taulukko;
    private static Random random;

    /**
     *
     */
    public Piilosana() {

        this.taulukko = new char[10][10];
        this.random = new Random();
    }

    /**
     *
     * @param rivi
     * @param sarake
     * @param merkki
     * @return
     */
    public boolean lisaaMerkki(int rivi, int sarake, char merkki) {

        taulukko[rivi][sarake] = merkki;
        return true;
    }

    /**
     *
     * @param rivi
     * @param sarake
     * @return
     */
    public static String palautaMerkki(int rivi, int sarake) {
        char merkki = taulukko[rivi][sarake];
        String kirjain = "" + merkki;
        return kirjain;
    }

    public static boolean onkoTyhja(int rivi, int sarake) {
        char merkki = taulukko[rivi][sarake];
        if (merkki == 0) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param sana
     * @return
     */
    public static char[] sanastaMerkkitaulukko(Sana sana) {
        // tehdÃ¤Ã¤n sanasta merkkitaulukko
        char[] mtaulu = sana.getSana().toCharArray();
        return mtaulu;
    }

    public static void tyhjennaKaikki() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                taulukko[i][j] = 0;

            }
        }
    }

    public static void taytaKaikki() {
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                if (onkoTyhja(i, j)) {

                    taulukko[i][j] = satunnainenMerkki();
                }
            }

        }
    }

    private static char satunnainenMerkki() {
        final String aakkoset = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ";
        Random r = new Random();
        final int pituus = aakkoset.length();
        return aakkoset.charAt(r.nextInt(pituus));

    }

    /**
     *
     * @param sana
     * @return
     */
    public static boolean sijoitaSana(Sana sana) {
        char[] mtaulu = sanastaMerkkitaulukko(sana);
        int rivi = random.nextInt(10); // arvotaan aloitusrivi
        int sarake = random.nextInt(10); // arvotaan aloitussarake
        for (int i = 0; i < mtaulu.length; i++) {  //sijoitetaan mtaulun merkit taulukkoon yksi kerrallaan

            taulukko[rivi][sarake] = mtaulu[i];

//            System.out.println(rivi + ", " + sarake);
//            if (voikoSeuraavanSijoittaa(rivi, sarake)) {; // testataan, voiko seuraavan merkin sijoittaa johonkin lähellä olevista soluista
            while (true) {
                int uusiRivi = muutaArvoaSatunnaisesti(rivi);
                int uusiSarake = muutaArvoaSatunnaisesti(sarake);
                if ((uusiRivi >= 0 && uusiRivi < 10 && uusiSarake >= 0 && uusiSarake < 10)) {
                    if ((onkoTyhja(uusiRivi, uusiSarake))) {//
                        rivi = uusiRivi;
                        sarake = uusiSarake;
                        break;
                    }
                }
            }

//            } else {
//                return false;
//            }
        }
        return true;
    }

//    public static boolean voikoSeuraavanSijoittaa(int rivi, int sarake) {
//        boolean voikoSijoittaa = false;
//        for (int i = -1; i < 2; i++) {
//            for (int j = -1; j < 2; j++) {
//                if ((rivi + i >= 0 && rivi + i < 10 && sarake + j >= 0 && sarake + j < 10)) {
//                    if ((onkoTyhja(rivi, sarake))) {
//                        voikoSijoittaa = true;
//                    }
//                }
//            }
//        }
//        return voikoSijoittaa;
//    }
    public static int muutaArvoaSatunnaisesti(int arvo) {
        int muutos = random.nextInt(3);//
        int uusiArvo = arvo + muutos - 1;
        return uusiArvo;
    }

    /**
     *
     */
    public void tulosta() {
        for (int rivi = 0; rivi < taulukko.length; ++rivi) {
            for (int sarake = 0; sarake < taulukko[rivi].length; ++sarake) {
                System.out.print(palautaMerkki(rivi, sarake));
            }
            System.out.print("\n");
        }
        System.out.println();
    }
}
