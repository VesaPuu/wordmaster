package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import wordmaster.Pelaaja;
import wordmaster.Piilosana;
import wordmaster.Sana;
import wordmaster.Laivanupotus;

public class GraafinenKayttoliittyma extends javax.swing.JFrame implements ActionListener {

    static TiedostonLukija tl;
    Piilosana piilosana;
    Laivanupotus laivanupotus;
    Pelaaja pelaaja;
    int vihjeet;
    int sananPituus;
    String anagrammiSana;
    Sana anagrammiksiMuutettava;
    String vihjeteksti;
    String piilosanaVastaus;
    String etsittavaSana;
    String upotettavaSana;
    private static Random random;
//    String sijoitettava;

    /**
     * Creates new form GraafinenKayttoliittyma
     */
    public GraafinenKayttoliittyma() throws FileNotFoundException, Exception {
        initComponents();
        pelaajanNimi.setText("");
        anagrammiKentta.setText("");
        upotettavaKentta.setText("");
        pelaajanNimi.addActionListener(this);
        vastaaNappi.addActionListener(this);
        vastaus.addActionListener(this);
        anagrammiNappi.addActionListener(this);
        piilosanaNappi.addActionListener(this);
        laivanupotusNappi.addActionListener(this);
        vihjeNappi.addActionListener(this);
        lopetaNappi.addActionListener(this);
        uudelleenNappi.addActionListener(this);
        nappi0101.addActionListener(this);
        nappi0102.addActionListener(this);
        nappi0103.addActionListener(this);
        nappi0104.addActionListener(this);
        nappi0105.addActionListener(this);
        nappi0106.addActionListener(this);
        nappi0107.addActionListener(this);
        nappi0108.addActionListener(this);
        nappi0109.addActionListener(this);
        nappi0110.addActionListener(this);
        nappi0201.addActionListener(this);
        nappi0202.addActionListener(this);
        nappi0203.addActionListener(this);
        nappi0204.addActionListener(this);
        nappi0205.addActionListener(this);
        nappi0206.addActionListener(this);
        nappi0207.addActionListener(this);
        nappi0208.addActionListener(this);
        nappi0209.addActionListener(this);
        nappi0210.addActionListener(this);
        nappi0301.addActionListener(this);
        nappi0302.addActionListener(this);
        nappi0303.addActionListener(this);
        nappi0304.addActionListener(this);
        nappi0305.addActionListener(this);
        nappi0306.addActionListener(this);
        nappi0307.addActionListener(this);
        nappi0308.addActionListener(this);
        nappi0309.addActionListener(this);
        nappi0310.addActionListener(this);
        nappi0401.addActionListener(this);
        nappi0402.addActionListener(this);
        nappi0403.addActionListener(this);
        nappi0404.addActionListener(this);
        nappi0405.addActionListener(this);
        nappi0406.addActionListener(this);
        nappi0407.addActionListener(this);
        nappi0408.addActionListener(this);
        nappi0409.addActionListener(this);
        nappi0410.addActionListener(this);
        nappi0501.addActionListener(this);
        nappi0502.addActionListener(this);
        nappi0503.addActionListener(this);
        nappi0504.addActionListener(this);
        nappi0505.addActionListener(this);
        nappi0506.addActionListener(this);
        nappi0507.addActionListener(this);
        nappi0508.addActionListener(this);
        nappi0509.addActionListener(this);
        nappi0510.addActionListener(this);
        nappi0601.addActionListener(this);
        nappi0602.addActionListener(this);
        nappi0603.addActionListener(this);
        nappi0604.addActionListener(this);
        nappi0605.addActionListener(this);
        nappi0606.addActionListener(this);
        nappi0607.addActionListener(this);
        nappi0608.addActionListener(this);
        nappi0609.addActionListener(this);
        nappi0610.addActionListener(this);
        nappi0701.addActionListener(this);
        nappi0702.addActionListener(this);
        nappi0703.addActionListener(this);
        nappi0704.addActionListener(this);
        nappi0705.addActionListener(this);
        nappi0706.addActionListener(this);
        nappi0707.addActionListener(this);
        nappi0708.addActionListener(this);
        nappi0709.addActionListener(this);
        nappi0710.addActionListener(this);
        nappi0801.addActionListener(this);
        nappi0802.addActionListener(this);
        nappi0803.addActionListener(this);
        nappi0804.addActionListener(this);
        nappi0805.addActionListener(this);
        nappi0806.addActionListener(this);
        nappi0807.addActionListener(this);
        nappi0808.addActionListener(this);
        nappi0809.addActionListener(this);
        nappi0810.addActionListener(this);
        nappi0901.addActionListener(this);
        nappi0902.addActionListener(this);
        nappi0903.addActionListener(this);
        nappi0904.addActionListener(this);
        nappi0905.addActionListener(this);
        nappi0906.addActionListener(this);
        nappi0907.addActionListener(this);
        nappi0908.addActionListener(this);
        nappi0909.addActionListener(this);
        nappi0910.addActionListener(this);
        nappi1001.addActionListener(this);
        nappi1002.addActionListener(this);
        nappi1003.addActionListener(this);
        nappi1004.addActionListener(this);
        nappi1005.addActionListener(this);
        nappi1006.addActionListener(this);
        nappi1007.addActionListener(this);
        nappi1008.addActionListener(this);
        nappi1009.addActionListener(this);
        nappi1010.addActionListener(this);
        laivanupotusNappi1.addActionListener(this);
        laivanupotusNappi2.addActionListener(this);
        laivanupotusNappi3.addActionListener(this);
        laivanupotusNappi4.addActionListener(this);
        laivanupotusNappi5.addActionListener(this);
        laivanupotusNappi6.addActionListener(this);
        laivanupotusNappi7.addActionListener(this);
        laivanupotusNappi8.addActionListener(this);
        laivanupotusNappi9.addActionListener(this);
        laivanupotusNappi10.addActionListener(this);
        laivanupotusNappi11.addActionListener(this);
        laivanupotusNappi12.addActionListener(this);
        laivanupotusNappi13.addActionListener(this);
        laivanupotusNappi14.addActionListener(this);
        laivanupotusNappi15.addActionListener(this);
        laivanupotusNappi16.addActionListener(this);
        laivanupotusNappi17.addActionListener(this);
        laivanupotusNappi18.addActionListener(this);
        laivanupotusNappi19.addActionListener(this);
        laivanupotusNappi20.addActionListener(this);
        laivanupotusNappi21.addActionListener(this);
        laivanupotusNappi22.addActionListener(this);
        laivanupotusNappi23.addActionListener(this);
        laivanupotusNappi24.addActionListener(this);
        laivanupotusNappi25.addActionListener(this);
        okNappi.addActionListener(this);
        piilosanaVastaaNappi.addActionListener(this);
        piilosanaUudelleenNappi.addActionListener(this);
        this.tl = new TiedostonLukija(); // luodaan uusi Tiedostonlukija-olio
        tl.lueTiedosto();
        this.piilosana = new Piilosana();
        this.laivanupotus = new Laivanupotus();
        this.vihjeet = 0;
        this.sananPituus = 0;
        this.random = new Random();
        valitsePaneeli.setVisible(false);
        anagrammiPaneeli.setVisible(false);
        piilosanaPaneeli.setVisible(false);
        laivanupotusPaneeli.setVisible(false);
    }

