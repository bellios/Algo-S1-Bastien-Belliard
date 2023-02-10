import java.util.Scanner;
public class Main {
    // Part 5.1
    private static void somme() {
        System.out.println("Veuillez saisir le premier entier");
        Scanner scanner = new Scanner(System.in);
        int premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();
        int tot = premierEntier + deuxiemeEntier;
        System.out.println("La somme de " + premierEntier + " avec " + deuxiemeEntier + "est egale a " + tot);
    }
    // Part 5.2
    private static void division() {
        System.out.println("Veuillez saisir le premier entier");
        Scanner scanner = new Scanner(System.in);
        float premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        float deuxiemeEntier = scanner.nextInt();
        float tot = premierEntier / deuxiemeEntier;
        System.out.println("La division de " + premierEntier + " avec " + deuxiemeEntier + "est egale a " + tot);
    }
    // Part 5.3
    private static void volume() {
        System.out.println("Veuillez saisir la hauteur");
        Scanner scanner = new Scanner(System.in);
        float premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir la largeur");
        float deuxiemeEntier = scanner.nextInt();
        System.out.println("Veuillez saisir la longeur");
        float troisiemeEntier = scanner.nextInt();
        float tot = premierEntier * deuxiemeEntier*troisiemeEntier;
        System.out.println("Le volume du pavé est de : " + tot);
    }
    public static void main(String[] args) {
        // Part 3
        /*Scanner scanner = new Scanner(System.in);
        int unEntier = scanner.nextInt();
        float unReel = scanner.nextFloat();
        System.out.println("J’ai recupere un entier: " + unEntier);
        System.out.println("J’ai aussi recupere un reel: " + unReel);*/
        // Part 4
        /*System.out.println("« Bonjour, quel est votre prénom ?");
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());*/
        // Part 5.1
        volume();
    }
}