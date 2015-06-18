package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import wordmaster.Pelaaja;
import wordmaster.Piilosana;
import wordmaster.Sana;
import wordmaster.Laivanupotus;

public class GraafinenKayttoliittyma extends javax.swing.JFrame implements ActionListener {

    static TiedostonLukija tl;
    Piilosana piilosana;
    Laivanupotus laivanupotus;
    Pelaaja pelaaja;
    static int vihjeet;
    int sananPituus;
    int laivanupotusKlikkaus;
    int laivanupotusOsuma;
    String anagrammiSana;
    Sana anagrammiksiMuutettava;
    String vihjeteksti;
    String piilosanaVastaus;
    String etsittavaSana;
    String upotettavaSana;
    private static Random random;
    private static JButton[] laivanupotusNapit = new JButton[25];
    private static JButton[] piilosanaNapit = new JButton[100];

    /**
     * Creates new form GraafinenKayttoliittyma
     */
    public GraafinenKayttoliittyma() throws FileNotFoundException, Exception {
        initComponents();
        pelaajanNimi.setText("");
        anagrammiKentta.setText("");
        upotettavaKentta.setText("");
        klikkaukset.setText("");
        osumat.setText("");
        pelaajanNimi.addActionListener(this);
        vastaaNappi.addActionListener(this);
        vastaus.addActionListener(this);
        anagrammiNappi.addActionListener(this);
        piilosanaNappi.addActionListener(this);
        laivanupotusNappi.addActionListener(this);
        vihjeNappi.addActionListener(this);
        lopetaNappi.addActionListener(this);
        uudelleenNappi.addActionListener(this);//
        okNappi.addActionListener(this);
        piilosanaVastaaNappi.addActionListener(this);
        piilosanaUudelleenNappi.addActionListener(this);
        laivanupotusUudelleen.addActionListener(this);
        this.tl = new TiedostonLukija();
        tl.lueTiedosto();
        this.piilosana = new Piilosana();
        this.laivanupotus = new Laivanupotus();
        this.vihjeet = 0;
        this.sananPituus = 0;
        this.laivanupotusKlikkaus = 0;
        this.laivanupotusOsuma = 0;
        String anagrammiSana;
        this.random = new Random();
        valitsePaneeli.setVisible(false);
        anagrammiPaneeli.setVisible(false);
        piilosanaPaneeli.setVisible(false);
        laivanupotusPaneeli.setVisible(false);
        lopetaPaneeli.setVisible(false);
    }

    public void aloita() {
        annaNimi.setVisible(false);
        pelaajanNimi.setVisible(false);
        okNappi.setVisible(false);
        String nimi = pelaaja.getNimi();
        valitse.setText("Tervetuloa " + nimi + "! Valitse peli:");
        for (int i = 0; i < laivanupotusNapit.length; i++) {
            JButton nappi1 = new JButton(" ");
            laivanupotusNapit[i] = nappi1;
            nappi1.addActionListener(this);
            nappi1.setBackground(Color.black);
            laivanupotusNapitPaneeli.add(nappi1);
        }
        for (int i = 0; i < piilosanaNapit.length; i++) {
            JButton nappi2 = new JButton(" ");
            piilosanaNapit[i] = nappi2;
            nappi2.addActionListener(this);
//            nappi2.setBackground(Color.black);
            piilosanaNapitPaneeli.add(nappi2);
        }
        repaint();
    }

    public void aloitaAnagrammi() {
        vihjeet = 1;
        vastaus.setText("");
        tuomioKentta.setText("");
        vastaus.setVisible(true);
        uudelleenNappi.setVisible(false);
        vihjeNappi.setVisible(true);
        vastaaNappi.setVisible(true);
        vihjeita.setVisible(true);
        anagrammiksiMuutettava = tl.sanasto.luoRandomSana();
        String anagrammiSana = randomAnagrammi(anagrammiksiMuutettava.getSana());
        sananPituus = anagrammiSana.length();
        anagrammiKentta.setText(anagrammiSana);
        vihjeteksti = Character.toString(anagrammiksiMuutettava.getSana().charAt(0));
        vihje.setText("Sana alkaa " + vihjeteksti);
        vihjeita.setText("Vihjeet " + vihjeet + ", sanan pituus " + sananPituus);
    }

    public void aloitaPiilosana() {
        piilosana.tyhjennaKaikki();
        piilosanaVastaus = "";
        etsittavaSana = "";
        piilosanaVastausKentta.setText("Vastaus: ");
        Sana sijoitettava = tl.sanasto.luoRandomSana();
        piilosana.sijoitaSana(sijoitettava);
        piilosana.taytaKaikki();
        etsittavaSana = sijoitettava.getSana();
        etsittava.setText(etsittavaSana);
        int j = 0;
        int k = 0;
        for (int i = 0; i < piilosanaNapit.length; i++) {

            piilosanaNapit[i].setBackground(Color.LIGHT_GRAY);
            piilosanaNapit[i].setText(piilosana.palautaMerkki(k, j));
//            piilosanaNapit[i].setText("" + k + ", " + j);
            j++;
            if (j == 10) {
                j = 0;
                k++;
                if (k == 10) {
                    k = 0;
                }
            }
        }
    }

