/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordmaster;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Vesa
 */
public class Sanasto {

    /**
     *
     */
    public static ArrayList sanat;

    /**
     * Pelissä käytettävä aineisto tallennetaan Sana-olioina tähän listaan
     */
    private static Random random;

    /**
     * ArrayListin sanat osajoukko, joka koostuu satunnaisesti valituista
     * Sana-olioista
     */
    public static ArrayList otos;

    /**
     * Parametritön konstruktori
     */
    public Sanasto() {

        Sanasto.sanat = new ArrayList<>();
        Sanasto.random = new Random();
        Sanasto.otos = new ArrayList<>();

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
     * Tulostaa koko ArrayListin sisällön (testikäyttöä varten)
     *
     * @return palauttaa arvon "true", jos tulostus onnistuu
     */
    public boolean tulostaSanat() {
        System.out.println("SANASTO: ");
        for (Object sanat1 : sanat) {
            System.out.println(sanat1);
        }
        return true;
    }

    /**
     * Palauttaa Sana-olion indeksin perusteella
     *
     * @param index indeksi
     * @return indeksiä vastaava Sana-olio
     */
    public Sana getSana(int index) {
        return (Sana) sanat.get(index);
    }

    /**
     * Luo sanalistasta halutun kokoisen otoksen satunnaisia Sana-olioita, joka
     * tallennetaan ArrayListiin otos
     *
     * @param kpl otoksen koko
     * @return palauttaa arvon "true", jos tulostus onnistuu
     */
    public boolean luoOtos(int kpl) {
        ArrayList kopio = sanat;
        for (int i = 0; i < kpl; i++) {
            int r = random.nextInt(kopio.size());
            otos.add(kopio.get(r));
            kopio.remove(r);
        }
        System.out.println(otos);
        return true;
    }

    /**
     * Palauttaa sanalistasta yhden satunnaisen Sana-olion
     *
     * @return satunnainen Sana-olio
     */
    public Sana luoRandomSana() {
        Sana rsana;
        int r = random.nextInt(sanat.size());
        rsana = (Sana) sanat.get(r);
        return rsana;
    }

}
