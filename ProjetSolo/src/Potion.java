public class Potion {
    String name;
    String description;
    float power;
    int yearOfCraft;

    public Potion(String name, String description, float power, int yearOfCraft) {
        this.name = name;
        this.description = description;
        this.power=power;
        this.yearOfCraft=yearOfCraft;
    }

    public int getYearOfCraft() {
        return yearOfCraft;
    }
    public String toString() {
        return name+" : "+description+". Craftable in the "+yearOfCraft+" year";
    }
    public String getName() {
        return name;
    }
}
