package airline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Verwaltung implements Serializable {

    // enum für Rolle (Pilot etc)

private List<Passagier> passagierList = new ArrayList<>();
private List<CrewMember> crewMemberList = new ArrayList<>();

    private void add(){

    }

    private void edit(){

    }

    private void show(){

    }

    private void delete(){

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
            case 1-> add();
            case 2-> edit();
            case 3-> show();
            case 4-> delete();
            default -> {
                System.out.println("ungültiger Input");
                userInterface();
            }
        }
    }


    private static int abfrageINT(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }

    private static String abfrageString(){
        Scanner scanner = new Scanner(System.in);
        String  txt = scanner.next();
        return txt;
    }

    private static double abfrageDouble(){
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        return num;
    }

}
