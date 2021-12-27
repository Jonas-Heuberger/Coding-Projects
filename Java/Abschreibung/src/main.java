import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("geben Sie ihren Betrag ein: ");
        double Betrag = Abfrage();
        System.out.println("Geben Sie die Anzahl Jahre ein: ");
        double Jahre = Abfrage();
        double[] result = Calc(Betrag, Jahre);
        Output(result);
    }

    private static double Abfrage(){
        Scanner scan = new Scanner(System.in);
        double Zahl = scan.nextDouble();
        return Zahl;
    }

    private static double[] Calc(double Betrag, double Jahre){
       double JährlicheAbschreibung = Betrag / Jahre;
       double Prozentsatz = 100 / Jahre;
       double[] Abschreibung  = new double[2];
        Abschreibung[0] = JährlicheAbschreibung;
        Abschreibung[1] = Prozentsatz;
       return Abschreibung;


    }
    private static void Output(double[] result){
        System.out.println("Jährlich werden " + result[0] + "CHF zum Prozentsatz von " + result[1] + "% abgezogen" );

    }
}
