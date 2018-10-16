import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MP3PlayerTest {

    MP3Player mp3;
    Stereo stereo;
    Radio radio;
    CDplayer player;
    AUX aux;

    @Before
    public void before(){
        radio = new Radio("JVC", "1000", Station.RADIO1);
        player = new CDplayer("Sony", "CD400", 2);
        aux = new AUX("Samsung", "Input9000");
        stereo = new Stereo("My Stereo","LG","TEST",radio,player,aux);
        mp3 = new MP3Player("LG", "musicBox", 10);
    }

    @Test
    public void getMake() {
        assertEquals("LG", mp3.getMake());
    }

    @Test
    public void getModel(){
        assertEquals("musicBox", mp3.getModel());
    }

    @Test
    public void getVolume(){
        assertEquals(5, mp3.getVolume());
    }

    @Test
    public void volumeUp(){
        mp3.volumeUp();
        assertEquals(6, mp3.getVolume());
    }

    @Test
    public void volumeDn(){
        mp3.volumeDn();
        assertEquals(4, mp3.getVolume());
    }

    @Test
    public void connect(){
        assertEquals("Connected to: My Stereo", mp3.connect(stereo));
    }

    @Test
    public void getTotalSongs(){
        assertEquals(10,mp3.getTotalSongs());
    }

    @Test
    public void getCurrentTrack(){
        assertEquals(1,mp3.getCurrentTrack());
    }


    @Test
    public void play(){
        assertEquals("Playing Track 1", mp3.play());
    }
    
    @Test
    public void pause(){
        assertEquals("PAUSED", mp3.pause());
    }

    @Test
    public void stop(){
        assertEquals("Track 1", mp3.stop());
    }

    @Test
    public void next(){
        assertEquals("Playing Track 2", mp3.next());
    }

    @Test
    public void nextLast(){
        for (int i = 0; i < 9; i++) {
            mp3.next();
        }
        assertEquals("Playing Track 1", mp3.next());
    }


    @Test
    public void previous() {
        mp3.next();
        assertEquals("Playing Track 1", mp3.previous());
    }
    @Test
    public void previousLast(){
        assertEquals("Playing Track 10", mp3.previous());
    }
}
