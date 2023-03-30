public abstract class AbstractSpell {
    protected String name;
    protected String description;
    protected Type type;
    protected int power;

    public AbstractSpell(String name,String description, Type type, int power) {
        this.name = name;
        this.description=description;
        this.type = type;
        this.power = power;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }
}
