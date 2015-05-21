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

    @Test
    public void testTeeAnagrammi() {
        assertEquals(Sana.teeAnagrammi("koira"), true);
    }

    @Test
    public void testPermutoi() {
        String k = "koira";
        char[] in;
        in = k.toCharArray();
        StringBuffer outputString = new StringBuffer();
        boolean[] used = new boolean[k.length()];
        int inputLength = 0, level = 0;
        assertEquals(Sana.permutoi(in, outputString,
                used, inputLength, level), true);
    }
}
