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

    public static ArrayList sanat;
    public static Random random;
    public static ArrayList otos;

    public Sanasto() {

        Sanasto.sanat = new ArrayList<>();
        Sanasto.random = new Random();
        Sanasto.otos = new ArrayList<>();

    }

    public boolean lisaaSana(Sana sana) {

        sanat.add(sana);

        return true;
    }

    public boolean tulostaSanat() {
        System.out.println("SANASTO: ");
        for (Object sanat1 : sanat) {
            System.out.println(sanat1);
        }
        return true;
    }

    public Sana getSana(int index) {
        return (Sana) sanat.get(index);
    }

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

    boolean luoRandomSana() {
        Sana rsana;
        int r = random.nextInt(sanat.size());
        rsana = (Sana) sanat.get(r);
        System.out.println(rsana);
        return true;
    }

    static class sanat {

        public sanat() {
        }
    }

}
