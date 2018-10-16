public class MP3Player extends Component implements IButtons,IConnect{

    private int totalSongs;
    private int currentTrack;

    public MP3Player(String make, String model, int totalSongs){
        super(make, model);
        this.totalSongs = totalSongs;
        this.currentTrack = 1;
    }

    public int getTotalSongs() {
        return totalSongs;
    }

    public int getCurrentTrack() {
        return currentTrack;
    }

    public String play(){
        return "Playing Track " + currentTrack;
    }

    public String pause() {
        return "PAUSED";
    }

    public String stop() {
       return "Track " + currentTrack;
    }

    public String next() {
        if (currentTrack == totalSongs){
            currentTrack = 0;
        }
        currentTrack += 1;
        return "Playing Track " + currentTrack;
    }

    public String previous() {
        if (currentTrack == 1){
            currentTrack = totalSongs+1;
        }
        currentTrack -= 1;
        return "Playing Track " + currentTrack;
    }

    public String connect(Stereo stereo){
        return "Connected to: " + stereo.getName();
    }
}
