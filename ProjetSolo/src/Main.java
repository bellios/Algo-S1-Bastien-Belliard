import java.util.Scanner;
public class Main {
    public static House initHouse(){
        House hufflepuff=new House("Hufflepuff", 1.20F,1,1,1);
        House slytherin=new House("Slytherin", 1,1.20F,1,1);
        House gryffindor=new House("Gryffindor", 1,1,1.20F,1);
        House ravenclaw=new House("Ravenclaw", 1,1,1,1.20F);
        switch ((int)(Math.random()*4){
            case 1:
                return hufflepuff;

        }
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
        System.out.println("Enter the number of the pet you want, you can only choose one.");
        int indexPet = scanner.nextInt();
        Wand wand=new Wand();
        wand.toString();


        Wizard player=new Wizard(name,
                Pet.values()[indexPet],
                wand,
                house,
                new Spell[],
                new Potion[]);
        return player;

    }
    public static void main(String[] args) {


    }
}