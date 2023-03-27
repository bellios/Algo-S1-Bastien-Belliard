import java.util.ArrayList;
import java.util.Scanner;

public class Wizard extends Character{
    private Pet pet;
    private Wand wand;
    private House house;
    private ArrayList<Spell> knowspell;
    private Potion[] potion;
    private int year;

    public Wizard(String name, int attack, int defense, int health, int precision, Pet pet) {
        super(name, attack, defense, health, precision);
        Wand wand=new Wand();
        System.out.println(wand.toString());
        Potion pot=new Potion("empty","",0,new Effect(Type.NONE,0F,0));
        House house=initHouse();
        System.out.println(house.toString());
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knowspell = new ArrayList<Spell>();
        this.potion = new Potion[]{pot,pot,pot,pot,pot,pot,pot,pot,pot,pot};
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
    //=================================================================================================================
    //  Initialization
    //=================================================================================================================

    public static House initHouse(){
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
            System.out.println(iz+" : "+potion[iz].getName());
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
                } while (indexPot <0||indexPot>=8);
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
        int index;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the number of the spell, you want to use");
            index = scanner.nextInt();
        } while (index <0||index>=this.knowspell.size()-1);
        return this.knowspell.get(index);
    }
    public Potion choosePotion(){
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

    @Override
    public void attack(Character character, int power) {
        int hpLost=(int)((power+this.attack)*this.house.getMultDeg()-character.getDefense());
        System.out.println(character.getName()+" has lost "+hpLost+" HP");
        character.setHp(character.getHp()-hpLost);
    }

    public House getHouse() {
        return house;
    }
    public void heal (int i){
        this.hp+=i;
    }

}
