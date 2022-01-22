import java.util.Scanner;

public class Abschreibung {

    Linear l = new Linear(betrag, alter, zeitspanne);
    Degressiv d = new Degressiv(betrag, alter, zeitspanne, prozentsatz);


    public void addLinear(){

    }

    public void addDegressiv(){

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
        System.out.println("1: Hinzufügen");
        System.out.println("2: Bearbeiten");
        System.out.println("3: Anzeigen");
        System.out.println("4: Löschen");
        System.out.println("5: aelter als ein Jahr");

        int userInput = abfrageINT();

        switch (userInput){
            case 1-> addItem();
            case 2-> editItem();
            case 3-> showItem();
            case 4-> deleteItem();
            case 5 -> showItemOverYear();
            default -> {
                System.out.println("ungültiger Input");
                userInterface();
            }
        }
    }

}
