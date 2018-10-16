import java.util.ArrayList;

public class CDplayer extends Component implements IButtons {

    private int numOfCDs;
    private CD currentCD;
    private int currentTrack;
    private ArrayList<CD> cds;

    public CDplayer(String make, String model, int numOfCDs){
        super(make, model);
        this.numOfCDs = numOfCDs;
        this.cds = new ArrayList<>();
        this.currentCD = null;
        this.currentTrack = 1;
    }

    public int getNumOfCDs() {
        return numOfCDs;
    }

    public ArrayList<CD> getCds() {
        return cds;
    }

    public void cdIn(CD cd){
        if (cds.size() < numOfCDs){
            cds.add(cd);
            currentCD = cd;
            currentTrack = 1;
        }
    }

    public void eject(CD cd){
        if (currentCD == cd) {
            currentCD = null;
            currentTrack = 1;
        }
        if (cds.contains(cd)) {
            cds.remove(cd);
            if (cds.size() != 0) {
                currentCD = cds.get(0);
            }
        }
    }

    public CD getCurrentCD() {
        return currentCD;
    }

    public void changeCD(CD cd) {
        if (cds.contains(cd)) {
            currentCD = cd;
        }
    }

    public String play(){
        if (currentCD == null){
            return "NO CD";
        }
        return "Playing " + currentCD.getName() + ": Track " + currentTrack;
    }

    public String pause() {
        if (currentCD == null){
            return "NO CD";
        }
        return "PAUSED";
    }

    public String stop() {
        if (currentCD == null){
            return "NO CD";
        }
        return currentCD.getName() + ": Track " + currentTrack;
    }

    public String next() {
        if (currentCD == null){
            return "NO CD";
        }
        if (currentTrack == currentCD.getTracks()){
            currentTrack = 0;
        }
        currentTrack += 1;
        return "Playing " + currentCD.getName() + ": Track " + currentTrack;
    }

    public String previous() {
        if (currentCD == null){
            return "NO CD";
        }
        if (currentTrack == 1){
            currentTrack = currentCD.getTracks()+1;
        }
        currentTrack -= 1;
        return "Playing " + currentCD.getName() + ": Track " + currentTrack;
    }
}
