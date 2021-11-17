import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("geben Sie ihren Betrag ein: ");
        double Betrag = Abfrage();
        System.out.println("Geben Sie die Anzahl Jahre ein: ");
        double Jahre = Abfrage();
        System.out.println("geben sie den Prozentsatz ein: ");
        double Prozentsatz = Abfrage();
        double result = Calc(Betrag, Jahre, Prozentsatz);
        Output(result, Betrag, Jahre);
    }

    private static double Abfrage(){

        Scanner scan = new Scanner(System.in);
        double Zahl = scan.nextDouble();
        return Zahl;
    }

    private static double Calc(double Betrag, double Jahre, double Prozentsatz){
        double result3 = 0;
        double result = Betrag / 100;
        double result2 = result * Prozentsatz;
       while (Jahre >= 0){
           Jahre--;
           result3 = Betrag - result2;
       }
       return result3;

    }
    private static void Output(double result, double Betrag, double Jahre){
        System.out.println("Ihn " + Jahre + " Jahren werden " + result + " von " + Betrag + " abgezogen" );

    }
}
