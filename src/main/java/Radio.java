public class Radio extends Component {

    private Station station;

    public Radio(String make, String model, Station station){
        super(make, model);
        this.station = station;
    }

    public Station getStation(){
        return station;
    }

    public void tune(Station newStation){
        this.station = newStation;
    }
}
