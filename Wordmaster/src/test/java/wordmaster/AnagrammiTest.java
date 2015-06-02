/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordmaster;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vesa
 */
public class AnagrammiTest {

    Anagrammi a;

    @BeforeClass
    public static void setUpClass() throws Exception {
        Anagrammi a = new Anagrammi();
    }

    @Test
    public void testAloita() {
        Anagrammi a = new Anagrammi();
        Sana no = new Sana("no");
        assertTrue(a.aloita(no).equals("NO") || a.aloita(no).equals("ON"));
    }

    @Test
    public void testOvatkoAnagrammeja() {
        Anagrammi a = new Anagrammi();
        Sana kissa = new Sana("kissa");
        Sana kassi = new Sana("kassi");
        assertTrue(Anagrammi.ovatkoAnagrammeja(kissa.getSana(), kassi.getSana()));
    }

}
