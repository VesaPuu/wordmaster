package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import wordmaster.Anagrammi;
import wordmaster.Sana;

public class GraafinenKayttoliittyma extends javax.swing.JFrame implements ActionListener {

    static TiedostonLukija tl;
    Anagrammi anagrammi;
    int vihjeet;
    int sananPituus;
    String anagrammiSana;
    Sana anagrammiksiMuutettava;
    String vihjeteksti;

    /**
     * Creates new form GraafinenKayttoliittyma
     */
    public GraafinenKayttoliittyma() throws FileNotFoundException, Exception {
        initComponents();
        anagrammiKentta.setText("");
        vastaaNappi.addActionListener(this);
        vastaus.addActionListener(this);
        anagrammiNappi.addActionListener(this);
        piilosanaNappi.addActionListener(this);
        laivanupotusNappi.addActionListener(this);
        vihjeNappi.addActionListener(this);
        lopetaNappi.addActionListener(this);
        uudelleenNappi.addActionListener(this);
        this.tl = new TiedostonLukija(); // luodaan uusi Tiedostonlukija-olio
        tl.lueTiedosto();
        this.anagrammi = new Anagrammi();
        this.vihjeet = 0;
        this.sananPituus = 0;
        anagrammiPaneeli.setVisible(false);
        piilosanaPaneeli.setVisible(false);
        laivanupotusPaneeli.setVisible(false);
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
        String anagrammiSana = anagrammi.aloita(anagrammiksiMuutettava);
        sananPituus = anagrammiSana.length();
        anagrammiKentta.setText(anagrammiSana);
        vihjeteksti = Character.toString(anagrammiksiMuutettava.getSana().charAt(0));
        vihje.setText("Sana alkaa " + vihjeteksti);
        vihjeita.setText("Vihjeet " + vihjeet + ", sanan pituus " + sananPituus);

    }

    public void aloitaPiilosana() {
    }

    public void aloitaLaivanupotus() {
    }

    public void actionPerformed(ActionEvent e) {

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

        if (e.getSource().equals(vastaaNappi)) {
            tuomioKentta.setText("");

            if (Anagrammi.ovatkoAnagrammeja(vastaus.getText(), anagrammiksiMuutettava.getSana())) {

                anagrammiKentta.setText("");
                vihje.setText("");
                tuomioKentta.setText("Oikein!");
                vihjeNappi.setVisible(false);
                vastaus.setVisible(false);
                vastaaNappi.setVisible(false);
                uudelleenNappi.setVisible(true);
                otsikko.setVisible(false);
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
            ;
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
        otsikko = new javax.swing.JLabel();
        anagrammiKentta = new javax.swing.JLabel();
        vihje = new javax.swing.JLabel();
        vastaus = new javax.swing.JFormattedTextField();
        vastaaNappi = new javax.swing.JButton();
        vihjeNappi = new javax.swing.JButton();
        vihjeita = new javax.swing.JLabel();
        uudelleenNappi = new javax.swing.JButton();
        tuomioKentta = new javax.swing.JLabel();
        ylaPaneeli = new javax.swing.JPanel();
        valitse = new javax.swing.JLabel();
        anagrammiNappi = new javax.swing.JButton();
        piilosanaNappi = new javax.swing.JButton();
        laivanupotusNappi = new javax.swing.JButton();
        piilosanaPaneeli = new javax.swing.JPanel();
        laivanupotusPaneeli = new javax.swing.JPanel();
        lopetaPaneeli = new javax.swing.JPanel();
        lopetaNappi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        anagrammiPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true));

        otsikko.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        otsikko.setText("Minkä sanan anagrammi on...");

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
                    .addComponent(otsikko)
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
                    .addGroup(anagrammiPaneeliLayout.createSequentialGroup()
                        .addComponent(tuomioKentta)
                        .addGap(307, 307, 307)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        anagrammiPaneeliLayout.setVerticalGroup(
            anagrammiPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anagrammiPaneeliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(otsikko)
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

        javax.swing.GroupLayout ylaPaneeliLayout = new javax.swing.GroupLayout(ylaPaneeli);
        ylaPaneeli.setLayout(ylaPaneeliLayout);
        ylaPaneeliLayout.setHorizontalGroup(
            ylaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ylaPaneeliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ylaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valitse)
                    .addGroup(ylaPaneeliLayout.createSequentialGroup()
                        .addComponent(anagrammiNappi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(piilosanaNappi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(laivanupotusNappi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ylaPaneeliLayout.setVerticalGroup(
            ylaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ylaPaneeliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valitse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ylaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anagrammiNappi)
                    .addComponent(piilosanaNappi)
                    .addComponent(laivanupotusNappi))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        piilosanaPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 1, true));

        javax.swing.GroupLayout piilosanaPaneeliLayout = new javax.swing.GroupLayout(piilosanaPaneeli);
        piilosanaPaneeli.setLayout(piilosanaPaneeliLayout);
        piilosanaPaneeliLayout.setHorizontalGroup(
            piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        piilosanaPaneeliLayout.setVerticalGroup(
            piilosanaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        laivanupotusPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 51), 1, true));

        javax.swing.GroupLayout laivanupotusPaneeliLayout = new javax.swing.GroupLayout(laivanupotusPaneeli);
        laivanupotusPaneeli.setLayout(laivanupotusPaneeliLayout);
        laivanupotusPaneeliLayout.setHorizontalGroup(
            laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        laivanupotusPaneeliLayout.setVerticalGroup(
            laivanupotusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        lopetaPaneeli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 1, true));

        lopetaNappi.setText("Lopeta");

        javax.swing.GroupLayout lopetaPaneeliLayout = new javax.swing.GroupLayout(lopetaPaneeli);
        lopetaPaneeli.setLayout(lopetaPaneeliLayout);
        lopetaPaneeliLayout.setHorizontalGroup(
            lopetaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lopetaPaneeliLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lopetaNappi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );
        lopetaPaneeliLayout.setVerticalGroup(
            lopetaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lopetaPaneeliLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(lopetaNappi))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(anagrammiPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ylaPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(piilosanaPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(laivanupotusPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lopetaPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ylaPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JPanel anagrammiPaneeli;
    private javax.swing.JButton laivanupotusNappi;
    private javax.swing.JPanel laivanupotusPaneeli;
    private javax.swing.JButton lopetaNappi;
    private javax.swing.JPanel lopetaPaneeli;
    private javax.swing.JLabel otsikko;
    private javax.swing.JButton piilosanaNappi;
    private javax.swing.JPanel piilosanaPaneeli;
    private javax.swing.JLabel tuomioKentta;
    private javax.swing.JButton uudelleenNappi;
    private javax.swing.JLabel valitse;
    private javax.swing.JButton vastaaNappi;
    private javax.swing.JFormattedTextField vastaus;
    private javax.swing.JLabel vihje;
    private javax.swing.JButton vihjeNappi;
    private javax.swing.JLabel vihjeita;
    private javax.swing.JPanel ylaPaneeli;
    // End of variables declaration//GEN-END:variables

}
