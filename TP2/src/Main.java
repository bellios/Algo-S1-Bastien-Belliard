import java.util.Scanner;
import java.lang.*;
public class Main {
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
            String x0="(-"+b+"+i[Math.sqrt("+(-delta)+")])/"+(2*a);
            String x1="(-"+b+"-i[Math.sqrt("+(-delta)+")])/"+(2*a);
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


    public static void main(String[] args) {

        discriminant();
    }
}