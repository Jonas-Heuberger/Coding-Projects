import java.util.Scanner;

public class Abschreibung {
    public static void main(String[] args) {

        System.out.println("Betrag: ");
        double betrag = abfrageDouble();

        System.out.println("Jahre: ");
        double jahre = abfrageDouble();

        System.out.println("Prozentsatz: ");
        double prozentsatz1 = abfrageDouble();

        Degressiv d = new Degressiv(betrag, jahre, prozentsatz1);

        Linear l = new Linear(betrag, jahre);

       double prozentsatz = l.prozentsatz(betrag, jahre);

        System.out.println("""
                
                """);

       l.berechneLinear(betrag, jahre, prozentsatz);
        System.out.println("""
                
                """);
       d.berechneDegressiv(betrag, jahre, prozentsatz1);

    }

    static double abfrageDouble(){
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        return num;
    }

}
