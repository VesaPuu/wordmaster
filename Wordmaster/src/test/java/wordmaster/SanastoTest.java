package wordmaster;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

public class SanastoTest {

//    private Sanasto s;
//    private Sana sana;
    @BeforeClass
    public static void setUpClass() throws Exception {
        Sanasto s = new Sanasto();
        Sana sana = new Sana("hohotus");
    }

    @Test
    public void testLisaaSana() {
        Sanasto s = new Sanasto();
        assertEquals(true, s.lisaaSana(new Sana("hohotus")));
    }

    @Test
    public void testLuoRandomSana() {
        Sanasto s = new Sanasto();
        s.lisaaSana(new Sana("hohotus"));
        s.lisaaSana(new Sana("hihitys"));
        s.lisaaSana(new Sana("hekotus"));
        Sana sana = s.luoRandomSana();
        assertTrue(sana.getSana().equals("HIHITYS") || sana.getSana().equals("HOHOTUS") || sana.getSana().equals("HEKOTUS"));
    }

    @Test
    public void testLuoOtos() {
        Sanasto s = new Sanasto();
        s.lisaaSana(new Sana("hohotus"));
        s.lisaaSana(new Sana("hihitys"));
        s.lisaaSana(new Sana("hekotus"));
        s.lisaaSana(new Sana("yksi"));
        s.lisaaSana(new Sana("kaksi"));
        s.lisaaSana(new Sana("kolme"));
        assertEquals(true, s.luoOtos(3));
    }

}
