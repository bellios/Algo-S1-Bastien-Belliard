package game;

import chara.Character;
import chara.Effect;
import chara.Potion;
import chara.Type;
import chara.enemies.Boss;
import chara.enemies.Enemy;
import chara.enemies.EnemyLevel;
import chara.spell.ForbiddenSpell;
import chara.spell.Spell;
import chara.wizard.Item;
import chara.wizard.Wizard;

import java.util.*;



public class Game {
    private Wizard player;
    private ArrayList<Potion> potions=new ArrayList<>();
    private ArrayList<Spell> spells=new ArrayList<>();
    private ArrayList<Spell> learningSpells=new ArrayList<>();
    private ArrayList<ForbiddenSpell> forbiddenSpells=new ArrayList<>();
    private ArrayList<Item> items=new ArrayList<>();
    private ArrayList<Boss> bosses=new ArrayList<>();
    private ArrayList<Enemy> enemies=new ArrayList<>();
    private ArrayList<EnemyLevel> levels=new ArrayList<>();
    //=================================================================================================================
    //  Initialisation functions
    //=================================================================================================================
    public void initPlayer () {
        System.out.println("What's your name ?");
        Scanner scanner = new Scanner(System.in);
        String name= scanner.nextLine();
        this.player= new Wizard(name);
    }
    public void initPotion(){
        this.potions.add(new Potion("Cure for Boils","Regenerate a little of your health",1,new Effect(Type.REGENERATE,1.25F,0)));
        this.potions.add(new Potion("Draught of Living Death","Your enemy have a chance to fall asleep",1,new Effect(Type.SLEEP,1F,2)));
        this.potions.add(new Potion("Confusing Concoction","Confuse your enemy for a short period", 3,new Effect(Type.RESTRAIN,5F,3)));
        this.potions.add(new Potion("Undetectable Poisons","Poison your enemy",3,new Effect(Type.POISON,10F,3)));
        this.potions.add(new Potion("Antidote","Cure all effect", 4,new Effect(Type.CURE,1F,0)));
        this.potions.add(new Potion("Strengthening Solution","Strengthen your attack",5,new Effect( Type.BOOSTSTR,1.25F,3)));
        this.potions.add(new Potion("Invigoration Draught","Restore your health", 5,new Effect(Type.REGENERATE,1.5F,0)));
        this.potions.add(new Potion("Felix Felicis","Increase temporarelly your precision", 5,new Effect(Type.BOOSTPRES,1.25F,3)));
    }
    public void initSpell(){
        this.spells.add(new Spell("Windgardium leviosa","Levitate objects.", Type.SPECIAL,1,1));
        this.spells.add(new Spell("Petrificus Totalus","Restrain the movement of your opponent.",Type.RESTRAIN,3,1));
        this.spells.add(new Spell("Expelliarmus","Disarm your enemy.",Type.ATTACK,30,2));
        this.spells.add(new Spell("Accio","Attract object.",Type.SPECIAL,1,2));
        this.spells.add(new Spell("Expecto Patronum","Summon your patronum.",Type.DEFENSE,10,3));
        this.spells.add(new Spell("Repulso","Expel object.",Type.ATTACK,50,4));
        this.spells.add(new Spell("Protego","Attract object.",Type.DEFENSE,25,4));
        this.spells.add(new Spell("Stupefy","Stun your enemy.",Type.RESTRAIN,5,5));
        this.spells.add(new Spell("Sectumsempra","Lacerate your enemy.",Type.BLEEDING,6,6));
    }
    public void initForbiddenSpell(){
        this.forbiddenSpells.add(new ForbiddenSpell("Imperio","Take over mind.",Type.SPECIAL,1));
        this.forbiddenSpells.add(new ForbiddenSpell("Curcio","Torture.",Type.RESTRAIN, 100));
        this.forbiddenSpells.add(new ForbiddenSpell("Avada Kevadra","Kill.",Type.ATTACK,1000));
    }
    public void initLearningSpell(){
        this.learningSpells.add(new Spell("Aquamenti","Produce a jet of water",Type.ATTACK,20,1));
        this.learningSpells.add(new Spell("Bombarda","Produce a small explosion",Type.ATTACK,35,2));
        this.learningSpells.add(new Spell("Incendio","Produce fire",Type.FIRE,4,3));
        this.learningSpells.add(new Spell("Confringo","Produce a medium explosion",Type.ATTACK,50,3));
        this.learningSpells.add(new Spell("Bombarda Maxima","Produce a big explosion",Type.ATTACK,65,4));
        this.learningSpells.add(new Spell("Petrificus Totalus","Petrify your enemy",Type.RESTRAIN,7,6));
        this.learningSpells.add(new Spell("Glacius","Freeze your enemy",Type.FREEZE,20,6));
    }
    public void initItem(){
        this.items.add(new Item("Legendary sword","Legendary sword of Godric Gryffindor"));
        this.items.add(new Item("Basilic teeth","Teeth of the basilic"));
        this.items.add(new Item("Fire work","Do i need to explain that ?"));
    }
    public void initBoss(){
        this.bosses.add(new Boss("Basilic",60,40,10,50));
        this.bosses.add(new Boss("Voldemort",60,40,10,80));
        this.bosses.add(new Boss("Peter Pettigrow",60,30,10,50));
        this.bosses.add(new Boss("Dolores Ombrage",50,20,10,70));
        this.bosses.add(new Boss("Bellatrix Lestrange",40,20,10,80));
    }
    public void initEnemy(){
        this.enemies.add(new Enemy("Troll",40,10,10,60));
        this.enemies.add(new Enemy("Dementor",50,10,10,70));
        this.enemies.add(new Enemy("Death Eaters",50,15,10,70));
    }
    public void initLevel(){
        this.levels.add(new EnemyLevel(new ArrayList<>(Arrays.asList(new Enemy(this.enemies.get(0))))));
        this.levels.add(new EnemyLevel(new ArrayList<>(Arrays.asList(new Boss(this.bosses.get(0))))));
        this.levels.add(new EnemyLevel(new ArrayList<>(Arrays.asList(new Enemy(this.enemies.get(1)),new Enemy(this.enemies.get(1)),new Enemy(this.enemies.get(1))))));
        this.levels.add(new EnemyLevel(new ArrayList<>(Arrays.asList(new Boss(this.bosses.get(1)),new Boss(this.bosses.get(2))))));
        this.levels.add(new EnemyLevel(new ArrayList<>(Arrays.asList(new Boss(this.bosses.get(3))))));
        this.levels.add(new EnemyLevel(new ArrayList<>(Arrays.asList(new Enemy(this.enemies.get(2)),new Enemy(this.enemies.get(2)),new Enemy(this.enemies.get(2))))));
        this.levels.add(new EnemyLevel(new ArrayList<>(Arrays.asList(new Boss(this.bosses.get(1)),new Boss(this.bosses.get(4))))));
    }
    //=================================================================================================================
    //  Battle method
    //=================================================================================================================

