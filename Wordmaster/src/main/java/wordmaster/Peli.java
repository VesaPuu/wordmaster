package wordmaster;

import java.util.Random;

/**
 * Peli-luokka on Piilosana- ja Laivanupotus-luokkien yliluokka. taulukon
 * luomiseen. Luokan * välineillä taulukkoon voidaan sijoittaa sanoja
 * satunnaisesti merkki kerrallaan ja palauttaa tieto siitä, mikä merkki on
 * missäkin taulukon solussa.
 *
 * @author Vesa
 */
public class Peli {

    public static char[][] taulukko;
    protected static Random random;

    public Peli() {

    }

    /**
     * Metodi palauttaa tiedon siitä, mikä merkki (kirjain) on parametriksi
     * annettujen rivin ja sarakkeen määrittämässä solussa.
     *
     * @param rivi määrittää taulukon rivin
     * @param sarake määrittää taulukon sarakkeen
     * @return
     */
    public static String palautaMerkki(int rivi, int sarake) {
        char merkki = taulukko[rivi][sarake];
        String kirjain = "" + merkki;
        return kirjain;
    }

    /**
     * Metodi testaa, onko rivi- ja sarakeparametrien määrittämä taulukon solu
     * tyhjä vai ei.
     *
     * @param rivi
     * @param sarake
     * @return
     */
    public static boolean onkoTyhja(int rivi, int sarake) {
        char merkki = taulukko[rivi][sarake];
        if (merkki == 0) {
            return true;
        }
        return false;
    }

    /**
     * Metodi tekee parametriksi annetusta sanasta merkkitaulukon.
     *
     * @param sana
     * @return
     */
    public static char[] sanastaMerkkitaulukko(Sana sana) {
        // tehdään sanasta merkkitaulukko
        char[] mtaulu = sana.getSana().toCharArray();
        return mtaulu;
    }

    /**
     * Metodi muuttaa satunnaisesti parametriksi annettua lukemaa siten, että
     * muutos on joko -1, 0 tai +1.
     *
     * @param arvo muutettava lukema
     * @return
     */
    public static int muutaArvoaSatunnaisesti(int arvo) {
        int muutos = random.nextInt(3); //
        int uusiArvo = arvo + muutos - 1;
        return uusiArvo;
    }

    /**
     * Metodi lisää taulukkoon parametriksi annetun merkin.
     *
     * @param rivi määrittää taulukon rivin
     * @param sarake määrittää taulukon sarakkeen
     * @param merkki lisättävä merkki
     * @return
     */
    public boolean lisaaMerkki(int rivi, int sarake, char merkki) {
        taulukko[rivi][sarake] = merkki;
        return true;
    }

}
