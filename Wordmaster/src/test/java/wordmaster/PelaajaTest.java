package wordmaster;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PelaajaTest {

    Pelaaja p;

    @Before
    public void setUp() {
        p = new Pelaaja("Heikki");
    }

    @Test
    public void testGetAnagrammiPisteet() {
        assertEquals(p.getAnagrammiPisteet(), 0);
    }

    @Test
    public void testGetPiilosanaPisteet() {
        assertEquals(p.getPiilosanaPisteet(), 0);
    }

    @Test
    public void testGetLaivanupotusPisteet() {
        assertEquals(p.getLaivanupotusPisteet(), 0);
    }

    @Test
    public void testGetNimi() {
        assertEquals(p.getNimi(), "Heikki");
    }

    @Test
    public void testSetAnagrammiPisteet() {
        assertEquals(p.setAnagrammiPisteet(5), true);
        assertEquals(p.getAnagrammiPisteet(), 5);
    }

    @Test
    public void testSetPiilosanaPisteet() {
        assertEquals(p.setPiilosanaPisteet(5), true);
        assertEquals(p.getPiilosanaPisteet(), 5);
    }

    @Test
    public void testSetLaivanupotusPisteet() {
        assertEquals(p.setLaivanupotusPisteet(5), true);
        assertEquals(p.getLaivanupotusPisteet(), 5);
    }

    @Test
    public void testLisaaAnagrammiPisteet() {
        p.lisaaAnagrammiPisteet(10);
        p.lisaaAnagrammiPisteet(5);
        assertEquals(p.getAnagrammiPisteet(), 15);
    }

    @Test
    public void testLisaaPiilosanaPisteet() {
        p.lisaaPiilosanaPisteet(10);
        p.lisaaPiilosanaPisteet(5);
        assertEquals(p.getPiilosanaPisteet(), 15);
    }

    @Test
    public void testLisaaLaivanupotusPisteet() {
        p.lisaaLaivanupotusPisteet(10);
        p.lisaaLaivanupotusPisteet(5);
        assertEquals(p.getLaivanupotusPisteet(), 15);
    }

    @Test
    public void testToString() {
        assertEquals(p.toString(), "Heikki, 0, 0, 0");
    }

}