    public void aloitaLaivanupotus() {
        laivanupotus.tyhjennaKaikki();
        upotettavaSana = "";
        laivanupotusKlikkaus = 0;
        laivanupotusOsuma = 0;
        klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
        osumat.setText("Osumia: " + laivanupotusOsuma);
        Sana upotettava = tl.sanasto.luoRandomSana();
        laivanupotus.sijoitaSana(upotettava);//
        upotettavaSana = upotettava.getSana();
        upotettavaKentta.setText(upotettavaSana);
        for (int i = 0; i < laivanupotusNapit.length; i++) {
            laivanupotusNapit[i].setBackground(Color.black);
        }
    }

    public static boolean ovatkoAnagrammeja(String sana, String anagrammi) {

        if (sana.length() != anagrammi.length()) {
            return false;
        }
        char[] merkit = sana.toUpperCase().toCharArray();
        for (char m : merkit) {
            int index = anagrammi.indexOf(m);
            if (index != -1) {
                anagrammi = anagrammi.substring(0, index) + anagrammi.substring(index + 1, anagrammi.length());
            } else {
                return false;
            }
        }
        return anagrammi.isEmpty();
    }

    public String randomAnagrammi(String input) {
        char[] mtaulu = input.toCharArray();
        String anagrammi = "";
        int pituus = input.length();
        for (int i = 0; i < input.length(); i++) {
            while (true) {
                int r = random.nextInt(pituus);
                if (mtaulu[r] != 0) {
                    anagrammi = anagrammi + mtaulu[r];
                    mtaulu[r] = 0;
                    break;
                }
            }
        }
        return anagrammi;
    }

