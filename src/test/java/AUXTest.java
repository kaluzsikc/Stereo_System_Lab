import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AUXTest {

    AUX aux;

    @Before
    public void before(){
        aux = new AUX("Samsung", "Input9000");
    }

    @Test
    public void getMake() {
        assertEquals("Samsung", aux.getMake());
    }

    @Test
    public void getModel(){
        assertEquals("Input9000", aux.getModel());
    }

    @Test
    public void getVolume(){
        assertEquals(5, aux.getVolume());
    }

    @Test
    public void volumeUp(){
        aux.volumeUp();
        assertEquals(6, aux.getVolume());
    }

    @Test
    public void volumeDn(){
        aux.volumeDn();
        assertEquals(4, aux.getVolume());
    }
}
