import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Schreiben Sie Ihren Betrag"); // Abfrage des Betrages
        double Betrag = Abfrage(); // Definiere Abfrage der Zahl als Betrag
        System.out.println("Geben Sie den MWST Satz an:");
        double mwstSatz = Abfrage();
        Ausgabe(BerechneMwst(Betrag, mwstSatz));
    }


    public static double Abfrage(){ // Methode zur Abrage einer Zahl (kein Void!!!)
        Scanner scan = new Scanner(System.in);
        double Zahl = scan.nextDouble();
        return Zahl; // gebe Zahl zurück
    }

        public static double BerechneMwst(double Betrag, double mwstSatz){ // Betrag und MwstSatz aus der Abfrage Methode
            double Prozent = Betrag / 100; // 1% wird berechnet
            double Resultat = Prozent * mwstSatz; // Resultat wird berechnet
            return Resultat; // Resultat wird zurück gegeben

        }
    public static void Ausgabe(double Resultat){ // Resultat und Betrag für Ausgabe

        System.out.println("Die MWST Beträgt: " + Resultat + ".-");
        }
    }











