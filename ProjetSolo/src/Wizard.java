import java.util.ArrayList;

public class Wizard extends Character{
    private Pet pet;
    private Wand wand;
    private House house;
    private ArrayList<Spell> knowspell;
    private Potion[] potion;
    private int year;

    public Wizard(String name, Pet pet, Wand wand, House house, ArrayList<Spell> knowspell, Potion[] potion, int year) {
        super(name);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knowspell = knowspell;
        this.potion = potion;
        this.year = year;
    }
}
