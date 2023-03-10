import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    //=================================================================================================================
    //  Initialisation function
    //=================================================================================================================
    public static ArrayList<Potion> initPotion(){
        ArrayList<Potion> potions=new ArrayList<Potion>();
        potions.add(new Potion("Cure for Boils","Regenerate a little of your health",1));
        potions.add(new Potion("Draught of Living Death","Your enemy have a little chance to fall asleep",1));
        potions.add(new Potion("Confusing Concoction","Confuse your enemy for a short period",3));
        potions.add(new Potion("Undetectable Poisons","Poison your enemy",3));
        potions.add(new Potion("Wit-Sharpening Potion","Cure your confusion effect",4));
        potions.add(new Potion("Antidote","Cure poison effect",4));
        potions.add(new Potion("Strengthening Solution","Strengthen your attack",5));
        potions.add(new Potion("Invigoration Draught","Restore your health",5));
        return potions;
    }
    public static House initHouse(){
        House hufflepuff=new House("Hufflepuff", 1.20F,1,1,1);
        House slytherin=new House("Slytherin", 1,1.20F,1,1);
        House gryffindor=new House("Gryffindor", 1,1,1.20F,1);
        House ravenclaw=new House("Ravenclaw", 1,1,1,1.20F);
        switch ((int)(Math.random()*4)){
            case 1:
                return hufflepuff;
            case 2:
                return slytherin;
            case 3:
                return gryffindor;
            case 4:
                return ravenclaw;
        }
        return gryffindor;
    }

    public static Wizard initPlayer () {
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
        Wand wand=new Wand();
        System.out.println(wand.toString());
        House house=initHouse();
        System.out.println(house.toString());
        Wizard player = new Wizard(name,
                        Pet.values()[indexPet],
                        wand,
                        house,
                        new ArrayList<Spell>(),
                        new Potion[10],
                        1);
        return player;
    }
    //=================================================================================================================
    //  Main function
    //=================================================================================================================
    public static void main(String[] args) {
        Wizard player =initPlayer();
        //Avant baston période de cours, le pélo peux craft 6 potion et apprendre 2 sort en plus de ceux appris en cours
        // Pour les combat il y auras attack, sort, potion, item


    }
}