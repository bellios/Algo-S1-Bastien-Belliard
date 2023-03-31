import java.util.ArrayList;
import java.util.Scanner;

public class Wizard extends Character{
    private Pet pet;
    private Wand wand;
    private House house;
    private ArrayList<Spell> knowspell;
    private Potion[] potion;
    private Item[] item;
    private int year;

    public Wizard(String name, int attack, int defense, int health, int precision, Pet pet) {
        super(name, attack, defense, health, precision);
        Wand wand=new Wand();
        System.out.println(wand.toString());
        Potion pot=new Potion("empty","",0,new Effect(Type.NONE,0F,0));
        Item item=new Item("empty", "empty");
        House house=initHouse();
        System.out.println(house.toString());
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knowspell = new ArrayList<Spell>();
        this.potion = new Potion[]{pot,pot,pot,pot,pot,pot,pot,pot,pot,pot};
        this.item = new Item[]{item,item,item,item,item,item,item,item,item,item};
        this.year = 1;
    }
    public void changeHP(int i){
        this.hp+=i;
    }
    public int getYear() {
        return year;
    }
    public int getHp() {
        return hp;
    }
    public House getHouse() {
        return house;
    }

    public void impYear() {
        this.year +=1;
    }
    @Override
    public int getDefense() {
        return (int) (defense*house.getMultDef());
    }
    //=================================================================================================================
    //  Initialization
    //=================================================================================================================

    public House initHouse(){
        switch ((int)(Math.random()*4)){
            case 1:
                return new House("Hufflepuff", 1.20F,1,1,1);
            case 2:
                return new House("Slytherin", 1,1.20F,1,1);
            case 3:
                return new House("Gryffindor", 1,1,1.20F,1);
            case 4:
                return new House("Ravenclaw", 1,1,1,1.20F);
        }
        return new House("Gryffindor", 1,1,1.20F,1);
    }
    //=================================================================================================================
    //  Print inventories
    //=================================================================================================================
    public void printInventoryPotion(){
        System.out.println("This is the potions you currently have in your inventory : ");
        for(int iz=0;iz<=this.potion.length-1;iz++) {
            System.out.println(iz+" : "+potion[iz].toString());
        }
    }
    public void printInventoryItem(){
        System.out.println("This is the items you currently have in your inventory : ");
        for(int iz=0;iz<=this.item.length-1;iz++) {
            System.out.println(iz+" : "+item[iz].toString());
        }
    }
    public void printKnowSpells(){
        for(int i=0;i<=knowspell.size()-1;i++){
            System.out.println(i+" : "+knowspell.get(i).toString());
        }
    }
    //=================================================================================================================
    //  Add item in inventories
    //=================================================================================================================
    public boolean craftPotion(ArrayList<Potion> potions) {
        for (int iz = 0; iz <= this.potion.length - 1; iz++) {
            if (this.potion[iz].getType() == Type.NONE) {
                for(int i=0;i<=potions.size()-1;i++){
                    if(potions.get(i).getYearOfCraft()>this.year) break;
                    System.out.println(i+" : "+potions.get(i).toString());
                }
                int indexPot;
                Scanner scanner = new Scanner(System.in);
                do {
                    System.out.println("Enter the number of the potion, you want to craft");
                    indexPot = scanner.nextInt();
                } while (indexPot <0||indexPot>=potions.size());
                this.potion[iz]=potions.get(indexPot);
                return true;
            }
        }
        System.out.println("Inventory full");
        return false;
    }
    public void addSpell(Spell spell){
        this.knowspell.add(spell);
    }
    //=================================================================================================================
    //  Choose a item
    //=================================================================================================================
    public Spell chooseSpell(){
        printKnowSpells();
        int index;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the number of the spell, you want to use");
            index = scanner.nextInt();
        } while (index <0||index>=this.knowspell.size()-1);
        return this.knowspell.get(index);
    }
    public Potion choosePotion(){
        printInventoryPotion();
        int index;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the number of the potion, you want to use");
            index = scanner.nextInt();
        } while (index <0||index>=this.potion.length-1||this.potion[index].getType()==Type.NONE);
        Potion choice =this.potion[index];
        this.potion[index]=new Potion("empty","",0,new Effect(Type.NONE,0F,0));
        return choice;
    }
    public Item chooseItem(){
        printInventoryItem();
        int index;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the number of the item, you want to use");
            index = scanner.nextInt();
        } while (index <0||index>=this.item.length-1||this.item[index].getName()=="empty");
        Item choice =this.item[index];
        this.item[index]=new Item("empty","empty");
        return choice;
    }
    public void chooseAddStat(int point){
        Scanner scanner = new Scanner(System.in);
        int index1,index2;
        do {
            System.out.println("You can add "+point+" point to your current stat");
            System.out.println("1 : HP, current maxHP (1pt = 5HP) :"+this.maxHP+"\n2 : Strength, current STR (1pt = 2 STR) :"+this.attack);
            System.out.println("3 : Defense, current DEF (1pt = 5DEF) :"+this.defense+"\n4 : Precision, current PRES (1pt = 2 PRES) :"+this.precision);
            do {
                System.out.println("Enter the number of the stat you want to upgrade");
                index1 = scanner.nextInt();
            } while (index1<1||index1>4);
            do {
                System.out.println("How many point do you want to invest ?");
                index2 = scanner.nextInt();
            } while (index2<=0||index2>point);
            switch (index1){
                case 1:
                    this.maxHP+=index2*5;
                    point-=index2;
                    break;
                case 2:
                    this.attack+=index2*2;
                    point-=index2;
                    break;
                case 3:
                    this.defense+=index2*5;
                    point-=index2;
                    break;
                case 4:
                    this.precision+=index2*2;
                    point-=index2;
                    break;
            }
        } while (point>0);
    }
    //=================================================================================================================
    //  Utilities
    //=================================================================================================================
    public void specialSpell(Character targetMob,Spell choosenSpell){
        switch (choosenSpell.getName()){
            case "Windgardium leviosa":
                attack(targetMob,(int)(Math.random()*40+5));
                break;
            case "Accio":
                // A voir avec les items
                break;
            case "Imperio":
                // A voir quand les boss utiliserons des sort
                break;
        }
    }
    @Override
    public void attack(Character character, int power) { //Add effect def of mob, boost of player
        int hpLost=(int)((power+this.attack*asEffect(Type.BOOSTSTR))*this.house.getMultDeg()-(character.getDefense()+character.asEffect(Type.DEFENSE)));
        System.out.println(character.getName()+" has lost "+hpLost+" HP");
        character.setHp(character.getHp()-hpLost);
    }

    public void heal (int i){
        if(this.hp+i<=maxHP)
            this.hp+=i;
        else
            this.hp=this.maxHP;
    }

}
