package wordmaster;

import org.junit.BeforeClass;

public class SanastoTest {

    private Sanasto s;
    private Sana sana;

    @BeforeClass
    public static void setUpClass() throws Exception {
        Sanasto s = new Sanasto();
        Sana sana = new Sana("hohotus");
    }

//    @Test
//    public void testLisaaSana() {
//        assertEquals(s.lisaaSana(sana), true);
//    }
}
