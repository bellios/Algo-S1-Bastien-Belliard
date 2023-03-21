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
        Potion pot=new Potion("empty","",0,0);
        House house=initHouse();
        System.out.println(house.toString());
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knowspell = new ArrayList<Spell>();
        this.potion = new Potion[]{pot,pot,pot,pot,pot,pot,pot,pot,pot,pot};
        this.year = 1;
    }

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
    public void printInventoryPotion(){
        for(int iz=0;iz<=this.potion.length-1;iz++) {
            System.out.println(potion[iz].getName());
        }
    }
    public boolean craftPotion(ArrayList<Potion> potions) {
        for (int iz = 0; iz <= this.potion.length - 1; iz++) {
            if (this.potion[iz].getName() == "empty") {
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
}
