import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lohn: ");
        double lohn = abfrageDouble();

        if (lohn > 12350){
            ALV2(lohn);
        }

        double AHVprozent = 5.275;

        double ALVprozent = 1.1;

        double AHVbeitrag = AHVbeitrag(lohn, AHVprozent);

        double ALVbeitrag = ALVbeitrag(lohn, ALVprozent);

        double ALV2beitrag = ALV2(lohn);

        System.out.println("Sie müssen " + AHVbeitrag + "CHF AHV bezahlen");

        System.out.println("Sie müssen " + ALVbeitrag + "CHF ALV bezahlen");

        System.out.println("Sie müssen " + ALV2beitrag + "CHF ALV2 bezahlen");







    }

     private static double abfrageDouble(){
        Scanner scanner = new Scanner(System.in);
        double Zahl = scanner.nextDouble();
        return Zahl;
    }
    private static double AHVbeitrag(double lohn, double AHVprozent){
        return lohn / 100 * AHVprozent;
    }

    private static double ALVbeitrag(double lohn, double ALVprozent){
        return lohn / 100 * ALVprozent;
    }

    static double ALV2(double lohn){
            double zwischenSumme = lohn - 12350;
            lohn = zwischenSumme / 100 * 0.5;
            return lohn;

        }
    }
}
