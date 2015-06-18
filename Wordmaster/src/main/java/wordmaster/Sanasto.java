package wordmaster;

import java.util.ArrayList;
import java.util.Random;

/**
 * Sanasto-luokan ilmentymän sisältämään ArrayListiin tallennetaan Sana-olioita.
 * Sanastosta voidaan palauttaa yksi satunnainen sana tai useamman sanan otos.
 */
public class Sanasto {

    /**
     * Pelissä käytettävä aineisto tallennetaan Sana-olioina tähän listaan
     */
    public static ArrayList sanat;

    /**
     *
     */
    static Random random;

    /**
     * Parametritön konstruktori
     */
    public Sanasto() {
        Sanasto.sanat = new ArrayList<>();
        Sanasto.random = new Random();
    }

    /**
     * Lisää parametrinä annetun Sana-olion ArrayListiin
     *
     * @param sana lisättävä Sana-olio
     * @return palauttaa arvon "true", jos lisäys onnistuu
     */
    public boolean lisaaSana(Sana sana) {
        Sanasto.sanat.add(sana);
        return true;
    }

    /**
     * Palauttaa sanalistasta yhden satunnaisen Sana-olion
     *
     * @return satunnainen Sana-olio
     */
    public Sana luoRandomSana() {
        Sana randomsana;
        int r = random.nextInt(sanat.size());
        randomsana = (Sana) sanat.get(r);
        return randomsana;
    }
}
