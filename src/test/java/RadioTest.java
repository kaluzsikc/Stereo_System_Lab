import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RadioTest {

    Radio radio;

    @Before
    public void before(){
        radio = new Radio("JVC", "1000", Station.RADIO1);
    }

    @Test
    public void getMake() {
        assertEquals("JVC", radio.getMake());
    }

    @Test
    public void getModel(){
        assertEquals("1000", radio.getModel());
    }

    @Test
    public void getVolume(){
        assertEquals(5, radio.getVolume());
    }

    @Test
    public void volumeUp(){
        radio.volumeUp();
        assertEquals(6, radio.getVolume());
    }

    @Test
    public void volumeDn(){
        radio.volumeDn();
        assertEquals(4, radio.getVolume());
    }

    @Test
    public void getStation(){
        assertEquals(Station.RADIO1, radio.getStation());
    }

    @Test
    public void tune(){
        radio.tune(Station.RADIO2);
        assertEquals(Station.RADIO2, radio.getStation());
    }
}
