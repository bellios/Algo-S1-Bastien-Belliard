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
        else System.out.println("les deux cahines ne sont pas égales");
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
            System.out.println("Veuillez saisir un deuxième entier positif et non nul");
            entier = scanner.nextInt();
        } while (entier == 0);
        System.out.println("La division de " + premierEntier + " avec " + entier + "est egale a " + premierEntier / entier);
    }
    public static void main(String[] args) {
        division();
    }
}