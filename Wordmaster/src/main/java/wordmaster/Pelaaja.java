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
public class Pelaaja {

    String nimi;
    int pisteet;

    /**
     *
     * @param nimi
     */
    public Pelaaja(String nimi) {

        this.nimi = nimi;
        this.pisteet = 0;
    }

    /**
     *
     * @return
     */
    public int getPisteet() {
        return this.pisteet;
    }

    /**
     *
     * @return
     */
    public String getNimi() {
        return this.nimi;
    }

    /**
     *
     * @param pisteet
     * @return
     */
    public boolean setPisteet(int pisteet) {
        this.pisteet = pisteet;
        return true;
    }

    public String toString() {

        return this.nimi + ", " + this.pisteet;
    }

}
