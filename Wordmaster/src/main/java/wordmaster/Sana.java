package wordmaster;

/**
 * Sana-luokan ilmentymät sisältävät jonkin sanan ja tiedon sen pituudesta.
 */
public class Sana {

    String sana;
    static int pituus;

    /**
     * Konstruktori luo Sana-olion parametriksi annetusta sanasta.
     *
     * @param sana
     */
    public Sana(String sana) {

        this.sana = sana.toUpperCase();
        this.pituus = sana.length();
    }

    public int getPituus() {
        return this.pituus;
    }

    public String getSana() {
        return this.sana;
    }

    public String toString() {
        return this.sana;
    }
}
