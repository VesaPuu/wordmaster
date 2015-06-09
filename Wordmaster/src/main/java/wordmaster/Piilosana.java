package wordmaster;

import java.util.Random;

/**
 * Piilosana-luokkaa tarvitaan Piilosana-pelin taulukon luomiseen. Luokan
 * välineillä taulukkoon voidaan sijoittaa sanoja satunnaisesti merkki
 * kerrallaan ja palauttaa tieto siitä, mikä merkki on missäkin taulukon
 * solussa.*
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
        // tehdään sanasta merkkitaulukko
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
        int sijoitettu = 0;
        char[] mtaulu = sanastaMerkkitaulukko(sana);
        while (sijoitettu < mtaulu.length) {
            tyhjennaKaikki();
            sijoitettu = 0;
            int rivi = random.nextInt(10); // arvotaan aloitusrivi
            int sarake = random.nextInt(10); // arvotaan aloitussarake
            for (int i = 0; i < mtaulu.length; i++) {  //sijoitetaan mtaulun merkit taulukkoon yksi kerrallaan
                taulukko[rivi][sarake] = mtaulu[i];
                int uusiRivi = muutaArvoaSatunnaisesti(rivi);
                int uusiSarake = muutaArvoaSatunnaisesti(sarake);
                if ((uusiRivi >= 0 && uusiRivi < 10 && uusiSarake >= 0 && uusiSarake < 10)) {
                    if ((onkoTyhja(uusiRivi, uusiSarake))) {//
                        rivi = uusiRivi;
                        sarake = uusiSarake;
                        sijoitettu++;
                    }
                }
            }
        }
        return true;
    }

    public static int muutaArvoaSatunnaisesti(int arvo) {
        int muutos = random.nextInt(3);//
        int uusiArvo = arvo + muutos - 1;
        return uusiArvo;
    }
}
