import java.util.Scanner;
import java.lang.*;
public class Main {
    // 3.1.1
    public static void discriminant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de a ?");
        int a = scanner.nextInt();
        System.out.println("Quelle est la valeur de b ?");
        int b = scanner.nextInt();
        System.out.println("Quelle est la valeur de c ?");
        int c = scanner.nextInt();
        int delta = (int) (Math.pow(b, 2) - 4 * a * c);
        if (delta < 0) {
            String x0="(-"+b+"+i*"+Math.sqrt(-delta)+")/"+(2*a);
            String x1="(-"+b+"-i*"+Math.sqrt(-delta)+")/"+(2*a);
            System.out.println("x0 ="+x0+" x1="+x1);
            //System.out.println("Ce polynome n’a pas de racine reelle");
        }else if(delta == 0){
            double x0=(-b)/(2*a);
            System.out.println("x0 ="+x0);
        }else if(delta > 0){
            double x0=(-b)+(Math.sqrt(delta))/(2*a);
            double x1=(-b)-(Math.sqrt(delta))/(2*a);
            System.out.println("x0 ="+x0+" x1="+x1);
        }
    }
    // 3.1.2
    public static void parite(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de a ?");
        int a = scanner.nextInt();
        if(a%2!=0) System.out.println("impair");
        else System.out.println("pair");
    }
    // 3.1.3
    public static void max(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de a ?");
        int a = scanner.nextInt();
        System.out.println("Quelle est la valeur de b ?");
        int b = scanner.nextInt();
        if(a<b) System.out.println("B est plus grand");
        else if(a>b) System.out.println("A est plus grand");
        else System.out.println("les deux sont égaux");
    }
    public static boolean mini(int a, int b){
        if(a>b) return true;
        else return false;
    }
    public static boolean maxi(int a, int b){
        if(a<b) return true;
        else return false;
    }
    public static void min(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de a ?");
        int a = scanner.nextInt();
        System.out.println("Quelle est la valeur de b ?");
        int b = scanner.nextInt();
        if(a<b) System.out.println("A est plus petit");
        else if(a>b) System.out.println("B est plus petit");
        else System.out.println("les deux sont égaux");
    }
    // 3.1.4
    public static void egaliteStr(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de a ?");
        String a = scanner.nextLine();
        System.out.println("Quelle est la valeur de b ?");
        String b = scanner.nextLine();
        if(a.equals(b)) System.out.println("les deux chaines sont égales");
        else System.out.println("les deux chaines ne sont pas égales");
    }
    // 3.2
    public static void factorielle() {
        Scanner scanner = new Scanner(System.in);
        int entier;
        do {
            System.out.println("Veuillez saisir un entier positif ou nul");
            entier = scanner.nextInt();
        } while (entier > 0);

        int factorielle = 1;
        for (int i = 1; i <= entier; i++) {
            factorielle *= i;
        }
        System.out.println(entier + "! = " + factorielle);
    }
    // 3.2.1
    public static void countdown() {
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println("BOOM");
    }
    // 3.2.2
    public static void carres(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de a ?");
        int a = scanner.nextInt();
        System.out.println("x="+a+"\tx²="+a*a);
    }
    // 3.2.3
    public static void tableMultiplication() {
        for(int i=1;i<=10;i++){
            for(int y=1;y<=10;y++){
                System.out.print(i*y+"\t");
            }
            System.out.print("\n");
        }
    }
    // 3.2.5
    private static void division() {
        System.out.println("Veuillez saisir le premier entier");
        Scanner scanner = new Scanner(System.in);
        int premierEntier = scanner.nextInt();
        int entier;
        do {
            System.out.println("Veuillez saisir un deuxième entier non nul");
            entier = scanner.nextInt();
        } while (entier == 0);
        System.out.println("La division de " + premierEntier + " avec " + entier + "est egale a " + premierEntier / entier);
    }
    // 3.3.1
    private static void regle(){
        Scanner scanner = new Scanner(System.in);
        int entier;
        do {
            System.out.println("Veuillez saisir un deuxième entier positif et non nul");
            entier = scanner.nextInt();
        } while (entier == 0);
        for(int i=0;i<=entier;i++){
            if(i%10==0){
                System.out.print("|");
            }else {
                System.out.print("-");
            }
        }
    }
    // 3.3.2
    private static void nombrePremier(){
        Scanner scanner = new Scanner(System.in);
        int entier;
        do {
            System.out.println("Veuillez saisir un entier strictement positif");
            entier = scanner.nextInt();
        } while (entier == 0);
        boolean test=true;
        for(int i=2;i<entier;i++){
            if(entier%i==0) test=false;
        }
        if(test){
            System.out.println("Le nombre est premier");
        }else{
            System.out.println("le nombre n'est pas premier");
        }
    }
    // 3.4.1
    public static void initialisationTableau() {
        int[] tableau = new int[20];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = (int)(Math.random()*100);
        }
        afficheTableau(tableau);
        inverseTableau(tableau);
        afficheTableau(tableau);
    }
    public static void afficheTableau(int[] tableau) {
        int min=tableau[0];
        int max=tableau[0];
        for (int i = 0; i < tableau.length; i++) {
            System.out.print(tableau[i]+"\t");
            if(i%2==0) System.out.print(tableau[i]+"\t");
            else System.out.print("\t");
            if(tableau[i]%2==0) System.out.print(tableau[i]+"\n");
            else System.out.print("\n");
            if(mini(min,tableau[i])) min=tableau[i];
            if(maxi(max,tableau[i])) max=tableau[i];
        }
        System.out.print("\n");
        System.out.println("Maxi : "+max+"\t Mini : "+min);
    }
    public static void inverseTableau(int[] tableau) {
        for(int i=0;i<tableau.length/2;i++) {
            int a = tableau[i];
            tableau[i]=tableau[tableau.length - i-1];
            tableau[tableau.length - i-1]=a;
        }
    }

    public static void main(String[] args) {
        System.out.println("Quel exercice ? Saisissez :\n" +
                "1. Discriminant\n" +
                "2. Parité d’un nombre\n" +
                "3. Calcul d’extremum\n" +
                "4. Égalité entre chaînes de caractères\n" +
                "5. Factorielle\n" +
                "6. Compte à rebous\n" +
                "7. Valeurs de carrés\n" +
                "8. Table de multiplication\n" +
                "9. Division d’entiers\n" +
                "10. Règle graduée\n" +
                "11. Nombres premiers\n" +
                "12. Manipulations sur un tableau");
        Scanner scanner = new Scanner(System.in);
        int entier;
        do {
            System.out.println("Veuillez saisir un entier entre 1 et 12");
            entier = scanner.nextInt();
        } while (entier>=12&&entier<=1);
        switch (entier){
            case(1) :
                discriminant();
                break;
            case(2) :
                parite();
                break;
            case(3) :
                max();
                min();
                break;
            case(4) :
                egaliteStr();
                break;
            case(5) :
                factorielle();
                break;
            case(6) :
                countdown();
                break;
            case(7) :
                carres();
                break;
            case(8) :
                tableMultiplication();
                break;
            case(9) :
                division();
                break;
            case(10) :
                regle();
                break;
            case(11) :
                nombrePremier();
                break;
            case(12) :
                initialisationTableau();
                break;
        }
    }
}