    public void aloita() {
        annaNimi.setVisible(false);
        pelaajanNimi.setVisible(false);
        okNappi.setVisible(false);
        String nimi = pelaaja.getNimi();
        valitse.setText("Tervetuloa " + nimi + "! Valitse peli:");
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

//        String r1 = tl.sanasto.luoRandomSana().getSana();
//        String r2 = tl.sanasto.luoRandomSana().getSana();
//        String r3 = tl.sanasto.luoRandomSana().getSana();
//        String r4 = tl.sanasto.luoRandomSana().getSana();
//        String r5 = tl.sanasto.luoRandomSana().getSana();
//        String r6 = tl.sanasto.luoRandomSana().getSana();
//        String r7 = tl.sanasto.luoRandomSana().getSana();
//        String r8 = tl.sanasto.luoRandomSana().getSana();
//        String r9 = tl.sanasto.luoRandomSana().getSana();
//        String r10 = tl.sanasto.luoRandomSana().getSana();
//        String r11 = tl.sanasto.luoRandomSana().getSana();
//        String r12 = tl.sanasto.luoRandomSana().getSana();
//        String r13 = tl.sanasto.luoRandomSana().getSana();
//        rivi1.setText(r1);
//        rivi2.setText(r2);
//        rivi3.setText(r3);
//        rivi4.setText(r4);
//        rivi5.setText(r5);
//        rivi6.setText(r6);
//        rivi7.setText(r7);
//        rivi8.setText(r8);
//        rivi9.setText(r9);
//        rivi10.setText(r10);
//        rivi11.setText(r11);
//        rivi12.setText(r12);
//        rivi13.setText(r13);
//        piilosanaKentta.setText(r1 + "\n" + r2 + "\n" + r3 + "\n" + r4 + "\n" + r5 + "\n" + r6 + "\n" + r7 + "\n" + r8 + "\n" + r9 + "\n" + r10 + "\n" + r11 + "\n" + r12 + "\n" + r13);
        int i = 0;
        int j = 0;

        nappi0101.setText(piilosana.palautaMerkki(i, j));
        nappi0101.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0102.setText(piilosana.palautaMerkki(i, j));
        nappi0102.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0103.setText(piilosana.palautaMerkki(i, j));
        nappi0103.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0104.setText(piilosana.palautaMerkki(i, j));
        nappi0104.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0105.setText(piilosana.palautaMerkki(i, j));
        nappi0105.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0106.setText(piilosana.palautaMerkki(i, j));
        nappi0106.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0107.setText(piilosana.palautaMerkki(i, j));
        nappi0107.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0108.setText(piilosana.palautaMerkki(i, j));
        nappi0108.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0109.setText(piilosana.palautaMerkki(i, j));
        nappi0109.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0110.setText(piilosana.palautaMerkki(i, j));
        nappi0110.setBackground(Color.LIGHT_GRAY);
        i++;
        j = 0;
        nappi0201.setText(piilosana.palautaMerkki(i, j));
        nappi0201.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0202.setText(piilosana.palautaMerkki(i, j));
        nappi0202.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0203.setText(piilosana.palautaMerkki(i, j));
        nappi0203.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0204.setText(piilosana.palautaMerkki(i, j));
        nappi0204.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0205.setText(piilosana.palautaMerkki(i, j));
        nappi0205.setBackground(Color.LIGHT_GRAY);
        j++;;
        nappi0206.setText(piilosana.palautaMerkki(i, j));
        nappi0206.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0207.setText(piilosana.palautaMerkki(i, j));
        nappi0207.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0208.setText(piilosana.palautaMerkki(i, j));
        nappi0208.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0209.setText(piilosana.palautaMerkki(i, j));
        nappi0209.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0210.setText(piilosana.palautaMerkki(i, j));
        nappi0210.setBackground(Color.LIGHT_GRAY);
        i++;
        j = 0;
        nappi0301.setText(piilosana.palautaMerkki(i, j));
        nappi0301.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0302.setText(piilosana.palautaMerkki(i, j));
        nappi0302.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0303.setText(piilosana.palautaMerkki(i, j));
        nappi0303.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0304.setText(piilosana.palautaMerkki(i, j));
        nappi0304.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0305.setText(piilosana.palautaMerkki(i, j));
        nappi0305.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0306.setText(piilosana.palautaMerkki(i, j));
        nappi0306.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0307.setText(piilosana.palautaMerkki(i, j));
        nappi0307.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0308.setText(piilosana.palautaMerkki(i, j));
        nappi0308.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0309.setText(piilosana.palautaMerkki(i, j));
        nappi0309.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0310.setText(piilosana.palautaMerkki(i, j));
        nappi0310.setBackground(Color.LIGHT_GRAY);
        i++;
        j = 0;
        nappi0401.setText(piilosana.palautaMerkki(i, j));
        nappi0401.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0402.setText(piilosana.palautaMerkki(i, j));
        nappi0402.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0403.setText(piilosana.palautaMerkki(i, j));
        nappi0403.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0404.setText(piilosana.palautaMerkki(i, j));
        nappi0404.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0405.setText(piilosana.palautaMerkki(i, j));
        nappi0405.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0406.setText(piilosana.palautaMerkki(i, j));
        nappi0406.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0407.setText(piilosana.palautaMerkki(i, j));
        nappi0407.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0408.setText(piilosana.palautaMerkki(i, j));
        nappi0408.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0409.setText(piilosana.palautaMerkki(i, j));
        nappi0409.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0410.setText(piilosana.palautaMerkki(i, j));
        nappi0410.setBackground(Color.LIGHT_GRAY);
        i++;
        j = 0;
        nappi0501.setText(piilosana.palautaMerkki(i, j));
        nappi0501.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0502.setText(piilosana.palautaMerkki(i, j));
        nappi0502.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0503.setText(piilosana.palautaMerkki(i, j));
        nappi0503.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0504.setText(piilosana.palautaMerkki(i, j));
        nappi0504.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0505.setText(piilosana.palautaMerkki(i, j));
        nappi0505.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0506.setText(piilosana.palautaMerkki(i, j));
        nappi0506.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0507.setText(piilosana.palautaMerkki(i, j));
        nappi0507.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0508.setText(piilosana.palautaMerkki(i, j));
        nappi0508.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0509.setText(piilosana.palautaMerkki(i, j));
        nappi0509.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0510.setText(piilosana.palautaMerkki(i, j));
        nappi0510.setBackground(Color.LIGHT_GRAY);
        i++;
        j = 0;
        nappi0601.setText(piilosana.palautaMerkki(i, j));
        nappi0601.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0602.setText(piilosana.palautaMerkki(i, j));
        nappi0602.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0603.setText(piilosana.palautaMerkki(i, j));
        nappi0603.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0604.setText(piilosana.palautaMerkki(i, j));
        nappi0604.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0605.setText(piilosana.palautaMerkki(i, j));
        nappi0605.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0606.setText(piilosana.palautaMerkki(i, j));
        nappi0606.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0607.setText(piilosana.palautaMerkki(i, j));
        nappi0607.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0608.setText(piilosana.palautaMerkki(i, j));
        nappi0608.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0609.setText(piilosana.palautaMerkki(i, j));
        nappi0609.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0610.setText(piilosana.palautaMerkki(i, j));
        nappi0610.setBackground(Color.LIGHT_GRAY);
        i++;
        j = 0;
        nappi0701.setText(piilosana.palautaMerkki(i, j));
        nappi0701.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0702.setText(piilosana.palautaMerkki(i, j));
        nappi0702.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0703.setText(piilosana.palautaMerkki(i, j));
        nappi0703.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0704.setText(piilosana.palautaMerkki(i, j));
        nappi0704.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0705.setText(piilosana.palautaMerkki(i, j));
        nappi0705.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0706.setText(piilosana.palautaMerkki(i, j));
        nappi0706.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0707.setText(piilosana.palautaMerkki(i, j));
        nappi0707.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0708.setText(piilosana.palautaMerkki(i, j));
        nappi0708.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0709.setText(piilosana.palautaMerkki(i, j));
        nappi0709.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0710.setText(piilosana.palautaMerkki(i, j));
        nappi0710.setBackground(Color.LIGHT_GRAY);
        i++;
        j = 0;
        nappi0801.setText(piilosana.palautaMerkki(i, j));
        nappi0801.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0802.setText(piilosana.palautaMerkki(i, j));
        nappi0802.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0803.setText(piilosana.palautaMerkki(i, j));
        nappi0803.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0804.setText(piilosana.palautaMerkki(i, j));
        nappi0804.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0805.setText(piilosana.palautaMerkki(i, j));
        nappi0805.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0806.setText(piilosana.palautaMerkki(i, j));
        nappi0806.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0807.setText(piilosana.palautaMerkki(i, j));
        nappi0807.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0808.setText(piilosana.palautaMerkki(i, j));
        nappi0808.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0809.setText(piilosana.palautaMerkki(i, j));
        nappi0809.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0810.setText(piilosana.palautaMerkki(i, j));
        nappi0810.setBackground(Color.LIGHT_GRAY);
        i++;
        j = 0;
        nappi0901.setText(piilosana.palautaMerkki(i, j));
        nappi0901.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0902.setText(piilosana.palautaMerkki(i, j));
        nappi0902.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0903.setText(piilosana.palautaMerkki(i, j));
        nappi0903.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0904.setText(piilosana.palautaMerkki(i, j));
        nappi0904.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0905.setText(piilosana.palautaMerkki(i, j));
        nappi0905.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0906.setText(piilosana.palautaMerkki(i, j));
        nappi0906.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0907.setText(piilosana.palautaMerkki(i, j));
        nappi0907.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0908.setText(piilosana.palautaMerkki(i, j));
        nappi0908.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0909.setText(piilosana.palautaMerkki(i, j));
        nappi0909.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi0910.setText(piilosana.palautaMerkki(i, j));
        nappi0910.setBackground(Color.LIGHT_GRAY);
        i++;
        j = 0;
        nappi1001.setText(piilosana.palautaMerkki(i, j));
        nappi1001.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi1002.setText(piilosana.palautaMerkki(i, j));
        nappi1002.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi1003.setText(piilosana.palautaMerkki(i, j));
        nappi1003.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi1004.setText(piilosana.palautaMerkki(i, j));
        nappi1004.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi1005.setText(piilosana.palautaMerkki(i, j));
        nappi1005.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi1006.setText(piilosana.palautaMerkki(i, j));
        nappi1006.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi1007.setText(piilosana.palautaMerkki(i, j));
        nappi1007.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi1008.setText(piilosana.palautaMerkki(i, j));
        nappi1008.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi1009.setText(piilosana.palautaMerkki(i, j));
        nappi1009.setBackground(Color.LIGHT_GRAY);
        j++;
        nappi1010.setText(piilosana.palautaMerkki(i, j));
        nappi1010.setBackground(Color.LIGHT_GRAY);
    }

