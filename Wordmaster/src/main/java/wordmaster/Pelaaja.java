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

    public Pelaaja(String nimi) {

        this.nimi = nimi;
        this.pisteet = 0;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public String getNimi() {
        return this.nimi;
    }

    public boolean setPisteet(int pisteet) {
        this.pisteet = pisteet;
        return true;
    }

    public String toString() {

        return this.nimi + ", " + this.pisteet;
    }

}
