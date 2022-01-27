import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abschreibung {

    List<Abschreibung> abschreibung = new ArrayList<>();

    public void addLinear(){

        double betrag = abfrageDouble();

        int alter = abfrageINT();

        int zeitspanne = abfrageINT();

       double result = l.linear(betrag, alter, zeitspanne);
        System.out.println(result);
    }

    public void addDegressiv(){

        double betrag = abfrageDouble();

        int alter = abfrageINT();

        int zeitspanne = abfrageINT();

        double prozentsatz = abfrageDouble();

        Degressiv d = new Degressiv(betrag, alter, zeitspanne, prozentsatz),

        double result = d.degressiv(betrag, alter, prozentsatz);
        System.out.println(result);
    }

    public static double abfrageDouble(){
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        return num;
    }

    public static int abfrageINT(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }

    public void userInterface(){
        System.out.println("Willkommen");
        System.out.println("1: linear abschreiben");
        System.out.println("2: degressiv abschreiben");
        System.out.println("3: Anzeigen");
        System.out.println("4: Löschen");
        System.out.println("5: aelter als ein Jahr");

        int userInput = abfrageINT();

        switch (userInput){
            case 1-> addLinear();
            case 2-> addDegressiv();

            default -> {
                System.out.println("ungültiger Input");
                userInterface();
            }
        }
    }

}