    public void aloitaLaivanupotus() {
        laivanupotus.tyhjennaKaikki();
        upotettavaSana = "";
//        piilosanaVastaus = "";
//        etsittavaSana = "";
//        piilosanaVastausKentta.setText("Vastaus: ");
//        Sana upotettava = tl.sanasto.luoRandomSana();
        Sana upotettava = new Sana("kissa");
        laivanupotus.sijoitaSana(upotettava);
//        piilosana.taytaKaikki();
        upotettavaSana = upotettava.getSana();
        upotettavaKentta.setText(upotettavaSana);
        int i = 0;
        int j = 0;
        laivanupotusNappi1.setBackground(Color.BLACK);
        laivanupotusNappi2.setBackground(Color.BLACK);
        laivanupotusNappi3.setBackground(Color.BLACK);
        laivanupotusNappi4.setBackground(Color.BLACK);
        laivanupotusNappi5.setBackground(Color.BLACK);
        laivanupotusNappi6.setBackground(Color.BLACK);
        laivanupotusNappi7.setBackground(Color.BLACK);
        laivanupotusNappi8.setBackground(Color.BLACK);
        laivanupotusNappi9.setBackground(Color.BLACK);
        laivanupotusNappi10.setBackground(Color.BLACK);
        laivanupotusNappi11.setBackground(Color.BLACK);
        laivanupotusNappi12.setBackground(Color.BLACK);
        laivanupotusNappi13.setBackground(Color.BLACK);
        laivanupotusNappi14.setBackground(Color.BLACK);
        laivanupotusNappi15.setBackground(Color.BLACK);
        laivanupotusNappi16.setBackground(Color.BLACK);
        laivanupotusNappi17.setBackground(Color.BLACK);
        laivanupotusNappi18.setBackground(Color.BLACK);
        laivanupotusNappi19.setBackground(Color.BLACK);
        laivanupotusNappi20.setBackground(Color.BLACK);
        laivanupotusNappi21.setBackground(Color.BLACK);
        laivanupotusNappi22.setBackground(Color.BLACK);
        laivanupotusNappi23.setBackground(Color.BLACK);
        laivanupotusNappi24.setBackground(Color.BLACK);
        laivanupotusNappi25.setBackground(Color.BLACK);
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

    public void actionPerformed(ActionEvent e) {

        Object aiheuttaja = e.getSource();

        if (e.getSource().equals(okNappi) || aiheuttaja == pelaajanNimi) {
            this.pelaaja = new Pelaaja(pelaajanNimi.getText());
            valitsePaneeli.setVisible(true);
            aloita();
        }

        if (e.getSource().equals(anagrammiNappi)) {
            anagrammiPaneeli.setVisible(true);
            piilosanaPaneeli.setVisible(false);
            laivanupotusPaneeli.setVisible(false);
            aloitaAnagrammi();
        }

        if (e.getSource().equals(piilosanaNappi)) {
            anagrammiPaneeli.setVisible(false);
            piilosanaPaneeli.setVisible(true);
            laivanupotusPaneeli.setVisible(false);
            aloitaPiilosana();
        }

        if (e.getSource().equals(laivanupotusNappi)) {
            anagrammiPaneeli.setVisible(false);
            piilosanaPaneeli.setVisible(false);
            laivanupotusPaneeli.setVisible(true);
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

        if (e.getSource().equals(nappi0101)) {

            if (nappi0101.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0101.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0101.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0101.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0102)) {
            if (nappi0102.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0102.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0102.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0102.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0103)) {
            if (nappi0103.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0103.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0103.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0103.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0104)) {
            if (nappi0104.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0104.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0104.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0104.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0105)) {
            if (nappi0105.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0105.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0105.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0105.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0106)) {
            if (nappi0106.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0106.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0106.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0106.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0107)) {
            if (nappi0107.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0107.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0107.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0107.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0108)) {
            if (nappi0108.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0108.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0108.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0108.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0109)) {
            if (nappi0109.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0109.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0109.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0109.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0110)) {
            if (nappi0110.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0110.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0110.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0110.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0201)) {
            if (nappi0201.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0201.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0201.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0201.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0202)) {
            if (nappi0202.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0202.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0202.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0202.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0203)) {
            if (nappi0203.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0203.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0203.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0203.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0204)) {
            if (nappi0204.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0204.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0204.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0204.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0205)) {
            if (nappi0205.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0205.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0205.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0205.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0206)) {
            if (nappi0206.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0206.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0206.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0206.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0207)) {
            if (nappi0207.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0207.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0207.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0207.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0208)) {
            if (nappi0208.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0208.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0208.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0208.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0209)) {
            if (nappi0209.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0209.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0209.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0209.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0210)) {
            if (nappi0210.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0210.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0210.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0210.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0301)) {
            if (nappi0301.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0301.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0301.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0301.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0302)) {
            if (nappi0302.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0302.setBackground(Color.LIGHT_GRAY);
            } else {

                piilosanaVastaus = piilosanaVastaus + nappi0302.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0302.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0303)) {
            if (nappi0303.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0303.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0303.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0303.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0304)) {
            if (nappi0304.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0304.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0304.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0304.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0305)) {
            if (nappi0305.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0305.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0305.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0305.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0306)) {
            if (nappi0306.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0306.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0306.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0306.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0307)) {
            if (nappi0307.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0307.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0307.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0307.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0308)) {
            if (nappi0308.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0308.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0308.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0308.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0309)) {
            if (nappi0309.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0309.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0309.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0309.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0310)) {
            if (nappi0310.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0310.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0310.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0310.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0401)) {
            if (nappi0401.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0401.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0401.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0401.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0402)) {
            if (nappi0402.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0402.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0402.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0402.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0403)) {
            if (nappi0403.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0403.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0403.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0403.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0404)) {
            if (nappi0404.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0404.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0404.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0404.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0405)) {
            if (nappi0405.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0405.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0405.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0405.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0406)) {
            if (nappi0406.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0406.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0406.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0406.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0407)) {
            if (nappi0407.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0407.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0407.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0407.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0408)) {
            if (nappi0408.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0408.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0408.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0408.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0409)) {
            if (nappi0409.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0409.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0409.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0409.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0410)) {
            if (nappi0410.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0410.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0410.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0410.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0501)) {
            if (nappi0501.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0501.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0501.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0501.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0502)) {
            if (nappi0502.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0502.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0502.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0502.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0503)) {
            if (nappi0503.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0503.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0503.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0503.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0504)) {
            if (nappi0504.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0504.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0504.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0504.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0505)) {
            if (nappi0505.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0505.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0505.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0505.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0506)) {
            if (nappi0506.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0506.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0506.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0506.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0507)) {
            if (nappi0507.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0507.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0507.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0507.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0508)) {
            if (nappi0508.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0508.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0508.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0508.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0509)) {
            if (nappi0509.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0509.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0509.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0509.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0510)) {
            if (nappi0510.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0510.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0510.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0510.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0601)) {
            if (nappi0601.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0601.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0601.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0601.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0602)) {
            if (nappi0602.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0602.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0602.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0602.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0603)) {
            if (nappi0603.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0603.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0603.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0603.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0604)) {
            if (nappi0604.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0604.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0604.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0604.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0605)) {
            if (nappi0605.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0605.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0605.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0605.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0606)) {
            if (nappi0606.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0606.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0606.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0606.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0607)) {
            if (nappi0607.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0607.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0607.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0607.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0608)) {
            if (nappi0608.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0608.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0608.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0608.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0609)) {
            if (nappi0609.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0609.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0609.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0609.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0610)) {
            if (nappi0610.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0610.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0610.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0610.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0701)) {
            if (nappi0701.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0701.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0701.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0701.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0702)) {
            if (nappi0702.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0702.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0702.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0702.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0703)) {
            if (nappi0703.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0703.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0703.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0703.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0704)) {
            if (nappi0704.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0704.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0704.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0704.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0705)) {
            if (nappi0705.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0705.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0705.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0705.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0706)) {
            if (nappi0706.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0706.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0706.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0706.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0707)) {
            if (nappi0707.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0707.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0707.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0707.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0708)) {
            if (nappi0708.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0708.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0708.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0708.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0709)) {
            if (nappi0709.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0709.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0709.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0709.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0710)) {
            if (nappi0710.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0710.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0710.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0710.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0801)) {
            if (nappi0801.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0801.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0801.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0801.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0802)) {
            if (nappi0802.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0802.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0802.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0802.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0803)) {
            if (nappi0803.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0803.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0803.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0803.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0804)) {
            if (nappi0804.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0804.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0804.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0804.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0805)) {
            if (nappi0805.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0805.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0805.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0805.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0806)) {
            if (nappi0806.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0806.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0806.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0806.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0807)) {
            if (nappi0807.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0807.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0807.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0807.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0808)) {
            if (nappi0808.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0808.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0808.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0808.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0809)) {
            if (nappi0809.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0809.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0809.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0809.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0810)) {
            if (nappi0810.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0810.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0810.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0810.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0901)) {
            if (nappi0901.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0901.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0901.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0901.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0902)) {
            if (nappi0902.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0902.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0902.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0902.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0903)) {
            if (nappi0903.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0903.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0903.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0903.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0904)) {
            if (nappi0904.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0904.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0904.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0904.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0905)) {
            if (nappi0905.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0905.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0905.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0905.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0906)) {
            if (nappi0906.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0906.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0906.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0906.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0907)) {
            if (nappi0907.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0907.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0907.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0907.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0908)) {
            if (nappi0908.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0908.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0908.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0908.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0909)) {
            if (nappi0909.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0909.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0909.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0909.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi0910)) {
            if (nappi0910.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0910.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi0910.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi0910.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi1001)) {
            if (nappi1001.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1001.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi1001.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1001.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi1002)) {
            if (nappi1002.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1002.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi1002.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1002.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi1003)) {
            if (nappi1003.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1003.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi1003.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1003.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi1004)) {
            if (nappi1004.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1004.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi1004.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1004.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi1005)) {
            if (nappi1005.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1005.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi1005.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1005.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi1006)) {
            if (nappi1006.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1006.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi1006.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1006.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi1007)) {
            if (nappi1007.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1007.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi1007.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1007.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi1008)) {
            if (nappi1008.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1008.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi1008.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1008.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi1009)) {
            if (nappi1009.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1009.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi1009.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1009.setBackground(Color.red);
            }
        }
        if (e.getSource().equals(nappi1010)) {
            if (nappi1010.getBackground().equals(Color.red)) {
                piilosanaVastaus = piilosanaVastaus.substring(0, (piilosanaVastaus.length() - 1));
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1010.setBackground(Color.LIGHT_GRAY);
            } else {
                piilosanaVastaus = piilosanaVastaus + nappi1010.getText();
                piilosanaVastausKentta.setText("Vastaus: " + piilosanaVastaus);
                nappi1010.setBackground(Color.red);
            }
        }

        if (e.getSource().equals(laivanupotusNappi1)) {
            if (laivanupotusNappi1.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi1.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi1.setText(laivanupotus.palautaMerkki(0, 0));
            } else {//
                laivanupotusNappi1.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi2)) {
            if (laivanupotusNappi2.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi2.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi2.setText(laivanupotus.palautaMerkki(0, 1));
            } else {//
                laivanupotusNappi2.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi3)) {
            if (laivanupotusNappi3.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi3.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi3.setText(laivanupotus.palautaMerkki(0, 2));
            } else {//
                laivanupotusNappi3.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi4)) {
            if (laivanupotusNappi4.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi4.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi4.setText(laivanupotus.palautaMerkki(0, 3));
            } else {//
                laivanupotusNappi4.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi5)) {
            if (laivanupotusNappi5.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi5.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi5.setText(laivanupotus.palautaMerkki(0, 4));
            } else {//
                laivanupotusNappi5.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi6)) {
            if (laivanupotusNappi6.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi6.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi6.setText(laivanupotus.palautaMerkki(1, 0));
            } else {//
                laivanupotusNappi6.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi7)) {
            if (laivanupotusNappi7.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi7.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi7.setText(laivanupotus.palautaMerkki(1, 1));
            } else {//
                laivanupotusNappi7.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi8)) {
            if (laivanupotusNappi8.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi8.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi8.setText(laivanupotus.palautaMerkki(1, 2));
            } else {//
                laivanupotusNappi8.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi9)) {
            if (laivanupotusNappi9.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi9.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi9.setText(laivanupotus.palautaMerkki(1, 3));
            } else {//
                laivanupotusNappi9.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi10)) {
            if (laivanupotusNappi10.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi10.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi10.setText(laivanupotus.palautaMerkki(1, 4));
            } else {//
                laivanupotusNappi10.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi11)) {
            if (laivanupotusNappi11.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi11.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi11.setText(laivanupotus.palautaMerkki(2, 0));
            } else {//
                laivanupotusNappi11.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi12)) {
            if (laivanupotusNappi12.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi12.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi12.setText(laivanupotus.palautaMerkki(2, 1));
            } else {//
                laivanupotusNappi12.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi13)) {
            if (laivanupotusNappi13.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi13.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi13.setText(laivanupotus.palautaMerkki(2, 2));
            } else {//
                laivanupotusNappi13.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi14)) {
            if (laivanupotusNappi14.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi14.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi14.setText(laivanupotus.palautaMerkki(2, 3));
            } else {//
                laivanupotusNappi14.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi15)) {
            if (laivanupotusNappi15.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi15.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi15.setText(laivanupotus.palautaMerkki(2, 4));
            } else {//
                laivanupotusNappi15.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi16)) {
            if (laivanupotusNappi16.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi16.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi16.setText(laivanupotus.palautaMerkki(3, 0));
            } else {//
                laivanupotusNappi16.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi17)) {
            if (laivanupotusNappi17.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi17.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi17.setText(laivanupotus.palautaMerkki(3, 1));
            } else {//
                laivanupotusNappi17.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi18)) {
            if (laivanupotusNappi18.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi18.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi18.setText(laivanupotus.palautaMerkki(3, 2));
            } else {//
                laivanupotusNappi18.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi19)) {
            if (laivanupotusNappi19.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi19.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi19.setText(laivanupotus.palautaMerkki(3, 3));
            } else {//
                laivanupotusNappi19.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi20)) {
            if (laivanupotusNappi20.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi20.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi20.setText(laivanupotus.palautaMerkki(3, 4));
            } else {//
                laivanupotusNappi20.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi21)) {
            if (laivanupotusNappi21.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi21.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi21.setText(laivanupotus.palautaMerkki(4, 0));
            } else {//
                laivanupotusNappi21.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi22)) {
            if (laivanupotusNappi22.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi22.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi22.setText(laivanupotus.palautaMerkki(4, 1));
            } else {//
                laivanupotusNappi22.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi23)) {
            if (laivanupotusNappi23.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi23.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi23.setText(laivanupotus.palautaMerkki(4, 2));
            } else {//
                laivanupotusNappi23.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi24)) {
            if (laivanupotusNappi24.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi24.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi24.setText(laivanupotus.palautaMerkki(4, 3));
            } else {//
                laivanupotusNappi24.setBackground(Color.BLACK);
            }
        }

        if (e.getSource().equals(laivanupotusNappi25)) {
            if (laivanupotusNappi25.getBackground().equals(Color.BLACK)) {//
                laivanupotusNappi25.setBackground(Color.LIGHT_GRAY);
                laivanupotusNappi25.setText(laivanupotus.palautaMerkki(4, 4));
            } else {//
                laivanupotusNappi25.setBackground(Color.BLACK);
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
        nappi0101 = new javax.swing.JButton();
        nappi0102 = new javax.swing.JButton();
        nappi0103 = new javax.swing.JButton();
        nappi0104 = new javax.swing.JButton();
        nappi0105 = new javax.swing.JButton();
        nappi0106 = new javax.swing.JButton();
        nappi0107 = new javax.swing.JButton();
        nappi0108 = new javax.swing.JButton();
        nappi0109 = new javax.swing.JButton();
        nappi0110 = new javax.swing.JButton();
        nappi0201 = new javax.swing.JButton();
        nappi0202 = new javax.swing.JButton();
        nappi0203 = new javax.swing.JButton();
        nappi0204 = new javax.swing.JButton();
        nappi0205 = new javax.swing.JButton();
        nappi0206 = new javax.swing.JButton();
        nappi0207 = new javax.swing.JButton();
        nappi0208 = new javax.swing.JButton();
        nappi0209 = new javax.swing.JButton();
        nappi0210 = new javax.swing.JButton();
        nappi0301 = new javax.swing.JButton();
        nappi0302 = new javax.swing.JButton();
        nappi0303 = new javax.swing.JButton();
        nappi0304 = new javax.swing.JButton();
        nappi0305 = new javax.swing.JButton();
        nappi0306 = new javax.swing.JButton();
        nappi0307 = new javax.swing.JButton();
        nappi0308 = new javax.swing.JButton();
        nappi0309 = new javax.swing.JButton();
        nappi0310 = new javax.swing.JButton();
        nappi0401 = new javax.swing.JButton();
        nappi0402 = new javax.swing.JButton();
        nappi0403 = new javax.swing.JButton();
        nappi0404 = new javax.swing.JButton();
        nappi0405 = new javax.swing.JButton();
        nappi0406 = new javax.swing.JButton();
        nappi0407 = new javax.swing.JButton();
        nappi0408 = new javax.swing.JButton();
        nappi0409 = new javax.swing.JButton();
        nappi0410 = new javax.swing.JButton();
        nappi0501 = new javax.swing.JButton();
        nappi0502 = new javax.swing.JButton();
        nappi0503 = new javax.swing.JButton();
        nappi0504 = new javax.swing.JButton();
        nappi0505 = new javax.swing.JButton();
        nappi0506 = new javax.swing.JButton();
        nappi0507 = new javax.swing.JButton();
        nappi0508 = new javax.swing.JButton();
        nappi0509 = new javax.swing.JButton();
        nappi0510 = new javax.swing.JButton();
        nappi0601 = new javax.swing.JButton();
        nappi0602 = new javax.swing.JButton();
        nappi0603 = new javax.swing.JButton();
        nappi0604 = new javax.swing.JButton();
        nappi0605 = new javax.swing.JButton();
        nappi0606 = new javax.swing.JButton();
        nappi0607 = new javax.swing.JButton();
        nappi0608 = new javax.swing.JButton();
        nappi0609 = new javax.swing.JButton();
        nappi0610 = new javax.swing.JButton();
        nappi0701 = new javax.swing.JButton();
        nappi0702 = new javax.swing.JButton();
        nappi0703 = new javax.swing.JButton();
        nappi0704 = new javax.swing.JButton();
        nappi0705 = new javax.swing.JButton();
        nappi0706 = new javax.swing.JButton();
        nappi0707 = new javax.swing.JButton();
        nappi0708 = new javax.swing.JButton();
        nappi0709 = new javax.swing.JButton();
        nappi0710 = new javax.swing.JButton();
        nappi0801 = new javax.swing.JButton();
        nappi0802 = new javax.swing.JButton();
        nappi0803 = new javax.swing.JButton();
        nappi0804 = new javax.swing.JButton();
        nappi0805 = new javax.swing.JButton();
        nappi0806 = new javax.swing.JButton();
        nappi0807 = new javax.swing.JButton();
        nappi0808 = new javax.swing.JButton();
        nappi0809 = new javax.swing.JButton();
        nappi0810 = new javax.swing.JButton();
        nappi0901 = new javax.swing.JButton();
        nappi0902 = new javax.swing.JButton();
        nappi0903 = new javax.swing.JButton();
        nappi0904 = new javax.swing.JButton();
        nappi0905 = new javax.swing.JButton();
        nappi0906 = new javax.swing.JButton();
        nappi0907 = new javax.swing.JButton();
        nappi0908 = new javax.swing.JButton();
        nappi0909 = new javax.swing.JButton();
        nappi0910 = new javax.swing.JButton();
        nappi1001 = new javax.swing.JButton();
        nappi1002 = new javax.swing.JButton();
        nappi1003 = new javax.swing.JButton();
        nappi1004 = new javax.swing.JButton();
        nappi1005 = new javax.swing.JButton();
        nappi1006 = new javax.swing.JButton();
        nappi1007 = new javax.swing.JButton();
        nappi1008 = new javax.swing.JButton();
        nappi1009 = new javax.swing.JButton();
        nappi1010 = new javax.swing.JButton();
        piilosanaVastausKentta = new javax.swing.JLabel();
        etsittava = new javax.swing.JLabel();
        piilosanaVastaaNappi = new javax.swing.JButton();
        piilosanaUudelleenNappi = new javax.swing.JButton();
        laivanupotusPaneeli = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        laivanupotusOtsikko = new javax.swing.JLabel();
        laivanupotusNappi1 = new javax.swing.JButton();
        laivanupotusNappi2 = new javax.swing.JButton();
        laivanupotusNappi3 = new javax.swing.JButton();
        laivanupotusNappi4 = new javax.swing.JButton();
        laivanupotusNappi5 = new javax.swing.JButton();
        laivanupotusNappi6 = new javax.swing.JButton();
        laivanupotusNappi7 = new javax.swing.JButton();
        laivanupotusNappi8 = new javax.swing.JButton();
        laivanupotusNappi9 = new javax.swing.JButton();
        laivanupotusNappi10 = new javax.swing.JButton();
        laivanupotusNappi11 = new javax.swing.JButton();
        laivanupotusNappi12 = new javax.swing.JButton();
        laivanupotusNappi13 = new javax.swing.JButton();
        laivanupotusNappi14 = new javax.swing.JButton();
        laivanupotusNappi15 = new javax.swing.JButton();
        laivanupotusNappi16 = new javax.swing.JButton();
        laivanupotusNappi17 = new javax.swing.JButton();
        laivanupotusNappi18 = new javax.swing.JButton();
        laivanupotusNappi19 = new javax.swing.JButton();
        laivanupotusNappi20 = new javax.swing.JButton();
        laivanupotusNappi21 = new javax.swing.JButton();
        laivanupotusNappi22 = new javax.swing.JButton();
        laivanupotusNappi23 = new javax.swing.JButton();
        laivanupotusNappi24 = new javax.swing.JButton();
        laivanupotusNappi25 = new javax.swing.JButton();
        upotettavaKentta = new javax.swing.JLabel();
        lopetaPaneeli = new javax.swing.JPanel();
        lopetaNappi = new javax.swing.JButton();
        valitsePaneeli = new javax.swing.JPanel();
        valitse = new javax.swing.JLabel();
        anagrammiNappi = new javax.swing.JButton();
        piilosanaNappi = new javax.swing.JButton();
        laivanupotusNappi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        piilosanaPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 1, true));

        piilosanaOtsikko.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        piilosanaOtsikko.setText("Etsi piilosana");

        piilosanaOhje.setEditable(false);
        piilosanaOhje.setColumns(20);
        piilosanaOhje.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        piilosanaOhje.setRows(4);
        piilosanaOhje.setText("Etsi taulukosta seuraava sana.\nSanan perättäiset kirjaimet voivat olla toisiina nähden missä tahansa suunnassa\n(ylhäällä, alhaalla, vieressä, kulmittain).\nVoit perua kirjaimen lisäyksen painamalla nappia uudestaan.\n");
        piilosanaOhje.setAutoscrolls(false);
        jScrollPane2.setViewportView(piilosanaOhje);

        nappi0101.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0101.setText("1");
        nappi0101.setBorderPainted(false);
        nappi0101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0101ActionPerformed(evt);
            }
        });

