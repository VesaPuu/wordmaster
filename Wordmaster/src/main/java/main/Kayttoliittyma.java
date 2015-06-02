/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import wordmaster.Anagrammi;
import wordmaster.Sanasto;
import wordmaster.Sana;

/**
 *
 * @author Vesa
 */
public class Kayttoliittyma {

    Scanner lukija;
    Anagrammi anagrammi;
    private final Sanasto sanasto;

    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
        this.sanasto = Main.sanasto;

    }

    public void aloita() {
        System.out.println("Valitse peli:");
        System.out.println();
        System.out.println("1) Anagrammi");
        System.out.println("2) Piilosana [tulossa]");
        System.out.println("3) Laivanupotus [tulossa]");
        System.out.println("X) Lopeta");

        String valinta = lukija.nextLine();
        if (valinta.equals("x")) {
            lopeta();
        } else {
            if (valinta.equals("1")) {
                System.out.println("Käynnistetään anagrammi");
                aloitaAnagrammi();
            }
        }
    }

    public void aloitaAnagrammi() {
        Anagrammi anagrammi = new Anagrammi();
        int vihjeet = 2;
        Sana anagrammiksiMuutettava = Main.sanasto.luoRandomSana();
        String anagrammiSana = anagrammi.aloita(anagrammiksiMuutettava);
        System.out.println("Minkä sanan anagrammi on " + anagrammiSana + "?");
        System.out.println("Sanan ensimmäinen kirjain on " + anagrammiksiMuutettava.getSana().charAt(0) + ".");
        System.out.println("[x] lopettaa, [v] antaa vihjeen.");

        while (true) {
            String vastaus = lukija.nextLine();
            if (vastaus.equals("v")) {
                if (vihjeet == anagrammiSana.length()) {
                    System.out.print("Anagrammi on " + anagrammiSana + ", ja sana on " + anagrammiksiMuutettava.getSana());
                    System.out.println();
                    break;
                } else {
                    System.out.print("Anagrammi on " + anagrammiSana + ", ja sana alkaa ");
                    for (int i = 0; i < vihjeet; i++) {
                        System.out.print(anagrammiksiMuutettava.getSana().charAt(i));
                    }
                    System.out.println(" (" + vihjeet + "/" + anagrammiSana.length() + ")");
                    vihjeet++;
                    System.out.println();
                    continue;
                }
            }

            if (vastaus.equals("x") || vastaus.equals("X")) {
                System.out.println("Sana oli " + anagrammiksiMuutettava);
                break;
            }
//            if (vastaus.equals(anagrammiksiMuutettava.getSana()) || vastaus.toUpperCase().equals(anagrammiksiMuutettava.getSana())) {
            if (Anagrammi.ovatkoAnagrammeja(vastaus, anagrammiksiMuutettava.getSana())) {
// liää tähän tarkistus, onko sana sanalistassa
                System.out.println("Oikein!");
                break;
            } else {
                System.out.println("Väärin, yritä uudelleen tai lopeta [x]! [v] antaa vihjeen.");
                if (vastaus.equals("x")) {
                    break;
                }
            }
        }

        System.out.println("Uudestaan? Paina Enter, [x] lopettaa.");
        String vastaus = lukija.nextLine();
        if (vastaus.equals("x")) {
            aloita();
        }
        if (vastaus.equals("")) {
            aloitaAnagrammi();
        }

    }

    public void lopeta() {
        System.out.println("Kiitos ja näkemiin!");
    }

}