    public boolean battle(){
        EnemyLevel mylevel=new EnemyLevel(this.levels.get(this.player.getYear()-2));
        do{
            Scanner scanner = new Scanner(System.in);
            int index;
            boolean test=false;
            do {
                do {
                    System.out.println("Choose your moove:\n1 : Spell\n2 : Potion\n3 : Item");
                    index = scanner.nextInt();
                } while (index <1||index>3);

                switch (index) {
                    case 1:
                        test=spellUse(this.player.chooseSpell(), mylevel.chooseMob());
                        break;
                    case 2:
                        test=potionUse(this.player.choosePotion(), mylevel.chooseMob());
                        break;
                    case 3:
                        test=itemUse(this.player.chooseItem(), mylevel.chooseMob());
                        break;
                }
            }while(!test);
            //Verification of special condition
            if(!mylevel.areDead()){
                mylevel.mobTurn(this.player);
            }
            mylevel.decreaseTimeEffectsMob();
            player.decreaseTimeEffects();
            System.out.println("You have : "+this.player.getHp()+"/"+this.player.getMaxHP()+" HP");
        }while(this.player.getHp()>0&&!mylevel.areDead());
        if (mylevel.areDead()) {
            System.out.println("You have defeated all of the enemies");
            player.clearEffect();
            player.chooseAddStat(5);
            return true;
        }
        return false;
    }
    public void chooseAction(){

    }
    public boolean spellUse(Spell choosenSpell, Character targetMob){
        if (choosenSpell.getName()=="exit")
            return false;
        if(Math.random()*100>=this.player.getPrecision()*this.player.getHouse().getMultPres()*this.player.asEffect(Type.BOOSTPRES))
            System.out.println("AH AH, you miss your spell");
        else {
            switch (choosenSpell.getType()) {
                case ATTACK:
                    player.attack(targetMob, choosenSpell.getPower());
                    return true;
                case DEFENSE:
                    player.addEffect(new Effect(choosenSpell.getType(), (float) choosenSpell.getPower(), 1));
                    return true;
                case RESTRAIN:
                    targetMob.addEffect(new Effect(choosenSpell.getType(), 0F , choosenSpell.getPower()));
                    return true;
                case BLEEDING:case FREEZE:case FIRE:
                    targetMob.addEffect(new Effect(choosenSpell.getType(), (float) choosenSpell.getPower() , choosenSpell.getPower()));
                    return true;
                case SPECIAL:
                    player.specialSpell(targetMob, choosenSpell);
                    return true;
            }
        }
        return false;
    }
    public boolean potionUse(Potion choosenPotion,Character targetMob){
        if(Math.random()*100>=this.player.getPrecision()*this.player.getHouse().getMultPres()*this.player.asEffect(Type.BOOSTPRES)+10)
            System.out.println("AH AH, you miss your potion");
        else {
            switch (choosenPotion.getType()) {
                case BOOSTSTR:case BOOSTPRES:case POISON:case RESTRAIN:case SLEEP:
                    targetMob.addEffect(new Effect(choosenPotion.getEffect()));
                    return true;
                case REGENERATE:
                    this.player.heal((int)(this.player.getMaxHP()*choosenPotion.getEffect().getPower()*this.player.getHouse().getMultPot())-this.player.getMaxHP());
                    return true;
                case CURE:
                    this.player.clearEffect();
                    return true;
            }
        }
        return false;
    }
    public boolean itemUse(Item item, Character character){
        return false;
    }
    //=================================================================================================================
    //  Course of the years
    //=================================================================================================================
    public void addSpellPerYear(){
        for(int i=0;i<=spells.size()-1;i++){
            if(spells.get(i).getYearOfStudy()==player.getYear())
                player.addSpell(spells.get(i));
        }
    }
    public int getNumSpellPerYear(){
        int i=0;
        for(int y=0;y<this.spells.size();y++)
            if(this.spells.get(y).getYearOfStudy()==this.player.getYear())
                i++;
        return i;
    }
    public void menuOfActions(int action){
        do {
            System.out.println("\nActions : \n1 : Print know spell \n2 : Print potion inventory \n3 : Print item inventory");
            System.out.println("4 : Go to sleep in dormitory (1pt)\n5 : Craft potion (1pt)\n6 : learn new spell (1pt)");
            System.out.println("7 : Shop (1pt) WIP\n8 : Go gather ingredient (1pt) WIP");
            int index;
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Enter the number of the action you want to make");
                index = scanner.nextInt();
            } while (index <1||index>8);
            switch (index){
                case 1:
                    this.player.printKnowSpells();
                    break;
                case 2:
                    this.player.printInventoryPotion();
                    break;
                case 3:
                    this.player.printInventoryItem();
                    break;
                case 4:
                    System.out.println("You go to sleep to regenerate your HP");
                    this.player.heal(this.player.getMaxHP());
                    action--;
                    break;
                case 5:
                    if(this.player.craftPotion(potions))
                        action--;
                    break;
                case 6:
                    if(this.player.learnSpell(learningSpells))
                        action --;
                    break;
                case 7:
                case 8:
                    //this.player.shop(items);
                    //this.player.gatherIngredient(ingredients);
                    System.out.println("WIP, currently not available");
                    break;
            }
        }while (action>0);
    }
    public boolean year(int spell, int action){
        System.out.println("This year during your obligatory course you have learned "+spell+" spell");
        addSpellPerYear();
        player.printKnowSpells();
        System.out.println("\n In this year your will have "+action+" point");
        menuOfActions(action);
        this.player.impYear();
        return battle();
    }
    //=================================================================================================================
    //  game.Main
    //=================================================================================================================
    public void startGame(){
        // Initialization
        System.out.println("Welcome young wizard to the beautiful word of harih potah in to the meme world");
        initPlayer();
        initPotion();
        initSpell();
        initForbiddenSpell();
        initLearningSpell();
        initItem();
        initBoss();
        initEnemy();
        initLevel();
        //Start of each year
        System.out.println("Each year you will be able to make a certain number of action.\n this action will permit you to craft potion learn special spell or regenerate yourself");
        for(int i=0;i<7;i++){
            System.out.println(i+1+" year");
            if(!year(getNumSpellPerYear(),2+i)){
                System.out.println("game over");
            }
        }

    }
}
