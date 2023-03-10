public class House {
    private String name;
    private float multDeg;
    private float multRes;
    private float multPres;
    private float multPot;

    public House(String name, float multPot, float multDeg, float multRes, float multPres) {
        this.name = name;
        this.multDeg = multDeg;
        this.multRes = multRes;
        this.multPres = multPres;
        this.multPot = multPot;
    }

    @Override
    public String toString() {
        return "Your house is "+name;
    }
}
