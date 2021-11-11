import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Insert Betrag: ");
        double betrag = Abfrage();
        System.out.println("Insert Prozentsatz");
        double prozentsatz = Abfrage();
        System.out.println(berechneDreisatz(betrag, prozentsatz));
    }
    private static double Abfrage(){
        Scanner scan = new Scanner(System.in);
        double Zahl = scan.nextDouble();
        return Zahl;
    }
    private static double berechneDreisatz(double betrag, double prozentsatz){
        double prozent = betrag / 100;
        return prozent * prozentsatz;
    }
}
