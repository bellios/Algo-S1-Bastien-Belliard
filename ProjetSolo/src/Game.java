import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Wizard player;
    private ArrayList<Potion> potions=new ArrayList<>();
    private ArrayList<Spell> spells=new ArrayList<>();
    private ArrayList<ForbiddenSpell> forbiddenSpells=new ArrayList<>();
    private ArrayList<Boss> bosses=new ArrayList<>();
    private ArrayList<Enemy> enemies=new ArrayList<>();
    private ArrayList<EnemyLevel> levels=new ArrayList<>();
    //=================================================================================================================
    //  Initialisation functions
    //=================================================================================================================
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
        Wizard player = new Wizard(name,10,10,100,70,Pet.values()[indexPet]);
        return player;
    }
    public void initPotion(){
        this.potions.add(new Potion("Cure for Boils","Regenerate a little of your health",1,new Effect(Type.REGENERATE,1.25F,1)));
        this.potions.add(new Potion("Draught of Living Death","Your enemy have a little chance to fall asleep",1,new Effect(Type.SLEEP,1F,3)));
        this.potions.add(new Potion("Confusing Concoction","Confuse your enemy for a short period", 3,new Effect(Type.RESTRAIN,1F,2)));
        this.potions.add(new Potion("Undetectable Poisons","Poison your enemy",3,new Effect(Type.POISON,10F,3)));
        this.potions.add(new Potion("Antidote","Cure all effect", 4,new Effect(Type.CURE,1F,1)));
        this.potions.add(new Potion("Strengthening Solution","Strengthen your attack",5,new Effect( Type.BOOST,1.25F,3)));
        this.potions.add(new Potion("Invigoration Draught","Restore your health", 5,new Effect(Type.REGENERATE,1.5F,1)));
    }
    public void initSpell(){
        this.spells.add(new Spell("Windgardium leviosa","Levitate objects.",Type.SPECIAL,1,1));
        this.spells.add(new Spell("Petrificus Totalus","Restrain the movement of your opponent.",Type.RESTRAIN,10,1));
        this.spells.add(new Spell("Expelliarmus","Disarm your enemy.",Type.ATTACK,10,2));
        this.spells.add(new Spell("Accio","Attract object.",Type.SPECIAL,1,2));
        this.spells.add(new Spell("Expecto Patronum","Summon your patronum.",Type.DEFENSE,10,3));
        this.spells.add(new Spell("Repulso","Expel object.",Type.ATTACK,20,4));
        this.spells.add(new Spell("Protego","Attract object.",Type.DEFENSE,25,4));
        this.spells.add(new Spell("Stupefy","Stun your enemy.",Type.RESTRAIN,50,5));
        this.spells.add(new Spell("Sectumsempra","Lacerate your enemy.",Type.BLEEDING,5,6));
    }
    public void initForbiddenSpell(){
        this.forbiddenSpells.add(new ForbiddenSpell("Imperio","Take over mind.",Type.SPECIAL,1));
        this.forbiddenSpells.add(new ForbiddenSpell("Curcio","Torture.",Type.RESTRAIN, 100));
        this.forbiddenSpells.add(new ForbiddenSpell("Avada Kevadra","Kill.",Type.ATTACK,1000));
    }
    public void initBoss(){
        this.bosses.add(new Boss("Basilic",50,10,1000,50));
        this.bosses.add(new Boss("Voldemort",50,10,1000,50));
        this.bosses.add(new Boss("Peter Pettigrow",50,10,1000,50));
        this.bosses.add(new Boss("Dolores Ombrage",50,10,1000,50));
        this.bosses.add(new Boss("Bellatrix Lestrange",50,10,1000,50));
    }
    public void initEnemy(){
        this.enemies.add(new Enemy("Troll",50,10,1000,50));
        this.enemies.add(new Enemy("Dementor",50,10,1000,50));
        this.enemies.add(new Enemy("Death Eaters",50,10,1000,50));
    }
    public void initLevel(){
        this.levels.add(new EnemyLevel(new Boss[]{}, new Enemy[]{this.enemies.get(0)}));
        this.levels.add(new EnemyLevel(new Boss[]{this.bosses.get(0)}, new Enemy[]{}));
        this.levels.add(new EnemyLevel(new Boss[]{}, new Enemy[]{this.enemies.get(1),this.enemies.get(1),this.enemies.get(1)}));
        this.levels.add(new EnemyLevel(new Boss[]{this.bosses.get(1),this.bosses.get(2)}, new Enemy[]{}));
        this.levels.add(new EnemyLevel(new Boss[]{this.bosses.get(3)}, new Enemy[]{}));
        this.levels.add(new EnemyLevel(new Boss[]{}, new Enemy[]{this.enemies.get(2),this.enemies.get(2),this.enemies.get(2)}));
        this.levels.add(new EnemyLevel(new Boss[]{this.bosses.get(1),this.bosses.get(4)}, new Enemy[]{}));
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
    public void battle(){
        EnemyLevel mylevel=new EnemyLevel(this.levels.get(this.player.getYear()-1));
        do{
            Scanner scanner = new Scanner(System.in);
            int index;
            do {
                System.out.println("Choose your moove:\n1 : spell\n2 : Potion\n3 : Item");
                index = scanner.nextInt();
            } while (index <1||index>3);
            Character target = mylevel.chooseMob();
            switch(index){
                case 1:
                    spellUse(this.player.chooseSpell(), target);
                    break;
                case 2:
                    potionUse(this.player.choosePotion(), target);
                    break;
                case 3:
                    //this.player.chooseItem();
                    break;
            }

            //partie mobs
            //decrease turn effect
        }while(this.player.getHp()>0||mylevel.areDead());
        //return bool
    }
    public void spellUse(Spell choosenSpell, Character target){
        if(Math.random()*100>=this.player.getPrecision()*this.player.getHouse().getMultPres())
            System.out.println("AH AH, you miss your spell");
        else {
            switch (choosenSpell.getType()) {
                case ATTACK:
                    player.attack(target, choosenSpell.getPower());
                    break;
                case DEFENSE:
                    player.effect.add(new Effect(Type.DEFENSE, 2F, 1));
                    break;
                case RESTRAIN:

                    break;
                case BLEEDING:

                    break;
                case SPECIAL:

                    break;
            }
        }
    }
    public void potionUse(Potion choosenPotion,Character targetMob){
        if(Math.random()*100>=this.player.getPrecision()*this.player.getHouse().getMultPres()+10)
            System.out.println("AH AH, you miss your potion");
        else {
            switch (choosenPotion.getType()) {
                case REGENERATE:
                    this.player.heal((int)(this.player.getMaxHP()*choosenPotion.getEffect().getPower()*this.player.getHouse().getMultPot()));
                    break;
                case BOOST:
                    targetMob.effect.add(new Effect(choosenPotion.getEffect()));
                    break;
                case RESTRAIN:
                    targetMob.effect.add(new Effect(choosenPotion.getEffect()));
                    break;
                case CURE:
                    this.player.effect.clear();
                    break;
                case POISON:
                    targetMob.effect.add(new Effect(choosenPotion.getEffect()));
                    break;
                case SLEEP:
                    targetMob.effect.add(new Effect(choosenPotion.getEffect()));
                    break;
            }
        }
    }
    //=================================================================================================================
    //  Course of the years
    //=================================================================================================================
    public void firstYear(){
        System.out.println("Your are in your first year, thanks to your wonderful teacher you have learn two new spells");
        addSpellPerYear();
        player.printKnowSpells();
        System.out.println("\n In this year your will have the possibility to craft 4 potions");
        for(int i=0;i<4;i++){
            player.craftPotion(potions);
        }
        player.printInventoryPotion();
        System.out.println("In the end of your first year after taking a shit you see a big troll");
        battle();
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
    //=================================================================================================================
    //  Main
    //=================================================================================================================
    public void startGame(){
        // Initialization
        System.out.println("Welcome young wizard to the beautiful word of harih potah in to the meme world");
        this.player =initPlayer();
        initPotion();
        initSpell();
        initForbiddenSpell();
        initBoss();
        initEnemy();
        initLevel();
        //Start of each year
        firstYear();
    }
}
