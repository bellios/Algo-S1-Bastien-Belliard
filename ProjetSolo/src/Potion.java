public class Potion {
    String name;
    String description;
    int yearOfCraft;
    Effect effect;

    public Potion(String name, String description, int yearOfCraft, Effect effect) {
        this.name = name;
        this.description = description;
        this.yearOfCraft = yearOfCraft;
        this.effect = effect;
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

    public Type getType() {
        return this.effect.getType();
    }

    public Effect getEffect() {
        return effect;
    }
}
