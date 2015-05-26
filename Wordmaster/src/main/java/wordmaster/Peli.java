/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordmaster;

/**
 *
 * @author Vesa
 */
public class Peli {

    char[][] taulukko;

    public Peli() {

        this.taulukko = new char[13][10];

    }

    public boolean lisaaMerkki(int rivi, int sarake, char merkki) {

        taulukko[rivi][sarake] = merkki;
        return true;
    }

    public char palautaMerkki(int rivi, int sarake) {
        char merkki = taulukko[rivi][sarake];
        return merkki;
    }

    public char[] sanastaMerkkitaulukko(Sana sana) {

        // tehdään sanasta merkkitaulukko
        char[] mtaulu = sana.getSana().toCharArray();
        return mtaulu;

    }

    public void sijoitaSana(Sana sana) {

        char[] mtaulu = sanastaMerkkitaulukko(sana);

        for (int i = 0; i < mtaulu.length; i++) {

            taulukko[i][i] = mtaulu[i];
        }
    }

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