        nappi0102.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0102.setText("2");
        nappi0102.setBorderPainted(false);
        nappi0102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0102ActionPerformed(evt);
            }
        });

        nappi0103.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0103.setText("3");
        nappi0103.setBorderPainted(false);
        nappi0103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0103ActionPerformed(evt);
            }
        });

        nappi0104.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0104.setText("4");
        nappi0104.setBorderPainted(false);
        nappi0104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0104ActionPerformed(evt);
            }
        });

        nappi0105.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0105.setText("5");
        nappi0105.setBorderPainted(false);
        nappi0105.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0105ActionPerformed(evt);
            }
        });

        nappi0106.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0106.setText("6");
        nappi0106.setBorderPainted(false);
        nappi0106.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0106ActionPerformed(evt);
            }
        });

        nappi0107.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0107.setText("7");
        nappi0107.setBorderPainted(false);
        nappi0107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0107ActionPerformed(evt);
            }
        });

        nappi0108.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0108.setText("8");
        nappi0108.setBorderPainted(false);
        nappi0108.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0108ActionPerformed(evt);
            }
        });

        nappi0109.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0109.setText("9");
        nappi0109.setBorderPainted(false);
        nappi0109.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0109ActionPerformed(evt);
            }
        });

        nappi0110.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0110.setText("10");
        nappi0110.setBorderPainted(false);
        nappi0110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0110ActionPerformed(evt);
            }
        });

        nappi0201.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0201.setText("1");
        nappi0201.setBorderPainted(false);
        nappi0201.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0201ActionPerformed(evt);
            }
        });

        nappi0202.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0202.setText("2");
        nappi0202.setBorderPainted(false);
        nappi0202.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0202ActionPerformed(evt);
            }
        });

        nappi0203.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0203.setText("3");
        nappi0203.setBorderPainted(false);
        nappi0203.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0203ActionPerformed(evt);
            }
        });

        nappi0204.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0204.setText("4");
        nappi0204.setBorderPainted(false);
        nappi0204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0204ActionPerformed(evt);
            }
        });

        nappi0205.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0205.setText("5");
        nappi0205.setBorderPainted(false);
        nappi0205.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0205ActionPerformed(evt);
            }
        });

        nappi0206.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0206.setText("6");
        nappi0206.setBorderPainted(false);
        nappi0206.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0206ActionPerformed(evt);
            }
        });

        nappi0207.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0207.setText("7");
        nappi0207.setBorderPainted(false);
        nappi0207.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0207ActionPerformed(evt);
            }
        });

        nappi0208.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0208.setText("8");
        nappi0208.setBorderPainted(false);
        nappi0208.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0208ActionPerformed(evt);
            }
        });

        nappi0209.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0209.setText("9");
        nappi0209.setBorderPainted(false);
        nappi0209.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0209ActionPerformed(evt);
            }
        });

        nappi0210.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0210.setText("10");
        nappi0210.setBorderPainted(false);
        nappi0210.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0210ActionPerformed(evt);
            }
        });

        nappi0301.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0301.setText("1");
        nappi0301.setBorderPainted(false);
        nappi0301.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0301ActionPerformed(evt);
            }
        });

        nappi0302.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0302.setText("2");
        nappi0302.setBorderPainted(false);
        nappi0302.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0302ActionPerformed(evt);
            }
        });

        nappi0303.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0303.setText("3");
        nappi0303.setBorderPainted(false);
        nappi0303.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0303ActionPerformed(evt);
            }
        });

        nappi0304.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0304.setText("4");
        nappi0304.setBorderPainted(false);
        nappi0304.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0304ActionPerformed(evt);
            }
        });

        nappi0305.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0305.setText("5");
        nappi0305.setBorderPainted(false);
        nappi0305.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0305ActionPerformed(evt);
            }
        });

        nappi0306.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0306.setText("6");
        nappi0306.setBorderPainted(false);
        nappi0306.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0306ActionPerformed(evt);
            }
        });

        nappi0307.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0307.setText("7");
        nappi0307.setBorderPainted(false);
        nappi0307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0307ActionPerformed(evt);
            }
        });

        nappi0308.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0308.setText("8");
        nappi0308.setBorderPainted(false);
        nappi0308.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0308ActionPerformed(evt);
            }
        });

        nappi0309.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0309.setText("9");
        nappi0309.setBorderPainted(false);
        nappi0309.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0309ActionPerformed(evt);
            }
        });

        nappi0310.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0310.setText("10");
        nappi0310.setBorderPainted(false);
        nappi0310.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0310ActionPerformed(evt);
            }
        });

        nappi0401.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0401.setText("1");
        nappi0401.setBorderPainted(false);
        nappi0401.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0401ActionPerformed(evt);
            }
        });

        nappi0402.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0402.setText("2");
        nappi0402.setBorderPainted(false);
        nappi0402.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0402ActionPerformed(evt);
            }
        });

        nappi0403.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0403.setText("3");
        nappi0403.setBorderPainted(false);
        nappi0403.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0403ActionPerformed(evt);
            }
        });

        nappi0404.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0404.setText("4");
        nappi0404.setBorderPainted(false);
        nappi0404.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0404ActionPerformed(evt);
            }
        });

        nappi0405.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0405.setText("5");
        nappi0405.setBorderPainted(false);
        nappi0405.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0405ActionPerformed(evt);
            }
        });

        nappi0406.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0406.setText("6");
        nappi0406.setBorderPainted(false);
        nappi0406.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0406ActionPerformed(evt);
            }
        });

        nappi0407.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0407.setText("7");
        nappi0407.setBorderPainted(false);
        nappi0407.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0407ActionPerformed(evt);
            }
        });

        nappi0408.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0408.setText("8");
        nappi0408.setBorderPainted(false);
        nappi0408.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0408ActionPerformed(evt);
            }
        });

        nappi0409.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0409.setText("9");
        nappi0409.setBorderPainted(false);
        nappi0409.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0409ActionPerformed(evt);
            }
        });

        nappi0410.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0410.setText("10");
        nappi0410.setBorderPainted(false);
        nappi0410.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0410ActionPerformed(evt);
            }
        });

        nappi0501.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0501.setText("1");
        nappi0501.setBorderPainted(false);
        nappi0501.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0501ActionPerformed(evt);
            }
        });

        nappi0502.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0502.setText("2");
        nappi0502.setBorderPainted(false);
        nappi0502.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0502ActionPerformed(evt);
            }
        });

        nappi0503.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0503.setText("3");
        nappi0503.setBorderPainted(false);
        nappi0503.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0503ActionPerformed(evt);
            }
        });

        nappi0504.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0504.setText("4");
        nappi0504.setBorderPainted(false);
        nappi0504.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0504ActionPerformed(evt);
            }
        });

        nappi0505.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0505.setText("5");
        nappi0505.setBorderPainted(false);
        nappi0505.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0505ActionPerformed(evt);
            }
        });

        nappi0506.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0506.setText("6");
        nappi0506.setBorderPainted(false);
        nappi0506.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0506ActionPerformed(evt);
            }
        });

        nappi0507.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0507.setText("7");
        nappi0507.setBorderPainted(false);
        nappi0507.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0507ActionPerformed(evt);
            }
        });

        nappi0508.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0508.setText("8");
        nappi0508.setBorderPainted(false);
        nappi0508.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0508ActionPerformed(evt);
            }
        });

        nappi0509.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0509.setText("9");
        nappi0509.setBorderPainted(false);
        nappi0509.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0509ActionPerformed(evt);
            }
        });

        nappi0510.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0510.setText("10");
        nappi0510.setBorderPainted(false);
        nappi0510.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0510ActionPerformed(evt);
            }
        });

        nappi0601.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0601.setText("1");
        nappi0601.setBorderPainted(false);
        nappi0601.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0601ActionPerformed(evt);
            }
        });

        nappi0602.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0602.setText("2");
        nappi0602.setBorderPainted(false);
        nappi0602.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0602ActionPerformed(evt);
            }
        });

        nappi0603.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0603.setText("3");
        nappi0603.setBorderPainted(false);
        nappi0603.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0603ActionPerformed(evt);
            }
        });

        nappi0604.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0604.setText("4");
        nappi0604.setBorderPainted(false);
        nappi0604.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0604ActionPerformed(evt);
            }
        });

        nappi0605.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0605.setText("5");
        nappi0605.setBorderPainted(false);
        nappi0605.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0605ActionPerformed(evt);
            }
        });

        nappi0606.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0606.setText("6");
        nappi0606.setBorderPainted(false);
        nappi0606.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0606ActionPerformed(evt);
            }
        });

        nappi0607.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0607.setText("7");
        nappi0607.setBorderPainted(false);
        nappi0607.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0607ActionPerformed(evt);
            }
        });

        nappi0608.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0608.setText("8");
        nappi0608.setBorderPainted(false);
        nappi0608.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0608ActionPerformed(evt);
            }
        });

        nappi0609.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0609.setText("9");
        nappi0609.setBorderPainted(false);
        nappi0609.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0609ActionPerformed(evt);
            }
        });

        nappi0610.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0610.setText("10");
        nappi0610.setBorderPainted(false);
        nappi0610.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0610ActionPerformed(evt);
            }
        });

        nappi0701.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0701.setText("1");
        nappi0701.setBorderPainted(false);
        nappi0701.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0701ActionPerformed(evt);
            }
        });

        nappi0702.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0702.setText("2");
        nappi0702.setBorderPainted(false);
        nappi0702.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0702ActionPerformed(evt);
            }
        });

        nappi0703.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0703.setText("3");
        nappi0703.setBorderPainted(false);
        nappi0703.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0703ActionPerformed(evt);
            }
        });

        nappi0704.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0704.setText("4");
        nappi0704.setBorderPainted(false);
        nappi0704.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0704ActionPerformed(evt);
            }
        });

        nappi0705.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0705.setText("5");
        nappi0705.setBorderPainted(false);
        nappi0705.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0705ActionPerformed(evt);
            }
        });

        nappi0706.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0706.setText("6");
        nappi0706.setBorderPainted(false);
        nappi0706.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0706ActionPerformed(evt);
            }
        });

        nappi0707.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0707.setText("7");
        nappi0707.setBorderPainted(false);
        nappi0707.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0707ActionPerformed(evt);
            }
        });

        nappi0708.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0708.setText("8");
        nappi0708.setBorderPainted(false);
        nappi0708.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0708ActionPerformed(evt);
            }
        });

        nappi0709.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0709.setText("9");
        nappi0709.setBorderPainted(false);
        nappi0709.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0709ActionPerformed(evt);
            }
        });

        nappi0710.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0710.setText("10");
        nappi0710.setBorderPainted(false);
        nappi0710.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0710ActionPerformed(evt);
            }
        });

        nappi0801.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0801.setText("1");
        nappi0801.setBorderPainted(false);
        nappi0801.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0801ActionPerformed(evt);
            }
        });

        nappi0802.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0802.setText("2");
        nappi0802.setBorderPainted(false);
        nappi0802.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0802ActionPerformed(evt);
            }
        });

        nappi0803.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0803.setText("3");
        nappi0803.setBorderPainted(false);
        nappi0803.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0803ActionPerformed(evt);
            }
        });

        nappi0804.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0804.setText("4");
        nappi0804.setBorderPainted(false);
        nappi0804.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0804ActionPerformed(evt);
            }
        });

        nappi0805.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0805.setText("5");
        nappi0805.setBorderPainted(false);
        nappi0805.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0805ActionPerformed(evt);
            }
        });

        nappi0806.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0806.setText("6");
        nappi0806.setBorderPainted(false);
        nappi0806.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0806ActionPerformed(evt);
            }
        });

        nappi0807.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0807.setText("7");
        nappi0807.setBorderPainted(false);
        nappi0807.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0807ActionPerformed(evt);
            }
        });

        nappi0808.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0808.setText("8");
        nappi0808.setBorderPainted(false);
        nappi0808.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0808ActionPerformed(evt);
            }
        });

        nappi0809.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0809.setText("9");
        nappi0809.setBorderPainted(false);
        nappi0809.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0809ActionPerformed(evt);
            }
        });

        nappi0810.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0810.setText("10");
        nappi0810.setBorderPainted(false);
        nappi0810.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0810ActionPerformed(evt);
            }
        });

        nappi0901.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0901.setText("1");
        nappi0901.setBorderPainted(false);
        nappi0901.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0901ActionPerformed(evt);
            }
        });

        nappi0902.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0902.setText("2");
        nappi0902.setBorderPainted(false);
        nappi0902.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0902ActionPerformed(evt);
            }
        });

        nappi0903.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0903.setText("3");
        nappi0903.setBorderPainted(false);
        nappi0903.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0903ActionPerformed(evt);
            }
        });

        nappi0904.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0904.setText("4");
        nappi0904.setBorderPainted(false);
        nappi0904.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0904ActionPerformed(evt);
            }
        });

        nappi0905.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0905.setText("5");
        nappi0905.setBorderPainted(false);
        nappi0905.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0905ActionPerformed(evt);
            }
        });

        nappi0906.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0906.setText("6");
        nappi0906.setBorderPainted(false);
        nappi0906.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0906ActionPerformed(evt);
            }
        });

        nappi0907.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0907.setText("7");
        nappi0907.setBorderPainted(false);
        nappi0907.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0907ActionPerformed(evt);
            }
        });

        nappi0908.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0908.setText("8");
        nappi0908.setBorderPainted(false);
        nappi0908.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0908ActionPerformed(evt);
            }
        });

        nappi0909.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0909.setText("9");
        nappi0909.setBorderPainted(false);
        nappi0909.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0909ActionPerformed(evt);
            }
        });

        nappi0910.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi0910.setText("10");
        nappi0910.setBorderPainted(false);
        nappi0910.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi0910ActionPerformed(evt);
            }
        });

        nappi1001.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi1001.setText("1");
        nappi1001.setBorderPainted(false);
        nappi1001.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi1001ActionPerformed(evt);
            }
        });

        nappi1002.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi1002.setText("2");
        nappi1002.setBorderPainted(false);
        nappi1002.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi1002ActionPerformed(evt);
            }
        });

        nappi1003.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi1003.setText("3");
        nappi1003.setBorderPainted(false);
        nappi1003.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi1003ActionPerformed(evt);
            }
        });

        nappi1004.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi1004.setText("4");
        nappi1004.setBorderPainted(false);
        nappi1004.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi1004ActionPerformed(evt);
            }
        });

        nappi1005.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi1005.setText("5");
        nappi1005.setBorderPainted(false);
        nappi1005.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi1005ActionPerformed(evt);
            }
        });

        nappi1006.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi1006.setText("6");
        nappi1006.setBorderPainted(false);
        nappi1006.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi1006ActionPerformed(evt);
            }
        });

        nappi1007.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi1007.setText("7");
        nappi1007.setBorderPainted(false);
        nappi1007.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi1007ActionPerformed(evt);
            }
        });

        nappi1008.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi1008.setText("8");
        nappi1008.setBorderPainted(false);
        nappi1008.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi1008ActionPerformed(evt);
            }
        });

        nappi1009.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi1009.setText("9");
        nappi1009.setBorderPainted(false);
        nappi1009.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi1009ActionPerformed(evt);
            }
        });

        nappi1010.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        nappi1010.setText("10");
        nappi1010.setBorderPainted(false);
        nappi1010.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nappi1010ActionPerformed(evt);
            }
        });

        piilosanaVastausKentta.setText("Vastaus: ");

        etsittava.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        etsittava.setText("etsittava");

        piilosanaVastaaNappi.setText("Vastaa");

        piilosanaUudelleenNappi.setText("Uudestaan");
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
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(piilosanaOtsikko))
                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etsittava)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(nappi0101)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0102)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0103)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0104)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0105)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0106)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0107))
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(nappi0201)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0202)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0203)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0204)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0205)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0206)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0207))
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(nappi0301)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0302)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0303)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0304)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0305)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0306)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0307))
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(nappi0401)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0402)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0403)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0404)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0405)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0406)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0407))
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(nappi0501)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0502)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0503)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0504)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0505)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0506)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0507))
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(nappi0601)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0602)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0603)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0604)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0605)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0606)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0607, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(nappi0701)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0702)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0703)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0704)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0705)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0706)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0707))
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(nappi0801)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0802)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0803)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0804)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0805)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0806)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0807))
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(nappi1001)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi1002)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi1003)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi1004)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi1005)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi1006)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi1007))
                                    .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                        .addComponent(nappi0901)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0902)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0903)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0904)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0905)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0906)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nappi0907)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nappi0108)
                                    .addComponent(nappi0208)
                                    .addComponent(nappi0308)
                                    .addComponent(nappi0408)
                                    .addComponent(nappi0508)
                                    .addComponent(nappi0608)
                                    .addComponent(nappi0708)
                                    .addComponent(nappi0808)
                                    .addComponent(nappi0908)
                                    .addComponent(nappi1008))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nappi0109)
                                    .addComponent(nappi0209)
                                    .addComponent(nappi0309)
                                    .addComponent(nappi0409)
                                    .addComponent(nappi0509)
                                    .addComponent(nappi0609)
                                    .addComponent(nappi0709)
                                    .addComponent(nappi0809)
                                    .addComponent(nappi0909)
                                    .addComponent(nappi1009))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nappi0110)
                                    .addComponent(nappi0210)
                                    .addComponent(nappi0310)
                                    .addComponent(nappi0410)
                                    .addComponent(nappi0510)
                                    .addComponent(nappi0610)
                                    .addComponent(nappi0710)
                                    .addComponent(nappi0810)
                                    .addComponent(nappi0910)
                                    .addComponent(nappi1010)))
                            .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                                .addComponent(piilosanaVastausKentta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(piilosanaVastaaNappi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(piilosanaUudelleenNappi)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        piilosanaPaneeliLayout.setVerticalGroup(
            piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(piilosanaPaneeliLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(piilosanaOtsikko)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etsittava)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nappi0101)
                    .addComponent(nappi0102)
                    .addComponent(nappi0103)
                    .addComponent(nappi0104)
                    .addComponent(nappi0105)
                    .addComponent(nappi0106)
                    .addComponent(nappi0107)
                    .addComponent(nappi0108)
                    .addComponent(nappi0109)
                    .addComponent(nappi0110))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nappi0201)
                    .addComponent(nappi0202)
                    .addComponent(nappi0203)
                    .addComponent(nappi0204)
                    .addComponent(nappi0205)
                    .addComponent(nappi0206)
                    .addComponent(nappi0207)
                    .addComponent(nappi0208)
                    .addComponent(nappi0209)
                    .addComponent(nappi0210))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nappi0301)
                    .addComponent(nappi0302)
                    .addComponent(nappi0303)
                    .addComponent(nappi0304)
                    .addComponent(nappi0305)
                    .addComponent(nappi0306)
                    .addComponent(nappi0307)
                    .addComponent(nappi0308)
                    .addComponent(nappi0309)
                    .addComponent(nappi0310))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nappi0401)
                    .addComponent(nappi0402)
                    .addComponent(nappi0403)
                    .addComponent(nappi0404)
                    .addComponent(nappi0405)
                    .addComponent(nappi0406)
                    .addComponent(nappi0407)
                    .addComponent(nappi0408)
                    .addComponent(nappi0409)
                    .addComponent(nappi0410))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nappi0501)
                    .addComponent(nappi0502)
                    .addComponent(nappi0503)
                    .addComponent(nappi0504)
                    .addComponent(nappi0505)
                    .addComponent(nappi0506)
                    .addComponent(nappi0507)
                    .addComponent(nappi0508)
                    .addComponent(nappi0509)
                    .addComponent(nappi0510))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nappi0601)
                    .addComponent(nappi0602)
                    .addComponent(nappi0603)
                    .addComponent(nappi0604)
                    .addComponent(nappi0605)
                    .addComponent(nappi0606)
                    .addComponent(nappi0607)
                    .addComponent(nappi0608)
                    .addComponent(nappi0609)
                    .addComponent(nappi0610))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nappi0701)
                    .addComponent(nappi0702)
                    .addComponent(nappi0703)
                    .addComponent(nappi0704)
                    .addComponent(nappi0705)
                    .addComponent(nappi0706)
                    .addComponent(nappi0707)
                    .addComponent(nappi0708)
                    .addComponent(nappi0709)
                    .addComponent(nappi0710))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nappi0801)
                    .addComponent(nappi0802)
                    .addComponent(nappi0803)
                    .addComponent(nappi0804)
                    .addComponent(nappi0805)
                    .addComponent(nappi0806)
                    .addComponent(nappi0807)
                    .addComponent(nappi0808)
                    .addComponent(nappi0809)
                    .addComponent(nappi0810))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nappi0901)
                    .addComponent(nappi0902)
                    .addComponent(nappi0903)
                    .addComponent(nappi0904)
                    .addComponent(nappi0905)
                    .addComponent(nappi0906)
                    .addComponent(nappi0907)
                    .addComponent(nappi0908)
                    .addComponent(nappi0909)
                    .addComponent(nappi0910))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nappi1001)
                    .addComponent(nappi1002)
                    .addComponent(nappi1003)
                    .addComponent(nappi1004)
                    .addComponent(nappi1005)
                    .addComponent(nappi1006)
                    .addComponent(nappi1007)
                    .addComponent(nappi1008)
                    .addComponent(nappi1009)
                    .addComponent(nappi1010))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(piilosanaVastausKentta)
                    .addComponent(piilosanaVastaaNappi)
                    .addComponent(piilosanaUudelleenNappi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        laivanupotusPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 51), 1, true));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        laivanupotusOtsikko.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        laivanupotusOtsikko.setText("Laivanupotus");

        laivanupotusNappi1.setText("1");
        laivanupotusNappi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi1ActionPerformed(evt);
            }
        });

        laivanupotusNappi2.setText("1");
        laivanupotusNappi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi2ActionPerformed(evt);
            }
        });

        laivanupotusNappi3.setText("1");
        laivanupotusNappi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi3ActionPerformed(evt);
            }
        });

        laivanupotusNappi4.setText("1");
        laivanupotusNappi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi4ActionPerformed(evt);
            }
        });

        laivanupotusNappi5.setText("1");
        laivanupotusNappi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi5ActionPerformed(evt);
            }
        });

        laivanupotusNappi6.setText("1");
        laivanupotusNappi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi6ActionPerformed(evt);
            }
        });

        laivanupotusNappi7.setText("1");
        laivanupotusNappi7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi7ActionPerformed(evt);
            }
        });

        laivanupotusNappi8.setText("1");
        laivanupotusNappi8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi8ActionPerformed(evt);
            }
        });

        laivanupotusNappi9.setText("1");
        laivanupotusNappi9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi9ActionPerformed(evt);
            }
        });

        laivanupotusNappi10.setText("1");
        laivanupotusNappi10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi10ActionPerformed(evt);
            }
        });

        laivanupotusNappi11.setText("1");
        laivanupotusNappi11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi11ActionPerformed(evt);
            }
        });

        laivanupotusNappi12.setText("1");
        laivanupotusNappi12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi12ActionPerformed(evt);
            }
        });

        laivanupotusNappi13.setText("1");
        laivanupotusNappi13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi13ActionPerformed(evt);
            }
        });

        laivanupotusNappi14.setText("1");
        laivanupotusNappi14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi14ActionPerformed(evt);
            }
        });

        laivanupotusNappi15.setText("1");
        laivanupotusNappi15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi15ActionPerformed(evt);
            }
        });

        laivanupotusNappi16.setText("1");
        laivanupotusNappi16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi16ActionPerformed(evt);
            }
        });

        laivanupotusNappi17.setText("1");
        laivanupotusNappi17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi17ActionPerformed(evt);
            }
        });

        laivanupotusNappi18.setText("1");
        laivanupotusNappi18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi18ActionPerformed(evt);
            }
        });

        laivanupotusNappi19.setText("1");
        laivanupotusNappi19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi19ActionPerformed(evt);
            }
        });

        laivanupotusNappi20.setText("1");
        laivanupotusNappi20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi20ActionPerformed(evt);
            }
        });

        laivanupotusNappi21.setText("1");
        laivanupotusNappi21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi21ActionPerformed(evt);
            }
        });

        laivanupotusNappi22.setText("1");
        laivanupotusNappi22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi22ActionPerformed(evt);
            }
        });

        laivanupotusNappi23.setText("1");
        laivanupotusNappi23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi23ActionPerformed(evt);
            }
        });

        laivanupotusNappi24.setText("1");
        laivanupotusNappi24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi24ActionPerformed(evt);
            }
        });

        laivanupotusNappi25.setText("1");
        laivanupotusNappi25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laivanupotusNappi25ActionPerformed(evt);
            }
        });

        upotettavaKentta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        upotettavaKentta.setText("upotettava");

        javax.swing.GroupLayout laivanupotusPaneeliLayout = new javax.swing.GroupLayout(laivanupotusPaneeli);
        laivanupotusPaneeli.setLayout(laivanupotusPaneeliLayout);
        laivanupotusPaneeliLayout.setHorizontalGroup(
            laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laivanupotusPaneeliLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(laivanupotusPaneeliLayout.createSequentialGroup()
                        .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(laivanupotusNappi1)
                            .addComponent(laivanupotusNappi6)
                            .addComponent(laivanupotusNappi11)
                            .addComponent(laivanupotusNappi16)
                            .addComponent(laivanupotusNappi21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(laivanupotusNappi2)
                            .addComponent(laivanupotusNappi7)
                            .addComponent(laivanupotusNappi12)
                            .addComponent(laivanupotusNappi17)
                            .addComponent(laivanupotusNappi22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(laivanupotusNappi3)
                            .addComponent(laivanupotusNappi8)
                            .addComponent(laivanupotusNappi13)
                            .addComponent(laivanupotusNappi18)
                            .addComponent(laivanupotusNappi23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(laivanupotusNappi4)
                            .addComponent(laivanupotusNappi9)
                            .addComponent(laivanupotusNappi14)
                            .addComponent(laivanupotusNappi19)
                            .addComponent(laivanupotusNappi24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(laivanupotusNappi5)
                            .addComponent(laivanupotusNappi10)
                            .addComponent(laivanupotusNappi15)
                            .addComponent(laivanupotusNappi20)
                            .addComponent(laivanupotusNappi25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(upotettavaKentta)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(laivanupotusPaneeliLayout.createSequentialGroup()
                        .addComponent(laivanupotusOtsikko)
                        .addGap(365, 365, 365)))
                .addContainerGap())
        );
        laivanupotusPaneeliLayout.setVerticalGroup(
            laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laivanupotusPaneeliLayout.createSequentialGroup()
                .addComponent(laivanupotusOtsikko)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laivanupotusNappi1)
                    .addComponent(laivanupotusNappi2)
                    .addComponent(laivanupotusNappi3)
                    .addComponent(laivanupotusNappi4)
                    .addComponent(laivanupotusNappi5)
                    .addComponent(upotettavaKentta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laivanupotusNappi6)
                    .addComponent(laivanupotusNappi7)
                    .addComponent(laivanupotusNappi8)
                    .addComponent(laivanupotusNappi9)
                    .addComponent(laivanupotusNappi10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laivanupotusNappi11)
                    .addComponent(laivanupotusNappi12)
                    .addComponent(laivanupotusNappi13)
                    .addComponent(laivanupotusNappi14)
                    .addComponent(laivanupotusNappi15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laivanupotusNappi16)
                    .addComponent(laivanupotusNappi17)
                    .addComponent(laivanupotusNappi18)
                    .addComponent(laivanupotusNappi19)
                    .addComponent(laivanupotusNappi20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laivanupotusNappi21)
                    .addComponent(laivanupotusNappi22)
                    .addComponent(laivanupotusNappi23)
                    .addComponent(laivanupotusNappi24)
                    .addComponent(laivanupotusNappi25))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        lopetaPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 1, true));

        lopetaNappi.setText("Lopeta");
        lopetaPaneeli.add(lopetaNappi);

        valitsePaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 1, true));

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ylaPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(anagrammiPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(piilosanaPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lopetaPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valitsePaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(laivanupotusPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(557, Short.MAX_VALUE))
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
                .addComponent(lopetaPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uudelleenNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uudelleenNappiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uudelleenNappiActionPerformed

    private void piilosanaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piilosanaNappiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_piilosanaNappiActionPerformed

    private void nappi0101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0101ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0101ActionPerformed

    private void nappi0102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0102ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0102ActionPerformed

    private void nappi0103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0103ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0103ActionPerformed

    private void nappi0104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0104ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0104ActionPerformed

    private void nappi0105ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0105ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0105ActionPerformed

    private void nappi0106ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0106ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0106ActionPerformed

    private void nappi0107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0107ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0107ActionPerformed

    private void nappi0108ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0108ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0108ActionPerformed

    private void nappi0109ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0109ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0109ActionPerformed

    private void nappi0110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0110ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0110ActionPerformed

    private void nappi0201ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0201ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0201ActionPerformed

    private void nappi0202ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0202ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0202ActionPerformed

    private void nappi0203ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0203ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0203ActionPerformed

    private void nappi0204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0204ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0204ActionPerformed

    private void nappi0205ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0205ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0205ActionPerformed

    private void nappi0206ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0206ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0206ActionPerformed

    private void nappi0207ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0207ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0207ActionPerformed

    private void nappi0208ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0208ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0208ActionPerformed

    private void nappi0209ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0209ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0209ActionPerformed

    private void nappi0210ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0210ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0210ActionPerformed

    private void nappi0301ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0301ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0301ActionPerformed

    private void nappi0302ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0302ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0302ActionPerformed

    private void nappi0303ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0303ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0303ActionPerformed

    private void nappi0304ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0304ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0304ActionPerformed

    private void nappi0305ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0305ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0305ActionPerformed

    private void nappi0306ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0306ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0306ActionPerformed

    private void nappi0307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0307ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0307ActionPerformed

    private void nappi0308ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0308ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0308ActionPerformed

    private void nappi0309ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0309ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0309ActionPerformed

    private void nappi0310ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0310ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0310ActionPerformed

    private void nappi0401ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0401ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0401ActionPerformed

    private void nappi0402ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0402ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0402ActionPerformed

    private void nappi0403ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0403ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0403ActionPerformed

    private void nappi0404ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0404ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0404ActionPerformed

    private void nappi0405ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0405ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0405ActionPerformed

    private void nappi0406ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0406ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0406ActionPerformed

    private void nappi0407ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0407ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0407ActionPerformed

    private void nappi0408ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0408ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0408ActionPerformed

    private void nappi0409ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0409ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0409ActionPerformed

    private void nappi0410ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0410ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0410ActionPerformed

    private void nappi0501ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0501ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0501ActionPerformed

    private void nappi0502ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0502ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0502ActionPerformed

    private void nappi0503ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0503ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0503ActionPerformed

    private void nappi0504ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0504ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0504ActionPerformed

    private void nappi0505ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0505ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0505ActionPerformed

    private void nappi0506ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0506ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0506ActionPerformed

    private void nappi0507ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0507ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0507ActionPerformed

    private void nappi0508ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0508ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0508ActionPerformed

    private void nappi0509ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0509ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0509ActionPerformed

    private void nappi0510ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0510ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0510ActionPerformed

    private void nappi0601ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0601ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0601ActionPerformed

    private void nappi0602ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0602ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0602ActionPerformed

    private void nappi0603ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0603ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0603ActionPerformed

    private void nappi0604ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0604ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0604ActionPerformed

    private void nappi0605ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0605ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0605ActionPerformed

    private void nappi0606ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0606ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0606ActionPerformed

    private void nappi0607ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0607ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0607ActionPerformed

    private void nappi0608ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0608ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0608ActionPerformed

    private void nappi0609ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0609ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0609ActionPerformed

    private void nappi0610ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0610ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0610ActionPerformed

    private void nappi0701ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0701ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0701ActionPerformed

    private void nappi0702ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0702ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0702ActionPerformed

    private void nappi0703ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0703ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0703ActionPerformed

    private void nappi0704ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0704ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0704ActionPerformed

    private void nappi0705ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0705ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0705ActionPerformed

    private void nappi0706ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0706ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0706ActionPerformed

    private void nappi0707ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0707ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0707ActionPerformed

    private void nappi0708ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0708ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0708ActionPerformed

    private void nappi0709ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0709ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0709ActionPerformed

    private void nappi0710ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0710ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0710ActionPerformed

    private void nappi0801ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0801ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0801ActionPerformed

    private void nappi0802ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0802ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0802ActionPerformed

    private void nappi0803ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0803ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0803ActionPerformed

    private void nappi0804ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0804ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0804ActionPerformed

    private void nappi0805ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0805ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0805ActionPerformed

    private void nappi0806ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0806ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0806ActionPerformed

    private void nappi0807ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0807ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0807ActionPerformed

    private void nappi0808ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0808ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0808ActionPerformed

    private void nappi0809ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0809ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0809ActionPerformed

    private void nappi0810ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0810ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0810ActionPerformed

    private void nappi0901ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0901ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0901ActionPerformed

    private void nappi0902ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0902ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0902ActionPerformed

    private void nappi0903ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0903ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0903ActionPerformed

    private void nappi0904ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0904ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0904ActionPerformed

    private void nappi0905ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0905ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0905ActionPerformed

    private void nappi0906ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0906ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0906ActionPerformed

    private void nappi0907ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0907ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0907ActionPerformed

    private void nappi0908ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0908ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0908ActionPerformed

    private void nappi0909ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0909ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0909ActionPerformed

    private void nappi0910ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi0910ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi0910ActionPerformed

    private void nappi1001ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi1001ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi1001ActionPerformed

    private void nappi1002ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi1002ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi1002ActionPerformed

    private void nappi1003ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi1003ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi1003ActionPerformed

    private void nappi1004ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi1004ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi1004ActionPerformed

    private void nappi1005ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi1005ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi1005ActionPerformed

    private void nappi1006ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi1006ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi1006ActionPerformed

    private void nappi1007ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi1007ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi1007ActionPerformed

    private void nappi1008ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi1008ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi1008ActionPerformed

    private void nappi1009ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi1009ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi1009ActionPerformed

    private void nappi1010ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nappi1010ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nappi1010ActionPerformed

    private void okNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okNappiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okNappiActionPerformed

    private void pelaajanNimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelaajanNimiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pelaajanNimiActionPerformed

    private void piilosanaUudelleenNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piilosanaUudelleenNappiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_piilosanaUudelleenNappiActionPerformed

    private void laivanupotusNappi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi1ActionPerformed

    private void laivanupotusNappi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi2ActionPerformed

    private void laivanupotusNappi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi3ActionPerformed

    private void laivanupotusNappi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi4ActionPerformed

    private void laivanupotusNappi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi5ActionPerformed

    private void laivanupotusNappi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi6ActionPerformed

    private void laivanupotusNappi7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi7ActionPerformed

    private void laivanupotusNappi8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi8ActionPerformed

    private void laivanupotusNappi9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi9ActionPerformed

    private void laivanupotusNappi10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi10ActionPerformed

    private void laivanupotusNappi11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi11ActionPerformed

    private void laivanupotusNappi12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi12ActionPerformed

    private void laivanupotusNappi13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi13ActionPerformed

    private void laivanupotusNappi14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi14ActionPerformed

    private void laivanupotusNappi15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi15ActionPerformed

    private void laivanupotusNappi16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi16ActionPerformed

    private void laivanupotusNappi17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi17ActionPerformed

    private void laivanupotusNappi18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi18ActionPerformed

    private void laivanupotusNappi19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi19ActionPerformed

    private void laivanupotusNappi20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi20ActionPerformed

    private void laivanupotusNappi21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi21ActionPerformed

    private void laivanupotusNappi22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi22ActionPerformed

    private void laivanupotusNappi23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi23ActionPerformed

    private void laivanupotusNappi24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi24ActionPerformed

    private void laivanupotusNappi25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laivanupotusNappi25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laivanupotusNappi25ActionPerformed

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
    private javax.swing.JButton laivanupotusNappi;
    private javax.swing.JButton laivanupotusNappi1;
    private javax.swing.JButton laivanupotusNappi10;
    private javax.swing.JButton laivanupotusNappi11;
    private javax.swing.JButton laivanupotusNappi12;
    private javax.swing.JButton laivanupotusNappi13;
    private javax.swing.JButton laivanupotusNappi14;
    private javax.swing.JButton laivanupotusNappi15;
    private javax.swing.JButton laivanupotusNappi16;
    private javax.swing.JButton laivanupotusNappi17;
    private javax.swing.JButton laivanupotusNappi18;
    private javax.swing.JButton laivanupotusNappi19;
    private javax.swing.JButton laivanupotusNappi2;
    private javax.swing.JButton laivanupotusNappi20;
    private javax.swing.JButton laivanupotusNappi21;
    private javax.swing.JButton laivanupotusNappi22;
    private javax.swing.JButton laivanupotusNappi23;
    private javax.swing.JButton laivanupotusNappi24;
    private javax.swing.JButton laivanupotusNappi25;
    private javax.swing.JButton laivanupotusNappi3;
    private javax.swing.JButton laivanupotusNappi4;
    private javax.swing.JButton laivanupotusNappi5;
    private javax.swing.JButton laivanupotusNappi6;
    private javax.swing.JButton laivanupotusNappi7;
    private javax.swing.JButton laivanupotusNappi8;
    private javax.swing.JButton laivanupotusNappi9;
    private javax.swing.JLabel laivanupotusOtsikko;
    private javax.swing.JPanel laivanupotusPaneeli;
    private javax.swing.JButton lopetaNappi;
    private javax.swing.JPanel lopetaPaneeli;
    private javax.swing.JButton nappi0101;
    private javax.swing.JButton nappi0102;
    private javax.swing.JButton nappi0103;
    private javax.swing.JButton nappi0104;
    private javax.swing.JButton nappi0105;
    private javax.swing.JButton nappi0106;
    private javax.swing.JButton nappi0107;
    private javax.swing.JButton nappi0108;
    private javax.swing.JButton nappi0109;
    private javax.swing.JButton nappi0110;
    private javax.swing.JButton nappi0201;
    private javax.swing.JButton nappi0202;
    private javax.swing.JButton nappi0203;
    private javax.swing.JButton nappi0204;
    private javax.swing.JButton nappi0205;
    private javax.swing.JButton nappi0206;
    private javax.swing.JButton nappi0207;
    private javax.swing.JButton nappi0208;
    private javax.swing.JButton nappi0209;
    private javax.swing.JButton nappi0210;
    private javax.swing.JButton nappi0301;
    private javax.swing.JButton nappi0302;
    private javax.swing.JButton nappi0303;
    private javax.swing.JButton nappi0304;
    private javax.swing.JButton nappi0305;
    private javax.swing.JButton nappi0306;
    private javax.swing.JButton nappi0307;
    private javax.swing.JButton nappi0308;
    private javax.swing.JButton nappi0309;
    private javax.swing.JButton nappi0310;
    private javax.swing.JButton nappi0401;
    private javax.swing.JButton nappi0402;
    private javax.swing.JButton nappi0403;
    private javax.swing.JButton nappi0404;
    private javax.swing.JButton nappi0405;
    private javax.swing.JButton nappi0406;
    private javax.swing.JButton nappi0407;
    private javax.swing.JButton nappi0408;
    private javax.swing.JButton nappi0409;
    private javax.swing.JButton nappi0410;
    private javax.swing.JButton nappi0501;
    private javax.swing.JButton nappi0502;
    private javax.swing.JButton nappi0503;
    private javax.swing.JButton nappi0504;
    private javax.swing.JButton nappi0505;
    private javax.swing.JButton nappi0506;
    private javax.swing.JButton nappi0507;
    private javax.swing.JButton nappi0508;
    private javax.swing.JButton nappi0509;
    private javax.swing.JButton nappi0510;
    private javax.swing.JButton nappi0601;
    private javax.swing.JButton nappi0602;
    private javax.swing.JButton nappi0603;
    private javax.swing.JButton nappi0604;
    private javax.swing.JButton nappi0605;
    private javax.swing.JButton nappi0606;
    private javax.swing.JButton nappi0607;
    private javax.swing.JButton nappi0608;
    private javax.swing.JButton nappi0609;
    private javax.swing.JButton nappi0610;
    private javax.swing.JButton nappi0701;
    private javax.swing.JButton nappi0702;
    private javax.swing.JButton nappi0703;
    private javax.swing.JButton nappi0704;
    private javax.swing.JButton nappi0705;
    private javax.swing.JButton nappi0706;
    private javax.swing.JButton nappi0707;
    private javax.swing.JButton nappi0708;
    private javax.swing.JButton nappi0709;
    private javax.swing.JButton nappi0710;
    private javax.swing.JButton nappi0801;
    private javax.swing.JButton nappi0802;
    private javax.swing.JButton nappi0803;
    private javax.swing.JButton nappi0804;
    private javax.swing.JButton nappi0805;
    private javax.swing.JButton nappi0806;
    private javax.swing.JButton nappi0807;
    private javax.swing.JButton nappi0808;
    private javax.swing.JButton nappi0809;
    private javax.swing.JButton nappi0810;
    private javax.swing.JButton nappi0901;
    private javax.swing.JButton nappi0902;
    private javax.swing.JButton nappi0903;
    private javax.swing.JButton nappi0904;
    private javax.swing.JButton nappi0905;
    private javax.swing.JButton nappi0906;
    private javax.swing.JButton nappi0907;
    private javax.swing.JButton nappi0908;
    private javax.swing.JButton nappi0909;
    private javax.swing.JButton nappi0910;
    private javax.swing.JButton nappi1001;
    private javax.swing.JButton nappi1002;
    private javax.swing.JButton nappi1003;
    private javax.swing.JButton nappi1004;
    private javax.swing.JButton nappi1005;
    private javax.swing.JButton nappi1006;
    private javax.swing.JButton nappi1007;
    private javax.swing.JButton nappi1008;
    private javax.swing.JButton nappi1009;
    private javax.swing.JButton nappi1010;
    private javax.swing.JButton okNappi;
    private javax.swing.JTextField pelaajanNimi;
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
