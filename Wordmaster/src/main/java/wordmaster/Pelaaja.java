package wordmaster;

/**
 * Pelaaja-luokan ilmentymät sisältävät tiedon pelaajan nimestä ja hänen
 * pisteistään. Luokan välineillä pelaajalle voidaan asettaa haluttu pistemäärä.
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

    public int getPisteet() {
        return this.pisteet;
    }

    public String getNimi() {
        return this.nimi;
    }

    /**
     *
     * @param pisteet
     * @return
     */
    public boolean setPisteet(int uusiArvo) {
        this.pisteet = uusiArvo;
        return true;
    }

    public boolean lisaaPisteet(int lisays) {
        this.pisteet = pisteet + lisays;
        return true;
    }

    public String toString() {

        return this.nimi + ", " + this.pisteet;
    }

}
