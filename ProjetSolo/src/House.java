public class House {
    private String name;
    private float multDeg;
    private float multDef;
    private float multPres;
    private float multPot;

    public House(String name, float multPot, float multDeg, float multDef, float multPres) {
        this.name = name;
        this.multDeg = multDeg;
        this.multDef = multDef;
        this.multPres = multPres;
        this.multPot = multPot;
    }

    @Override
    public String toString() {
        return "Your house is "+name;
    }

    public float getMultDeg() {
        return multDeg;
    }

    public float getMultDef() {
        return multDef;
    }

    public float getMultPres() {
        return multPres;
    }

    public float getMultPot() {
        return multPot;
    }
}
