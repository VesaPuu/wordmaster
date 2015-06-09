package wordmaster;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class SanaTest {

    public Sana s;

    @Before
    public void setUp() {
        s = new Sana("koira");
    }

    @Test
    public void testGetPituus() {
        assertEquals(s.getPituus(), 5);
    }

    @Test
    public void testGetSana() {
        assertEquals(s.getSana(), "KOIRA");
    }

    @Test
    public void testToString() {
        assertEquals(s.toString(), "KOIRA");
    }
}
