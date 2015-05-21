package wordmaster;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TiedostonLukijaTest {

    @Test
    public void testLueTiedosto() throws Exception {
        TiedostonLukija tl = new TiedostonLukija();
        assertEquals(tl.lueTiedosto(), true);

    }

}
