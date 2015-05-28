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
public class PeliTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        Peli p = new Peli();
    }

    @Test
    public void testLisaaMerkki() {
        Peli p = new Peli();
        assertEquals(true, p.lisaaMerkki(0, 0, 'a'));
    }

    @Test
    public void testPalautaMerkki() {
        Peli p = new Peli();
        p.lisaaMerkki(0, 0, 'a');
        assertEquals('a', p.palautaMerkki(0, 0));
    }

    @Test
    public void testSanastaMerkkitaulukko() {
        Peli p = new Peli();
        Sana kissa = new Sana("kissa");
        char[] katti = {'K', 'I', 'S', 'S', 'A'};
        Assert.assertArrayEquals(katti, p.sanastaMerkkitaulukko(kissa));
    }

    @Test
    public void testMuutaArvoaSatunnaisesti() {
        Peli p = new Peli();
        int i = p.muutaArvoaSatunnaisesti(0);
        assertTrue(i == -1 || i == 0 || i == 1);
    }

    @Test
    public void testOnkoTyhja() {
        Peli p = new Peli();
        assertEquals(true, p.onkoTyhja(0, 0));
    }

    @Test
    public void testOnkoTyhjaEpaonnistuu() {
        Peli p = new Peli();
        p.lisaaMerkki(0, 0, 'a');
        assertEquals(false, p.onkoTyhja(0, 0));
    }

    @Test
    public void testSijoitaSana() {
        Peli p = new Peli();
        Sana kissa = new Sana("kissa");
        assertEquals(true, p.sijoitaSana(kissa));
    }

}
