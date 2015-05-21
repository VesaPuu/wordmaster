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
    public void testGetPisteet() {
        assertEquals(p.getPisteet(), 0);
    }

    @Test
    public void testGetNimi() {
        assertEquals(p.getNimi(), "Heikki");
    }

    @Test
    public void testSetPisteet() {
        assertEquals(p.setPisteet(5), true);
        assertEquals(p.getPisteet(), 5);
    }

    @Test
    public void testToString() {
        assertEquals(p.toString(), "Heikki, 0");
    }

}
