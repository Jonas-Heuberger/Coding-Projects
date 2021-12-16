import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lohn: ");
        double lohn = abfrageDouble();

        double AHVprozent = 5.275;

        double ALVprozent = 1.1;

        double ALV2limit = 12350;

        double Koordinationsabzug = 2073.75;


        if (lohn > 12350){   
        AHVbeitrag(lohn, AHVprozent);
        ALVbeitrag(lohn, ALVprozent, ALV2limit);
        ALV2(lohn);


        } else {
            AHVbeitrag(lohn, AHVprozent);
            ALVbeitrag(lohn, ALVprozent, ALV2limit);
        }
    }

     private static double abfrageDouble(){
        Scanner scanner = new Scanner(System.in);
        double Zahl = scanner.nextDouble();
        return Zahl;
    }
    
    private static void AHVbeitrag(double lohn, double AHVprozent){
        System.out.println((lohn / 100) * AHVprozent);
    }

    private static void ALVbeitrag(double lohn, double ALVprozent, double ALV2limit){
        if (lohn > 12350) {
           System.out.println((ALV2limit / 100) * ALVprozent);
        } else {
             System.out.println(lohn / 100 * ALVprozent);
        }
    }

    static void ALV2(double lohn){
            double zwischenSumme = lohn - 12350;
            lohn = (zwischenSumme / 100) * 0.5;
        System.out.println(lohn);

        }

    }


