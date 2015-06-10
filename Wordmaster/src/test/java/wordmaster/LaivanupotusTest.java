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
public class LaivanupotusTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        Laivanupotus l = new Laivanupotus();
    }

    @Test
    public void testLisaaMerkki() {
        Laivanupotus l = new Laivanupotus();
        assertEquals(true, l.lisaaMerkki(0, 0, 'a'));
    }

    @Test
    public void testPalautaMerkki() {
        Laivanupotus l = new Laivanupotus();
        l.lisaaMerkki(0, 0, 'a');
        assertEquals("" + 'a', l.palautaMerkki(0, 0));
    }

    @Test
    public void testSanastaMerkkitaulukko() {
        Laivanupotus l = new Laivanupotus();
        Sana kissa = new Sana("kissa");
        char[] katti = {'K', 'I', 'S', 'S', 'A'};
        Assert.assertArrayEquals(katti, l.sanastaMerkkitaulukko(kissa));
    }

    @Test
    public void testMuutaArvoaSatunnaisesti() {
        Laivanupotus l = new Laivanupotus();
        int i = l.muutaArvoaSatunnaisesti(0);
        assertTrue(i == -1 || i == 0 || i == 1);
    }

    @Test
    public void testOnkoTyhja() {
        Laivanupotus l = new Laivanupotus();
        assertEquals(true, l.onkoTyhja(0, 0));
    }

    @Test
    public void testTyhjennaKaikki() {
        Laivanupotus l = new Laivanupotus();
        l.taytaKaikki();
        l.tyhjennaKaikki();
        assertEquals(true, l.onkoTyhja(0, 0));
    }

    @Test
    public void testTaytaKaikki() {
        Laivanupotus l = new Laivanupotus();
        l.tyhjennaKaikki();
        l.taytaKaikki();
        assertEquals(false, l.onkoTyhja(0, 0));
    }

    @Test
    public void testOnkoTyhjaEpaonnistuu() {
        Laivanupotus l = new Laivanupotus();
        l.lisaaMerkki(0, 0, 'a');
        assertEquals(false, l.onkoTyhja(0, 0));
    }

    @Test
    public void testSijoitaSana() {
        Laivanupotus l = new Laivanupotus();
        Sana kissa = new Sana("kissa");
        assertEquals(true, l.sijoitaSana(kissa));
    }
}
