/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordmaster;

import java.util.Random;

/**
 *
 * @author Vesa
 */
public class Peli {

    public static char[][] taulukko;
    private static Random random;

    /**
     *
     */
    public Peli() {

        this.taulukko = new char[13][10];
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
    public char palautaMerkki(int rivi, int sarake) {
        char merkki = taulukko[rivi][sarake];
        return merkki;
    }

    public boolean onkoTyhja(int rivi, int sarake) {
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
    public char[] sanastaMerkkitaulukko(Sana sana) {
        // tehdÃ¤Ã¤n sanasta merkkitaulukko
        char[] mtaulu = sana.getSana().toCharArray();
        return mtaulu;
    }

    /**
     *
     * @param sana
     */
    public boolean sijoitaSana(Sana sana) {
        char[] mtaulu = sanastaMerkkitaulukko(sana);
        // arvotaan aloituskohta
        int rivi = random.nextInt(13);
        int sarake = random.nextInt(10);
        System.out.println(sana);//
        //sijoitetaan mtaulun merkit taulukkoon yksi kerrallaan
        for (int i = 0; i < mtaulu.length; i++) {

            taulukko[rivi][sarake] = mtaulu[i];
//            System.out.println(rivi + ", " + sarake);
            while (true) {
                int uusiRivi = muutaArvoaSatunnaisesti(rivi);
                int uusiSarake = muutaArvoaSatunnaisesti(sarake);
                if ((uusiRivi >= 0 && uusiRivi < 13 && uusiSarake >= 0 && uusiSarake < 10)) {
                    if ((onkoTyhja(uusiRivi, uusiSarake))) {//
                        rivi = uusiRivi;
                        sarake = uusiSarake;
                        break;
                    }
                }
            }
        }
        return true;
    }

    public int muutaArvoaSatunnaisesti(int arvo) {
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
