public class Stereo {
    private String name;
    private String make;
    private String model;
    private Radio radio;
    private CDplayer cdplayer;
    private AUX aux;

    public Stereo(String name, String make, String model, Radio radio, CDplayer cdplayer, AUX aux){
        this.name = name;
        this.make = make;
        this.model = model;
        this.radio = radio;
        this.cdplayer = cdplayer;
        this.aux = aux;
    }

    public String getName() {
        return name;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Radio getRadio() {
        return radio;
    }

    public CDplayer getCdplayer() {
        return cdplayer;
    }

    public AUX getAux() {
        return aux;
    }

    public void tuneRadio(Station newStation){
        radio.tune(newStation);
    }

    public Station radioStation(){
        return radio.getStation();
    }

    public int radioVol(){
        return radio.getVolume();
    }

    public void radioUp(){
        radio.volumeUp();
    }

    public void radioDn(){
        radio.volumeDn();
    }

    public int auxVol(){
        return aux.getVolume();
    }

    public void auxUp(){
        aux.volumeUp();
    }

    public void auxDn(){
        aux.volumeDn();
    }

    public int cdVol(){
        return cdplayer.getVolume();
    }

    public void cdUp(){
        cdplayer.volumeUp();
    }

    public void cdDn(){
        cdplayer.volumeDn();
    }

    public void insertCD(CD cd){
        cdplayer.cdIn(cd);
    }

    public void ejectCD(CD cd){
        cdplayer.eject(cd);
    }

    public void changeCD(CD cd){
        cdplayer.changeCD(cd);
    }

    public String cdplay(){
        return cdplayer.play();
    }

    public String cdpause(){
        return cdplayer.pause();
    }

    public String cdstop(){
        return cdplayer.stop();
    }

    public String cdnext(){
        return cdplayer.next();
    }

    public String cdprevious(){
        return cdplayer.previous();
    }



}