    public boolean upotettuLoytyi() {
        int pisteet;
        if (laivanupotusOsuma == upotettavaSana.length()) {
            upotettavaKentta.setText("Löytyi!");
            pisteet = pelaaja.getLaivanupotusPisteet() + (25 - laivanupotusKlikkaus + laivanupotusOsuma);
            pelaaja.setLaivanupotusPisteet(pisteet);
            return true;
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {

        Object aiheuttaja = e.getSource();

        if (e.getSource().equals(okNappi) || aiheuttaja == pelaajanNimi) {
            this.pelaaja = new Pelaaja(pelaajanNimi.getText());

//            kirjoitin.avaa("pelaajat.txt");
//            kirjoitin.kirjoita(pelaaja.toString());
//            kirjoitin.sulje();
            valitsePaneeli.setVisible(true);
            aloita();
        }

        if (e.getSource().equals(anagrammiNappi)) {
            anagrammiPaneeli.setVisible(true);
            piilosanaPaneeli.setVisible(false);
            laivanupotusPaneeli.setVisible(false);
            lopetaPaneeli.setVisible(true);
            aloitaAnagrammi();
        }

        if (e.getSource().equals(piilosanaNappi)) {
            anagrammiPaneeli.setVisible(false);
            piilosanaPaneeli.setVisible(true);
            laivanupotusPaneeli.setVisible(false);
            lopetaPaneeli.setVisible(true);
            aloitaPiilosana();
        }

        if (e.getSource().equals(laivanupotusNappi)) {
            anagrammiPaneeli.setVisible(false);
            piilosanaPaneeli.setVisible(false);
            laivanupotusPaneeli.setVisible(true);
            lopetaPaneeli.setVisible(true);
            aloitaLaivanupotus();
        }

        if (e.getSource().equals(vastaaNappi) || aiheuttaja == vastaus) {
            tuomioKentta.setText("");

            if (ovatkoAnagrammeja(vastaus.getText(), anagrammiksiMuutettava.getSana())) {

                anagrammiKentta.setText("");
                vihje.setText("");
                tuomioKentta.setText("Oikein!");
                vihjeNappi.setVisible(false);
                vastaus.setVisible(false);
                vastaaNappi.setVisible(false);
                uudelleenNappi.setVisible(true);
                anagrammiOtsikko.setVisible(false);
                repaint();
            } else {
                tuomioKentta.setText("Väärin! Yritä vielä!");
            }
        }

        if (e.getSource().equals(vihjeNappi)) {
            tuomioKentta.setText("");
            vastaus.setText("");
            vihjeet++;

            if (vihjeet == sananPituus) {
                vastaus.setVisible(false);
                vihje.setText("Sana on " + anagrammiksiMuutettava);
                vihjeNappi.setVisible(false);
                vastaaNappi.setVisible(false);
                vihjeita.setVisible(false);
                uudelleenNappi.setVisible(true);

            } else {

                vihjeteksti = vihjeteksti + Character.toString(anagrammiksiMuutettava.getSana().charAt(vihjeet - 1));
                vihje.setText("Sana alkaa " + vihjeteksti);
                vihjeita.setText("Vihjeet " + vihjeet + ", sanan pituus " + sananPituus);
                repaint();
            }
        }

        if (e.getSource().equals(uudelleenNappi)) {
            aloitaAnagrammi();
        }

        if (e.getSource().equals(piilosanaUudelleenNappi)) {
            aloitaPiilosana();
        }

        if (e.getSource().equals(lopetaNappi)) {
            anagrammiPaneeli.setVisible(false);
            piilosanaPaneeli.setVisible(false);
            laivanupotusPaneeli.setVisible(false);
            lopetaPaneeli.setVisible(false);
            anagrammiNappi.setVisible(false);
            piilosanaNappi.setVisible(false);
            laivanupotusNappi.setVisible(false);
            valitse.setText("Kiitos ja näkemiin!");
            repaint();
        }

        if (e.getSource().equals(piilosanaVastaaNappi)) {
            if (etsittavaSana.equals(piilosanaVastaus)) {
                etsittava.setText("Oikein!");
            } else {
                etsittava.setText("Yritä vielä! Sana oli " + etsittavaSana);
            }
//            repaint();
        }

        if (e.getSource().equals(laivanupotusUudelleen)) {
            aloitaLaivanupotus();
        }

        if (aiheuttaja == piilosanaNapit[0]) {

            if (piilosanaNapit[0].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[0].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[0].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[0].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[1]) {
            if (piilosanaNapit[1].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[1].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[1].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[1].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[2]) {
            if (piilosanaNapit[2].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[2].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[2].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[2].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[3]) {
            if (piilosanaNapit[3].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[3].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[3].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[3].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[4]) {
            if (piilosanaNapit[4].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[4].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[4].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[4].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[5]) {
            if (piilosanaNapit[5].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[5].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[5].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[5].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[6]) {
            if (piilosanaNapit[6].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[6].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[6].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[6].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[7]) {
            if (piilosanaNapit[7].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[7].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[7].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[7].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[8]) {
            if (piilosanaNapit[8].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[8].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[8].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[8].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[9]) {
            if (piilosanaNapit[9].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[9].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[9].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[9].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[10]) {
            if (piilosanaNapit[10].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[10].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[10].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[10].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[11]) {
            if (piilosanaNapit[11].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[11].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[11].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[11].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[12]) {
            if (piilosanaNapit[12].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[12].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[12].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[12].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[13]) {
            if (piilosanaNapit[13].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[13].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[13].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[13].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[14]) {
            if (piilosanaNapit[14].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[14].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[14].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[14].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[15]) {
            if (piilosanaNapit[15].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[15].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[15].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[15].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[16]) {
            if (piilosanaNapit[16].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[16].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[16].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[16].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[17]) {
            if (piilosanaNapit[17].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[17].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[17].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[17].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[18]) {
            if (piilosanaNapit[18].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[18].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[18].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[18].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[19]) {
            if (piilosanaNapit[19].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[19].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[19].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[19].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[20]) {
            if (piilosanaNapit[20].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[20].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[20].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[20].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[21]) {
            if (piilosanaNapit[21].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[21].setBackground(Color.LIGHT_GRAY);
            } else {

                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[21].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[21].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[22]) {
            if (piilosanaNapit[22].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[22].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[22].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[22].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[23]) {
            if (piilosanaNapit[23].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[23].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[23].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[23].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[24]) {
            if (piilosanaNapit[24].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[24].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[24].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[24].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[25]) {
            if (piilosanaNapit[25].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[25].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[25].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[25].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[26]) {
            if (piilosanaNapit[26].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[26].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[26].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[26].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[27]) {
            if (piilosanaNapit[27].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[27].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[27].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[27].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[28]) {
            if (piilosanaNapit[28].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[28].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[28].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[28].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[29]) {
            if (piilosanaNapit[29].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[29].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[29].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[29].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[30]) {
            if (piilosanaNapit[30].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[30].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[30].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[30].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[31]) {
            if (piilosanaNapit[31].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[31].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[31].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[31].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[32]) {
            if (piilosanaNapit[32].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[32].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[32].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[32].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[33]) {
            if (piilosanaNapit[33].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[33].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[33].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[33].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[34]) {
            if (piilosanaNapit[34].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[34].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[34].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[34].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[35]) {
            if (piilosanaNapit[35].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[35].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[35].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[35].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[36]) {
            if (piilosanaNapit[36].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[36].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[36].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[36].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[37]) {
            if (piilosanaNapit[37].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[37].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[37].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[37].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[38]) {
            if (piilosanaNapit[38].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[38].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[38].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[38].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[39]) {
            if (piilosanaNapit[39].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[39].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[39].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[39].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[40]) {
            if (piilosanaNapit[40].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[40].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[40].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[40].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[41]) {
            if (piilosanaNapit[41].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[41].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[41].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[41].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[42]) {
            if (piilosanaNapit[42].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[42].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[42].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[42].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[43]) {
            if (piilosanaNapit[43].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[43].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[43].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[43].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[44]) {
            if (piilosanaNapit[44].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[44].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[44].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[44].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[45]) {
            if (piilosanaNapit[45].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[45].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[45].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[45].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[46]) {
            if (piilosanaNapit[46].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[46].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[46].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[46].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[47]) {
            if (piilosanaNapit[47].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[47].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[47].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[47].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[48]) {
            if (piilosanaNapit[48].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[48].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[48].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[48].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[49]) {
            if (piilosanaNapit[49].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[49].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[49].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[49].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[50]) {
            if (piilosanaNapit[50].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[50].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[50].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[50].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[51]) {
            if (piilosanaNapit[51].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[51].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[51].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[51].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[52]) {
            if (piilosanaNapit[52].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[52].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[52].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[52].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[53]) {
            if (piilosanaNapit[53].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[53].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[53].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[53].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[54]) {
            if (piilosanaNapit[54].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[54].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[54].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[54].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[55]) {
            if (piilosanaNapit[55].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[55].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[55].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[55].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[56]) {
            if (piilosanaNapit[56].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[56].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[56].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[56].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[57]) {
            if (piilosanaNapit[57].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[57].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[57].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[57].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[58]) {
            if (piilosanaNapit[58].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[58].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[58].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[58].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[59]) {
            if (piilosanaNapit[59].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[59].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[59].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[59].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[60]) {
            if (piilosanaNapit[60].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[60].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[60].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[60].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[61]) {
            if (piilosanaNapit[61].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[61].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[61].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[61].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[62]) {
            if (piilosanaNapit[62].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[62].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[62].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[62].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[63]) {
            if (piilosanaNapit[63].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[63].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[63].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[63].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[64]) {
            if (piilosanaNapit[64].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[64].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[64].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[64].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[65]) {
            if (piilosanaNapit[65].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[65].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[65].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[65].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[66]) {
            if (piilosanaNapit[66].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[66].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[66].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[66].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[67]) {
            if (piilosanaNapit[67].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[67].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[67].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[67].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[68]) {
            if (piilosanaNapit[68].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[68].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[68].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[68].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[69]) {
            if (piilosanaNapit[69].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[69].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[69].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[69].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[70]) {
            if (piilosanaNapit[70].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[70].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[70].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[70].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[71]) {
            if (piilosanaNapit[71].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[71].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[71].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[71].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[72]) {
            if (piilosanaNapit[72].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[72].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[72].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[72].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[73]) {
            if (piilosanaNapit[73].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[73].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[73].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[73].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[74]) {
            if (piilosanaNapit[74].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[74].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[74].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[74].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[75]) {
            if (piilosanaNapit[75].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[75].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[75].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[75].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[76]) {
            if (piilosanaNapit[76].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[76].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[76].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[76].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[77]) {
            if (piilosanaNapit[77].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[77].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[77].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[77].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[78]) {
            if (piilosanaNapit[78].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[78].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[78].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[78].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[79]) {
            if (piilosanaNapit[79].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[79].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[79].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[79].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[80]) {
            if (piilosanaNapit[80].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[80].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[80].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[80].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[81]) {
            if (piilosanaNapit[81].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[81].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[81].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[81].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[82]) {
            if (piilosanaNapit[82].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[82].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[82].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[82].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[83]) {
            if (piilosanaNapit[83].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[83].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[83].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[83].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[84]) {
            if (piilosanaNapit[84].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[84].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[84].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[84].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[85]) {
            if (piilosanaNapit[85].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[85].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[85].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[85].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[86]) {
            if (piilosanaNapit[86].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[86].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[86].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[86].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[87]) {
            if (piilosanaNapit[87].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[87].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[87].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[87].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[88]) {
            if (piilosanaNapit[88].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[88].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[88].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[88].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[89]) {
            if (piilosanaNapit[89].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[89].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[89].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[89].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[90]) {
            if (piilosanaNapit[90].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[90].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[90].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[90].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[91]) {
            if (piilosanaNapit[91].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[91].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[91].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[91].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[92]) {
            if (piilosanaNapit[92].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[92].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[92].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[92].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[93]) {
            if (piilosanaNapit[93].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[93].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[93].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[93].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[94]) {
            if (piilosanaNapit[94].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[94].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[94].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[94].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[95]) {
            if (piilosanaNapit[95].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[95].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[95].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[95].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[96]) {
            if (piilosanaNapit[96].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[96].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[96].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[96].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[97]) {
            if (piilosanaNapit[97].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[97].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[97].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[97].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[98]) {
            if (piilosanaNapit[98].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[98].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[98].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[98].setBackground(Color.green);
            }
        }
        if (aiheuttaja == piilosanaNapit[99]) {
            if (piilosanaNapit[99].getBackground().equals(Color.green)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[99].setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + piilosanaNapit[99].getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                piilosanaNapit[99].setBackground(Color.green);
            }
        }

        if (aiheuttaja == laivanupotusNapit[0]) {
            if (laivanupotusNapit[0].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[0].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[0].setText(laivanupotus.palautaMerkki(0, 0));
                if (!laivanupotus.onkoTyhja(0, 0)) {
                    laivanupotusNapit[0].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[1]) {
            if (laivanupotusNapit[1].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[1].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[1].setText(laivanupotus.palautaMerkki(0, 1));
                if (!laivanupotus.onkoTyhja(0, 1)) {
                    laivanupotusNapit[1].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[1]) {
            if (laivanupotusNapit[1].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[1].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[1].setText(laivanupotus.palautaMerkki(0, 1));
                if (!laivanupotus.onkoTyhja(0, 1)) {
                    laivanupotusNapit[1].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[2]) {
            if (laivanupotusNapit[2].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[2].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[2].setText(laivanupotus.palautaMerkki(0, 2));
                if (!laivanupotus.onkoTyhja(0, 2)) {
                    laivanupotusNapit[2].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[3]) {
            if (laivanupotusNapit[3].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[3].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[3].setText(laivanupotus.palautaMerkki(0, 3));
                if (!laivanupotus.onkoTyhja(0, 3)) {
                    laivanupotusNapit[3].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[4]) {
            if (laivanupotusNapit[4].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[4].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[4].setText(laivanupotus.palautaMerkki(0, 4));
                if (!laivanupotus.onkoTyhja(0, 4)) {
                    laivanupotusNapit[4].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[5]) {
            if (laivanupotusNapit[5].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[5].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[5].setText(laivanupotus.palautaMerkki(1, 0));
                if (!laivanupotus.onkoTyhja(1, 0)) {
                    laivanupotusNapit[5].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[6]) {
            if (laivanupotusNapit[6].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[6].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[6].setText(laivanupotus.palautaMerkki(1, 1));
                if (!laivanupotus.onkoTyhja(1, 1)) {
                    laivanupotusNapit[6].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[7]) {
            if (laivanupotusNapit[7].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[7].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[7].setText(laivanupotus.palautaMerkki(1, 2));
                if (!laivanupotus.onkoTyhja(1, 2)) {
                    laivanupotusNapit[7].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[8]) {
            if (laivanupotusNapit[8].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[8].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[8].setText(laivanupotus.palautaMerkki(1, 3));
                if (!laivanupotus.onkoTyhja(1, 3)) {
                    laivanupotusNapit[8].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[9]) {
            if (laivanupotusNapit[9].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[9].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[9].setText(laivanupotus.palautaMerkki(1, 4));
                if (!laivanupotus.onkoTyhja(1, 4)) {
                    laivanupotusNapit[9].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[10]) {
            if (laivanupotusNapit[10].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[10].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[10].setText(laivanupotus.palautaMerkki(2, 0));
                if (!laivanupotus.onkoTyhja(2, 0)) {
                    laivanupotusNapit[10].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[11]) {
            if (laivanupotusNapit[11].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[11].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[11].setText(laivanupotus.palautaMerkki(2, 1));
                if (!laivanupotus.onkoTyhja(2, 1)) {
                    laivanupotusNapit[11].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[12]) {
            laivanupotusKlikkaus++;
            if (laivanupotusNapit[12].getBackground().equals(Color.BLACK)) { //
                laivanupotusNapit[12].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[12].setText(laivanupotus.palautaMerkki(2, 2));
                if (!laivanupotus.onkoTyhja(2, 2)) {
                    laivanupotusNapit[12].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[13]) {
            laivanupotusKlikkaus++;
            if (laivanupotusNapit[13].getBackground().equals(Color.BLACK)) { //
                laivanupotusNapit[13].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[13].setText(laivanupotus.palautaMerkki(2, 3));
                if (!laivanupotus.onkoTyhja(2, 3)) {
                    laivanupotusNapit[13].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[14]) {
            laivanupotusKlikkaus++;
            if (laivanupotusNapit[14].getBackground().equals(Color.BLACK)) { //
                laivanupotusNapit[14].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[14].setText(laivanupotus.palautaMerkki(2, 4));
                if (!laivanupotus.onkoTyhja(2, 4)) {
                    laivanupotusNapit[14].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[15]) {
            if (laivanupotusNapit[15].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[15].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[15].setText(laivanupotus.palautaMerkki(3, 0));
                if (!laivanupotus.onkoTyhja(3, 0)) {
                    laivanupotusNapit[15].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[16]) {
            if (laivanupotusNapit[16].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[16].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[16].setText(laivanupotus.palautaMerkki(3, 1));
                if (!laivanupotus.onkoTyhja(3, 1)) {
                    laivanupotusNapit[16].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[17]) {
            if (laivanupotusNapit[17].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[17].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[17].setText(laivanupotus.palautaMerkki(3, 2));
                if (!laivanupotus.onkoTyhja(3, 2)) {
                    laivanupotusNapit[17].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[18]) {
            if (laivanupotusNapit[18].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[18].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[18].setText(laivanupotus.palautaMerkki(3, 3));
                if (!laivanupotus.onkoTyhja(3, 3)) {
                    laivanupotusNapit[18].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[19]) {
            if (laivanupotusNapit[19].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[19].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[19].setText(laivanupotus.palautaMerkki(3, 4));
                if (!laivanupotus.onkoTyhja(3, 4)) {
                    laivanupotusNapit[19].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[20]) {
            if (laivanupotusNapit[20].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[20].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[20].setText(laivanupotus.palautaMerkki(4, 0));
                if (!laivanupotus.onkoTyhja(4, 0)) {
                    laivanupotusNapit[20].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[21]) {
            if (laivanupotusNapit[21].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[21].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[21].setText(laivanupotus.palautaMerkki(4, 1));
                if (!laivanupotus.onkoTyhja(4, 1)) {
                    laivanupotusNapit[21].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[22]) {
            if (laivanupotusNapit[22].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[22].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[22].setText(laivanupotus.palautaMerkki(4, 2));
                if (!laivanupotus.onkoTyhja(4, 2)) {
                    laivanupotusNapit[22].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[23]) {
            if (laivanupotusNapit[23].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[23].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[23].setText(laivanupotus.palautaMerkki(4, 3));
                if (!laivanupotus.onkoTyhja(4, 3)) {
                    laivanupotusNapit[23].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }

        if (aiheuttaja == laivanupotusNapit[24]) {
            if (laivanupotusNapit[24].getBackground().equals(Color.BLACK)) { //
                laivanupotusKlikkaus++;
                laivanupotusNapit[24].setBackground(Color.LIGHT_GRAY);
                klikkaukset.setText("Arvauksia: " + laivanupotusKlikkaus);
                laivanupotusNapit[24].setText(laivanupotus.palautaMerkki(4, 4));
                if (!laivanupotus.onkoTyhja(4, 4)) {
                    laivanupotusNapit[24].setBackground(Color.GREEN);
                    laivanupotusOsuma++;
                    osumat.setText("Osumia: " + laivanupotusOsuma);
                    upotettuLoytyi();
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anagrammiPaneeli = new javax.swing.JPanel();
        anagrammiOtsikko = new javax.swing.JLabel();
        anagrammiKentta = new javax.swing.JLabel();
        vihje = new javax.swing.JLabel();
        vastaus = new javax.swing.JFormattedTextField();
        vastaaNappi = new javax.swing.JButton();
        vihjeNappi = new javax.swing.JButton();
        vihjeita = new javax.swing.JLabel();
        uudelleenNappi = new javax.swing.JButton();
        tuomioKentta = new javax.swing.JLabel();
        ylaPaneeli = new javax.swing.JPanel();
        annaNimi = new javax.swing.JLabel();
        pelaajanNimi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        okNappi = new javax.swing.JButton();
        piilosanaPaneeli = new javax.swing.JPanel();
        piilosanaOtsikko = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        piilosanaOhje = new javax.swing.JTextArea();
        piilosanaVastausKentta = new javax.swing.JLabel();
        etsittava = new javax.swing.JLabel();
        piilosanaNapitPaneeli = new javax.swing.JPanel();
        piilosanaVastaaNappi = new javax.swing.JButton();
        piilosanaUudelleenNappi = new javax.swing.JButton();
        laivanupotusPaneeli = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        laivanupotusOtsikko = new javax.swing.JLabel();
        upotettavaKentta = new javax.swing.JLabel();
        klikkaukset = new javax.swing.JLabel();
        osumat = new javax.swing.JLabel();
        laivanupotusUudelleen = new javax.swing.JButton();
        laivanupotusNapitPaneeli = new javax.swing.JPanel();
        lopetaPaneeli = new javax.swing.JPanel();
        lopetaNappi = new javax.swing.JButton();
        valitsePaneeli = new javax.swing.JPanel();
        valitse = new javax.swing.JLabel();
        anagrammiNappi = new javax.swing.JButton();
        piilosanaNappi = new javax.swing.JButton();
        laivanupotusNappi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        anagrammiPaneeli.setBackground(new java.awt.Color(204, 255, 255));
        anagrammiPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true));

        anagrammiOtsikko.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        anagrammiOtsikko.setText("Minkä sanan anagrammi on...");

        anagrammiKentta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        anagrammiKentta.setText("anagrammi");

        vihje.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        vihje.setText("vihje");

        vastaus.setColumns(10);
        vastaus.setText("Vastaus");

        vastaaNappi.setText("Vastaa");

        vihjeNappi.setText("Seuraava kirjain");

        vihjeita.setText("vihjeita");

        uudelleenNappi.setText("Uudelleen");
        uudelleenNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uudelleenNappiActionPerformed(evt);
            }
        });

        tuomioKentta.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tuomioKentta.setText("tuomio");

        javax.swing.GroupLayout anagrammiPaneeliLayout = new javax.swing.GroupLayout(anagrammiPaneeli);
        anagrammiPaneeli.setLayout(anagrammiPaneeliLayout);
        anagrammiPaneeliLayout.setHorizontalGroup(
            anagrammiPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anagrammiPaneeliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(anagrammiPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(anagrammiKentta)
                    .addComponent(anagrammiOtsikko)
                    .addComponent(vihje)
                    .addGroup(anagrammiPaneeliLayout.createSequentialGroup()
                        .addGroup(anagrammiPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(anagrammiPaneeliLayout.createSequentialGroup()
                                .addComponent(vastaaNappi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vihjeNappi))
                            .addComponent(vastaus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vihjeita)
                        .addGap(37, 37, 37)
                        .addComponent(uudelleenNappi))
                    .addComponent(tuomioKentta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        anagrammiPaneeliLayout.setVerticalGroup(
            anagrammiPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anagrammiPaneeliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anagrammiOtsikko)
                .addGap(7, 7, 7)
                .addComponent(anagrammiKentta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vihje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(anagrammiPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vastaus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vihjeita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(anagrammiPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vastaaNappi)
                    .addComponent(vihjeNappi)
                    .addComponent(uudelleenNappi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tuomioKentta)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        ylaPaneeli.setBackground(new java.awt.Color(204, 204, 255));
        ylaPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));

        annaNimi.setText("Anna nimesi: ");

        pelaajanNimi.setColumns(20);
        pelaajanNimi.setText("Nimi tai nimimerkki");
        pelaajanNimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelaajanNimiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Wordmaster 3000");

        okNappi.setText("OK");
        okNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okNappiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ylaPaneeliLayout = new javax.swing.GroupLayout(ylaPaneeli);
        ylaPaneeli.setLayout(ylaPaneeliLayout);
        ylaPaneeliLayout.setHorizontalGroup(
            ylaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ylaPaneeliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ylaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ylaPaneeliLayout.createSequentialGroup()
                        .addComponent(annaNimi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pelaajanNimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okNappi))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ylaPaneeliLayout.setVerticalGroup(
            ylaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ylaPaneeliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ylaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annaNimi)
                    .addComponent(pelaajanNimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okNappi))
                .addGap(74, 74, 74))
        );

        piilosanaPaneeli.setBackground(new java.awt.Color(255, 222, 252));
        piilosanaPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 1, true));

        piilosanaOtsikko.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        piilosanaOtsikko.setText("Etsi piilosana");

        piilosanaOhje.setEditable(false);
        piilosanaOhje.setBackground(new java.awt.Color(204, 204, 255));
        piilosanaOhje.setColumns(20);
        piilosanaOhje.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        piilosanaOhje.setRows(4);
        piilosanaOhje.setText("Etsi alla oleva sana. Klikkaa sanan kirjaimia oikeassa järjestyksessä.\nSanan perättäiset kirjaimet voivat olla toisiinsa nähden missä suunnassa tahansa \n(ylhäällä, alhaalla, vieressä, kulmittain).\nVoit perua kirjaimen lisäyksen painamalla nappia uudestaan.\n");
        piilosanaOhje.setAutoscrolls(false);
        piilosanaOhje.setBorder(null);
        piilosanaOhje.setOpaque(false);
        jScrollPane2.setViewportView(piilosanaOhje);

        piilosanaVastausKentta.setText("Vastaus: ");

        etsittava.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        etsittava.setText("etsittava");

        piilosanaNapitPaneeli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        piilosanaNapitPaneeli.setLayout(new java.awt.GridLayout(10, 10, 1, 1));

        piilosanaVastaaNappi.setText("Vastaa");

        piilosanaUudelleenNappi.setText("Uudelleen");
        piilosanaUudelleenNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                piilosanaUudelleenNappiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout piilosanaPaneeliLayout = new javax.swing.GroupLayout(piilosanaPaneeli);
        piilosanaPaneeli.setLayout(piilosanaPaneeliLayout);
        piilosanaPaneeliLayout.setHorizontalGroup(
            piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(piilosanaOtsikko)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                        .addComponent(piilosanaUudelleenNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                        .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(etsittava)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(piilosanaVastausKentta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(146, 146, 146)))
                                .addComponent(piilosanaVastaaNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(piilosanaNapitPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(456, 456, 456))))
            .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        piilosanaPaneeliLayout.setVerticalGroup(
            piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(piilosanaOtsikko)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                        .addComponent(etsittava)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(piilosanaVastausKentta))
                    .addComponent(piilosanaVastaaNappi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(piilosanaNapitPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(piilosanaUudelleenNappi)
                .addContainerGap())
        );

        laivanupotusPaneeli.setBackground(new java.awt.Color(227, 230, 251));
        laivanupotusPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 51), 1, true));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Etsi alla olevan sanan kirjaimet mahdollisimman vähillä klikkauksilla.\nSanan perättäiset kirjaimet voivat olla toisiinsa nähden missä suunnassa tahansa\n(ylhäällä, alhaalla, vieressä, kulmittain).\n");
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        laivanupotusOtsikko.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        laivanupotusOtsikko.setText("Laivanupotus");

        upotettavaKentta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        upotettavaKentta.setText("upotettava");

        klikkaukset.setText("Klikkauksia:");

        osumat.setText("Osumia: ");

        laivanupotusUudelleen.setText("Uudelleen");

        laivanupotusNapitPaneeli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        laivanupotusNapitPaneeli.setLayout(new java.awt.GridLayout(5, 5, 1, 1));

        javax.swing.GroupLayout laivanupotusPaneeliLayout = new javax.swing.GroupLayout(laivanupotusPaneeli);
        laivanupotusPaneeli.setLayout(laivanupotusPaneeliLayout);
        laivanupotusPaneeliLayout.setHorizontalGroup(
            laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laivanupotusPaneeliLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(laivanupotusOtsikko)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(laivanupotusPaneeliLayout.createSequentialGroup()
                .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(laivanupotusUudelleen)
                    .addGroup(laivanupotusPaneeliLayout.createSequentialGroup()
                        .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(laivanupotusNapitPaneeli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(laivanupotusPaneeliLayout.createSequentialGroup()
                                .addComponent(upotettavaKentta)
                                .addGap(18, 18, 18)
                                .addComponent(klikkaukset)))
                        .addGap(18, 18, 18)
                        .addComponent(osumat)))
                .addGap(0, 346, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        laivanupotusPaneeliLayout.setVerticalGroup(
            laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laivanupotusPaneeliLayout.createSequentialGroup()
                .addComponent(laivanupotusOtsikko)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upotettavaKentta)
                    .addComponent(klikkaukset)
                    .addComponent(osumat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(laivanupotusNapitPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(laivanupotusUudelleen))
        );

        lopetaPaneeli.setBackground(new java.awt.Color(255, 204, 153));
        lopetaPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 1, true));

        lopetaNappi.setText("Lopeta");
        lopetaPaneeli.add(lopetaNappi);

        valitsePaneeli.setBackground(new java.awt.Color(204, 255, 204));
        valitsePaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 102), 1, true));

        valitse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valitse.setText("Valitse peli");

        anagrammiNappi.setText("Anagrammi");

        piilosanaNappi.setText("Piilosana");
        piilosanaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                piilosanaNappiActionPerformed(evt);
            }
        });

        laivanupotusNappi.setText("Laivanupotus");

        javax.swing.GroupLayout valitsePaneeliLayout = new javax.swing.GroupLayout(valitsePaneeli);
        valitsePaneeli.setLayout(valitsePaneeliLayout);
        valitsePaneeliLayout.setHorizontalGroup(
            valitsePaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valitsePaneeliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(valitsePaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valitse)
                    .addGroup(valitsePaneeliLayout.createSequentialGroup()
                        .addComponent(anagrammiNappi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(piilosanaNappi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(laivanupotusNappi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        valitsePaneeliLayout.setVerticalGroup(
            valitsePaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valitsePaneeliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valitse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(valitsePaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anagrammiNappi)
                    .addComponent(piilosanaNappi)
                    .addComponent(laivanupotusNappi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lopetaPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(laivanupotusPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(valitsePaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ylaPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(anagrammiPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(piilosanaPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ylaPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valitsePaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anagrammiPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(piilosanaPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(laivanupotusPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lopetaPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uudelleenNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uudelleenNappiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uudelleenNappiActionPerformed

    private void piilosanaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piilosanaNappiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_piilosanaNappiActionPerformed

    private void okNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okNappiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okNappiActionPerformed

    private void pelaajanNimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelaajanNimiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pelaajanNimiActionPerformed

    private void piilosanaUudelleenNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piilosanaUudelleenNappiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_piilosanaUudelleenNappiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException, Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GraafinenKayttoliittyma().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anagrammiKentta;
    private javax.swing.JButton anagrammiNappi;
    private javax.swing.JLabel anagrammiOtsikko;
    private javax.swing.JPanel anagrammiPaneeli;
    private javax.swing.JLabel annaNimi;
    private javax.swing.JLabel etsittava;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel klikkaukset;
    private javax.swing.JPanel laivanupotusNapitPaneeli;
    private javax.swing.JButton laivanupotusNappi;
    private javax.swing.JLabel laivanupotusOtsikko;
    private javax.swing.JPanel laivanupotusPaneeli;
    private javax.swing.JButton laivanupotusUudelleen;
    private javax.swing.JButton lopetaNappi;
    private javax.swing.JPanel lopetaPaneeli;
    private javax.swing.JButton okNappi;
    private javax.swing.JLabel osumat;
    private javax.swing.JTextField pelaajanNimi;
    private javax.swing.JPanel piilosanaNapitPaneeli;
    private javax.swing.JButton piilosanaNappi;
    private javax.swing.JTextArea piilosanaOhje;
    private javax.swing.JLabel piilosanaOtsikko;
    private javax.swing.JPanel piilosanaPaneeli;
    private javax.swing.JButton piilosanaUudelleenNappi;
    private javax.swing.JButton piilosanaVastaaNappi;
    private javax.swing.JLabel piilosanaVastausKentta;
    private javax.swing.JLabel tuomioKentta;
    private javax.swing.JLabel upotettavaKentta;
    private javax.swing.JButton uudelleenNappi;
    private javax.swing.JLabel valitse;
    private javax.swing.JPanel valitsePaneeli;
    private javax.swing.JButton vastaaNappi;
    private javax.swing.JFormattedTextField vastaus;
    private javax.swing.JLabel vihje;
    private javax.swing.JButton vihjeNappi;
    private javax.swing.JLabel vihjeita;
    private javax.swing.JPanel ylaPaneeli;
    // End of variables declaration//GEN-END:variables

}
