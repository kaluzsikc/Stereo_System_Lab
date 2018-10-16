import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CDplayerTest {
    
    CD cd1;
    CD cd2;
    CDplayer player;
    
    @Before
    public void before(){
        cd1 = new CD("TestCD1", 10);
        cd2 = new CD("TestCD2", 8);
        player = new CDplayer("Sony", "CD400", 2);
    }

    @Test
    public void getMake() {
        assertEquals("Sony", player.getMake());
    }

    @Test
    public void getModel(){
        assertEquals("CD400", player.getModel());
    }

    @Test
    public void getVolume(){
        assertEquals(5, player.getVolume());
    }

    @Test
    public void volumeUp(){
        player.volumeUp();
        assertEquals(6, player.getVolume());
    }

    @Test
    public void volumeDn(){
        player.volumeDn();
        assertEquals(4, player.getVolume());
    }

    @Test
    public void numberOfCDs(){
        assertEquals(2, player.getNumOfCDs());
    }

    @Test
    public void cdIn(){
        player.cdIn(cd1);
        assertEquals(1, player.getCds().size());
    }

    @Test
    public void eject(){
        player.cdIn(cd1);
        player.cdIn(cd2);
        assertEquals(2, player.getCds().size());
        player.eject(cd1);
        assertEquals(1, player.getCds().size());
    }

    @Test
    public void getCurrentCD(){
        player.cdIn(cd2);
        player.cdIn(cd1);
        assertEquals(2, player.getCds().size());
        assertEquals(cd1, player.getCurrentCD());
    }

    @Test
    public void changeCD(){
        player.cdIn(cd2);
        player.cdIn(cd1);
        assertEquals(2, player.getCds().size());
        assertEquals(cd1, player.getCurrentCD());
        player.changeCD(cd2);
        assertEquals(cd2, player.getCurrentCD());
    }

    @Test
    public void play(){
        player.cdIn(cd1);
        assertEquals("Playing TestCD1: Track 1", player.play());
    }

    @Test
    public void noCDplay(){
        assertEquals("NO CD", player.play());
    }


    @Test
    public void pause(){
        player.cdIn(cd1);
        assertEquals("PAUSED", player.pause());
    }

    @Test
    public void noCDpause(){
        assertEquals("NO CD", player.pause());
    }


    @Test
    public void stop(){
        player.cdIn(cd1);
        assertEquals("TestCD1: Track 1", player.stop());
    }

    @Test
    public void noCDstop(){
        assertEquals("NO CD", player.stop());
    }


    @Test
    public void next(){
        player.cdIn(cd1);
        assertEquals("Playing TestCD1: Track 2", player.next());
    }

    @Test
    public void nextLast(){
        player.cdIn(cd1);
        for (int i = 0; i < 9; i++) {
            player.next();
        }
        assertEquals("Playing TestCD1: Track 1", player.next());
    }

    @Test
    public void noCDnext(){
        assertEquals("NO CD", player.next());
    }


    @Test
    public void previous() {
        player.cdIn(cd1);
        player.next();
        assertEquals("Playing TestCD1: Track 1", player.previous());
    }
    @Test
    public void previousLast(){
        player.cdIn(cd1);
        assertEquals("Playing TestCD1: Track 10", player.previous());
    }

    @Test
    public void noCDprevious(){
        assertEquals("NO CD", player.play());
    }
}
