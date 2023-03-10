public abstract class AbstractSpell {
    protected String name;
    protected SpellType type;
    protected int power;

    public AbstractSpell(String name, SpellType type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }
}
