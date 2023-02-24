public class Wizard extends Character{
    private Pet pet;
    private Wand wand;
    private House house;
    private Spell[] knowspell;
    private Potion[] potion;

    public Wizard(String name, Pet pet, Wand wand, House house, Spell[] knowspell, Potion[] potion) {
        super(name);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knowspell = knowspell;
        this.potion = potion;
    }
}
