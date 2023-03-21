import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Wizard player;
    private ArrayList<Potion> potions;
    private ArrayList<Spell> spells;
    private ArrayList<ForbiddenSpell> forbiddenSpells;
    //=================================================================================================================
    //  Initialisation functions
    //=================================================================================================================
    public ArrayList<Potion> initPotion(){
        ArrayList<Potion> potions=new ArrayList<Potion>();
        potions.add(new Potion("Cure for Boils","Regenerate a little of your health",1.25F,1));
        potions.add(new Potion("Draught of Living Death","Your enemy have a little chance to fall asleep",1.1F,1));
        potions.add(new Potion("Confusing Concoction","Confuse your enemy for a short period",2,3));
        potions.add(new Potion("Undetectable Poisons","Poison your enemy",3,3));
        potions.add(new Potion("Wit-Sharpening Potion","Cure your confusion effect",1,4));
        potions.add(new Potion("Antidote","Cure poison effect",1,4));
        potions.add(new Potion("Strengthening Solution","Strengthen your attack",1.25F,5));
        potions.add(new Potion("Invigoration Draught","Restore your health",1.5F,5));
        return potions;
    }
    public ArrayList<Spell> initSpell(){
        ArrayList<Spell> spells=new ArrayList<Spell>();
        spells.add(new Spell("Windgardium leviosa","Levitate objects.",SpellType.SPECIAL,1,1));
        spells.add(new Spell("Petrificus Totalus","Restrain the movement of your opponent.",SpellType.RESTRAIN,10,1));
        spells.add(new Spell("Expelliarmus","Disarm your enemy.",SpellType.ATTACK,10,2));
        spells.add(new Spell("Accio","Attract object.",SpellType.SPECIAL,1,2));
        spells.add(new Spell("Expecto Patronum","Summon your patronum.",SpellType.DEFENSE,10,3));
        spells.add(new Spell("Repulso","Expel object.",SpellType.ATTACK,20,4));
        spells.add(new Spell("Protego","Attract object.",SpellType.DEFENSE,25,4));
        spells.add(new Spell("Stupefy","Stun your enemy.",SpellType.RESTRAIN,50,5));
        spells.add(new Spell("Sectumsempra","Lacerate your enemy.",SpellType.ATTACK,35,6));
        return spells;
    }
    public ArrayList<ForbiddenSpell> initForbiddenSpell(){
        ArrayList<ForbiddenSpell> forbiddenSpells=new ArrayList<ForbiddenSpell>();
        forbiddenSpells.add(new ForbiddenSpell("Imperio","Take over mind.",SpellType.SPECIAL,1));
        forbiddenSpells.add(new ForbiddenSpell("Curcio","Torture.",SpellType.RESTRAIN, 100));
        forbiddenSpells.add(new ForbiddenSpell("Avada Kevadra","Kill.",SpellType.ATTACK,1000));
        return forbiddenSpells;
    }

    public Wizard initPlayer () {
        System.out.println("What's your name ?");
        Scanner scanner = new Scanner(System.in);
        String name= scanner.nextLine();
        System.out.println("Choose your pet in the following list : ");
        int i=0;
        for (Pet var : Pet.values()) {
            System.out.println(i+" : "+var);
            i++;
        }
        int indexPet;
        do {
            System.out.println("Enter the number of the pet you want, you can only choose one.");
            indexPet = scanner.nextInt();
        } while (indexPet <0||indexPet>=9);
        System.out.println("You choose a "+Pet.values()[indexPet]);
        Wizard player = new Wizard(name,1,1,10,1,Pet.values()[indexPet]);
        return player;
    }
    //=================================================================================================================
    //  General method
    //=================================================================================================================

    //=================================================================================================================
    //  Course of the years
    //=================================================================================================================
    public static void
    public void startGame(){
        this.player =initPlayer();
        this.potions=initPotion();
        this.spells=initSpell();
        this.forbiddenSpells=initForbiddenSpell();
        player.craftPotion(potions);
        player.printInventoryPotion();
    }
}
