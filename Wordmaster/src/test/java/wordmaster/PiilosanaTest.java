/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordmaster;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vesa
 */
public class PiilosanaTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        Piilosana p = new Piilosana();
    }

    @Test
    public void testLisaaMerkki() {
        Piilosana p = new Piilosana();
        assertEquals(true, p.lisaaMerkki(0, 0, 'a'));
    }

    @Test
    public void testPalautaMerkki() {
        Piilosana p = new Piilosana();
        p.lisaaMerkki(0, 0, 'a');
        assertEquals("" + 'a', p.palautaMerkki(0, 0));
    }

    @Test
    public void testSanastaMerkkitaulukko() {
        Piilosana p = new Piilosana();
        Sana kissa = new Sana("kissa");
        char[] katti = {'K', 'I', 'S', 'S', 'A'};
        Assert.assertArrayEquals(katti, p.sanastaMerkkitaulukko(kissa));
    }

    @Test
    public void testMuutaArvoaSatunnaisesti() {
        Piilosana p = new Piilosana();
        int i = p.muutaArvoaSatunnaisesti(0);
        assertTrue(i == -1 || i == 0 || i == 1);
    }

    @Test
    public void testOnkoTyhja() {
        Piilosana p = new Piilosana();
        assertEquals(true, p.onkoTyhja(0, 0));
    }

    @Test
    public void testOnkoTyhjaEpaonnistuu() {
        Piilosana p = new Piilosana();
        p.lisaaMerkki(0, 0, 'a');
        assertEquals(false, p.onkoTyhja(0, 0));
    }

    @Test
    public void testTyhjennaKaikki() {
        Piilosana p = new Piilosana();
        p.taytaKaikki();
        p.tyhjennaKaikki();
        assertEquals(true, p.onkoTyhja(0, 0));
    }

    @Test
    public void testTaytaKaikki() {
        Piilosana p = new Piilosana();
        p.tyhjennaKaikki();
        p.taytaKaikki();
        assertEquals(false, p.onkoTyhja(0, 0));
    }

    @Test
    public void testSijoitaSana() {
        Piilosana p = new Piilosana();
        Sana kissa = new Sana("kissa");
        assertEquals(true, p.sijoitaSana(kissa));
    }

}
