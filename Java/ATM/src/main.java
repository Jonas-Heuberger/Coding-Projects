import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.print("Geben Sie eine Zahl ein: ");
        int betrag = Abfrage();
        int[] Noten = berechnen(betrag);
        Ausgabe(Noten);
    }
    private static int Abfrage() {
        Scanner scan = new Scanner(System.in);
        int Zahl = scan.nextInt();
        return Zahl;
    }

    public static int[] berechnen(int betrag){
        int[]Noten = new int[9];

        for (Noten[0] = 0; betrag >= 1000; Noten[0]++){
            betrag = betrag - 1000;
        }
        
        for (Noten[1] = 0; betrag >= 200; Noten[1]++){
            betrag = betrag - 200;
        }
        
        for (Noten[2] = 0; betrag >= 100; Noten[2]++){
            betrag = betrag - 100;
        }
        
        for (Noten[3] = 0; betrag >= 50; Noten[3]++){
            betrag = betrag - 50;
        }
        
        for (Noten[4] = 0; betrag >= 20; Noten[4]++){
            betrag = betrag - 20;
        }
        
        for (Noten[5] = 0; betrag >= 10; Noten[5]++){
            betrag = betrag - 10;
        }
        
        for (Noten[6] = 0; betrag >= 5; Noten[6]++){
            betrag = betrag - 5;
        }
        
        for (Noten[7] = 0; betrag >= 2; Noten[7]++){
            betrag = betrag - 2;
        }
        
        for (Noten[8] = 0; betrag >= 1; Noten[8]++){
            betrag = betrag - 1;
        }

       return Noten;
    }

    
    private static void Ausgabe(int[] Noten){
        System.out.println("Tausender: " + Noten[0]);
        System.out.println("Zweihunderter: " + Noten[1]);
        System.out.println("Hunderter: " + Noten[2]);
        System.out.println("Fünfziger: " + Noten[3]);
        System.out.println("Zwanziger: " + Noten[4]);
        System.out.println("Zehner: " + Noten[5]);
        System.out.println("Fünfer: " + Noten[6]);
        System.out.println("Zweier:  " + Noten[7]);
        System.out.println("Einer: " + Noten[8]);

    }

}
