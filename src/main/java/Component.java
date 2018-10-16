public abstract class Component {

    private String make;

    private String model;
    private int volume;
    public Component(String make, String model) {
        this.make = make;
        this.model = model;
        this.volume = 5;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getVolume() {
        return volume;
    }

    public void volumeUp() {
        volume += 1;
    }

    public void volumeDn() {
        volume -= 1;
    }

}
