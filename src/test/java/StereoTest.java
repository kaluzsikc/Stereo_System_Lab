import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StereoTest {

    MP3Player mp3;
    Stereo stereo;
    Radio radio;
    CDplayer player;
    AUX aux;
    CD cd1;
    CD cd2;

    @Before
    public void before(){
        radio = new Radio("JVC", "1000", Station.RADIO1);
        player = new CDplayer("Sony", "CD400", 2);
        aux = new AUX("Samsung", "Input9000");
        stereo = new Stereo("My Stereo","LG","TEST",radio,player,aux);
        mp3 = new MP3Player("LG", "musicBox", 10);
        cd1 = new CD("TestCD1", 10);
        cd2 = new CD("TestCD2", 8);
    }

    @Test
    public void hasName() {
        assertEquals("My Stereo", stereo.getName());
    }

    @Test
    public void hasMake() {
        assertEquals("LG", stereo.getMake());
    }

    @Test
    public void hasModel() {
        assertEquals("TEST", stereo.getModel());
    }

    @Test
    public void hasRadio() {
        assertEquals(radio, stereo.getRadio());
    }

    @Test
    public void hasCD() {
        assertEquals(player, stereo.getCdplayer());
    }

    @Test
    public void hasAux() {
        assertEquals(aux, stereo.getAux());
    }

    @Test
    public void getStation(){
        assertEquals(Station.RADIO1, stereo.radioStation());
    }

    @Test
    public void tune(){
        stereo.tuneRadio(Station.RADIO2);
        assertEquals(Station.RADIO2, stereo.radioStation());
    }

    @Test
    public void radiovol(){
        assertEquals(5,stereo.radioVol());
    }

    @Test
    public void radioup(){
        stereo.radioUp();
        assertEquals(6,stereo.radioVol());
    }

    @Test
    public void radiodown(){
        stereo.radioDn();
        assertEquals(4,stereo.radioVol());
    }
    
    @Test
    public void cdIn(){
        stereo.insertCD(cd1);
        assertEquals(1, player.getCds().size());
        assertEquals(cd1, player.getCurrentCD());
    }

    @Test
    public void eject(){
        stereo.insertCD(cd1);
        assertEquals(1, player.getCds().size());
        stereo.ejectCD(cd1);
        assertEquals(0, player.getCds().size());
    }

    @Test
    public void changeCD(){
        stereo.insertCD(cd1);
        stereo.insertCD(cd2);
        assertEquals(2, player.getCds().size());
        assertEquals(cd2, player.getCurrentCD());
        stereo.changeCD(cd1);
        assertEquals(cd1, player.getCurrentCD());
    }

    @Test
    public void play(){
        stereo.insertCD(cd1);
        assertEquals("Playing TestCD1: Track 1", stereo.cdplay());
    }

    @Test
    public void noCDplay(){
        assertEquals("NO CD", stereo.cdplay());
    }


    @Test
    public void pause(){
       stereo.insertCD(cd1);
        assertEquals("PAUSED", stereo.cdpause());
    }

    @Test
    public void noCDpause(){
        assertEquals("NO CD", stereo.cdpause());
    }


    @Test
    public void stop(){
       stereo.insertCD(cd1);
        assertEquals("TestCD1: Track 1", stereo.cdstop());
    }

    @Test
    public void noCDstop(){
        assertEquals("NO CD", stereo.cdstop());
    }


    @Test
    public void next(){
       stereo.insertCD(cd1);
        assertEquals("Playing TestCD1: Track 2", stereo.cdnext());
    }

    @Test
    public void nextLast(){
       stereo.insertCD(cd1);
        for (int i = 0; i < 9; i++) {
            stereo.cdnext();
        }
        assertEquals("Playing TestCD1: Track 1", stereo.cdnext());
    }

    @Test
    public void noCDnext(){
        assertEquals("NO CD", stereo.cdnext());
    }


    @Test
    public void previous() {
       stereo.insertCD(cd1);
        stereo.cdnext();
        assertEquals("Playing TestCD1: Track 1", stereo.cdprevious());
    }
    @Test
    public void previousLast(){
       stereo.insertCD(cd1);
        assertEquals("Playing TestCD1: Track 10", stereo.cdprevious());
    }

    @Test
    public void noCDprevious(){
        assertEquals("NO CD", stereo.cdplay());
    }

}
