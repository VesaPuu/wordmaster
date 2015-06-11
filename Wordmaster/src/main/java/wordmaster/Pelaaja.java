package wordmaster;

/**
 * Pelaaja-luokan ilmentymät sisältävät tiedon pelaajan nimestä ja hänen
 * pisteistään eri peleissä. Luokan välineillä pelaajalle voidaan asettaa
 * haluttu pistemäärä.
 *
 * @author Vesa
 */
public class Pelaaja {

    String nimi;
    int anagrammiPisteet;
    int piilosanaPisteet;
    int laivanupotusPisteet;

    /**
     *
     * @param nimi
     */
    public Pelaaja(String nimi) {

        this.nimi = nimi;
        this.anagrammiPisteet = 0;
        this.piilosanaPisteet = 0;
        this.laivanupotusPisteet = 0;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getAnagrammiPisteet() {
        return this.anagrammiPisteet;
    }

    public int getPiilosanaPisteet() {
        return this.piilosanaPisteet;
    }

    public int getLaivanupotusPisteet() {
        return this.laivanupotusPisteet;
    }

    public boolean setAnagrammiPisteet(int uusiArvo) {
        this.anagrammiPisteet = uusiArvo;
        return true;
    }

    public boolean setPiilosanaPisteet(int uusiArvo) {
        this.piilosanaPisteet = uusiArvo;
        return true;
    }

    public boolean setLaivanupotusPisteet(int uusiArvo) {
        this.laivanupotusPisteet = uusiArvo;
        return true;
    }

    public boolean lisaaAnagrammiPisteet(int lisays) {
        this.anagrammiPisteet = anagrammiPisteet + lisays;
        return true;
    }

    public boolean lisaaPiilosanaPisteet(int lisays) {
        this.piilosanaPisteet = piilosanaPisteet + lisays;
        return true;
    }

    public boolean lisaaLaivanupotusPisteet(int lisays) {
        this.laivanupotusPisteet = laivanupotusPisteet + lisays;
        return true;
    }

    public String toString() {

        return this.nimi + ", " + this.anagrammiPisteet + ", " + this.piilosanaPisteet + ", " + this.laivanupotusPisteet;
    }

}
