public abstract class AbstractSpell {
    protected String name;
    protected String description;
    protected SpellType type;
    protected int power;

    public AbstractSpell(String name,String description, SpellType type, int power) {
        this.name = name;
        this.description=description;
        this.type = type;
        this.power = power;
    }
}
