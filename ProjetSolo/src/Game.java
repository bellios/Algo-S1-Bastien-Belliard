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
        potions.add(new Potion("Cure for Boils","Regenerate a little of your health",Type.REGENERATE,1.25F,1));
        potions.add(new Potion("Draught of Living Death","Your enemy have a little chance to fall asleep",Type.SLEEP,1.1F,1));
        potions.add(new Potion("Confusing Concoction","Confuse your enemy for a short period", Type.RESTRAIN,2,3));
        potions.add(new Potion("Undetectable Poisons","Poison your enemy", Type.POISON,3,3));
        potions.add(new Potion("Wit-Sharpening Potion","Cure your confusion effect", Type.CURE,1,4));
        potions.add(new Potion("Antidote","Cure poison effect", Type.CURE,1,4));
        potions.add(new Potion("Strengthening Solution","Strengthen your attack", Type.BOOST,1.25F,5));
        potions.add(new Potion("Invigoration Draught","Restore your health", Type.REGENERATE,1.5F,5));
        return potions;
    }
    public ArrayList<Spell> initSpell(){
        ArrayList<Spell> spells=new ArrayList<Spell>();
        spells.add(new Spell("Windgardium leviosa","Levitate objects.",Type.SPECIAL,1,1));
        spells.add(new Spell("Petrificus Totalus","Restrain the movement of your opponent.",Type.RESTRAIN,10,1));
        spells.add(new Spell("Expelliarmus","Disarm your enemy.",Type.ATTACK,10,2));
        spells.add(new Spell("Accio","Attract object.",Type.SPECIAL,1,2));
        spells.add(new Spell("Expecto Patronum","Summon your patronum.",Type.DEFENSE,10,3));
        spells.add(new Spell("Repulso","Expel object.",Type.ATTACK,20,4));
        spells.add(new Spell("Protego","Attract object.",Type.DEFENSE,25,4));
        spells.add(new Spell("Stupefy","Stun your enemy.",Type.RESTRAIN,50,5));
        spells.add(new Spell("Sectumsempra","Lacerate your enemy.",Type.BLEEDING,5,6));
        return spells;
    }
    public ArrayList<ForbiddenSpell> initForbiddenSpell(){
        ArrayList<ForbiddenSpell> forbiddenSpells=new ArrayList<ForbiddenSpell>();
        forbiddenSpells.add(new ForbiddenSpell("Imperio","Take over mind.",Type.SPECIAL,1));
        forbiddenSpells.add(new ForbiddenSpell("Curcio","Torture.",Type.RESTRAIN, 100));
        forbiddenSpells.add(new ForbiddenSpell("Avada Kevadra","Kill.",Type.ATTACK,1000));
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
    public void addSpellPerYear(){
        for(int i=0;i<=spells.size()-1;i++){
            if(spells.get(i).getYearOfStudy()==player.getYear())
                player.addSpell(spells.get(i));
        }
    }
    //=================================================================================================================
    //  Course of the years
    //=================================================================================================================
    public void firstYear(){
        System.out.println("Your are in your first year, thanks to your wonderful teacher you have learn two new spell");
        addSpellPerYear();
        player.printKnowSpells();
        System.out.println("\n In this year your will have the possibility to craft 4 potions");
        for(int i=0;i<4;i++){
            player.craftPotion(potions);
        }
        player.printInventoryPotion();
        //kombat
        //increase year
    }
    public void secondYear(){
        System.out.println("Wow you have made to the second year, like last year you have learn new spells");
        addSpellPerYear();
        player.printKnowSpells();
        System.out.println("\n In this year your will have the possibility to craft 5 potions, but no new potions");
        for(int i=0;i<5;i++){
            player.craftPotion(potions);
        }
        player.printInventoryPotion();
        //kombat
        //increase year
    }
    public void thirdYear(){
        System.out.println("This year you have learned only one new spell");
        addSpellPerYear();
        player.printKnowSpells();
        System.out.println("\n In this year your will have the possibility to craft 3 potions");
        for(int i=0;i<3;i++){
            player.craftPotion(potions);
        }
        player.printInventoryPotion();
        //kombat
        //increase year
    }
    public void startGame(){
        System.out.println("Welcome young wizard to the beautiful word of harih potha in to the meme world");
        this.player =initPlayer();
        this.potions=initPotion();
        this.spells=initSpell();
        this.forbiddenSpells=initForbiddenSpell();
        firstYear();
    }
}
