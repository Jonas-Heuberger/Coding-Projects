package Mitarbeiterverwaltung;

import java.time.Year;
import java.util.Scanner;

public class UserInterface {
    private static Verwaltung verwaltung;

    //private static Scanner scanner;

    public enum AnlageType {
        Linear, Degressiv
    }

    public UserInterface(Verwaltung verwaltung){
        this.verwaltung = verwaltung;
    }

    public static void start() {
        Menu men1 = new Menu();
        men1.addMenuItem('a', "Neue Anlage (linear) erstellen", f1);
        men1.addMenuItem('b', "Neue Anlage (degressiv) erstellen", f2);
        men1.addMenuItem('c', "Anzeigen aller Anlagen", f3);
        men1.addMenuItem('d', "Löschen einer Anlage", f4);
        men1.anzeigen();
    }

    private static final Menu.Funktion f1 = new Menu.Funktion() {
        public void eval() {
            createAnlage(AnlageType.Linear);
            return;
        }
    };
    private static final Menu.Funktion f2 = new Menu.Funktion() {
        public void eval() {
            createAnlage(AnlageType.Degressiv);
            return;
        }
    };
    private static final Menu.Funktion f3 = new Menu.Funktion() {
        public void eval() {
            listAnlagen();
            return;
        }
    };

    private static final Menu.Funktion f4 = new Menu.Funktion() {
        public void eval() {
            int id = selectAnlage();
            verwaltung.delete(id);
            return;
        }
    };
    private static final  void createAnlage(AnlageType type)
    {
        Anlage  anlage = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte Anlageinfos eingeben: ");
        System.out.println("Bezeichnung der Anlage: ");
        String bezeichnung = scanner.nextLine();
        System.out.println("Anschaffungsjahr: ");
        int jahr = scanner.nextInt();
        System.out.println("Anschaffungspreis: ");
        double preis = scanner.nextDouble();
        System.out.println("Abschreibungssatz: ");
        double satz = scanner.nextDouble();

        switch (type) {
            case Linear:
                anlage = new AnlageLinear(bezeichnung, jahr, preis, satz);
                break;
            case Degressiv:
                anlage = new AnlageDegressiv(bezeichnung, jahr, preis, satz);
                break;
        }

        if (anlage == null){
            return;
        }

        anlage.addAbschreiber();
        verwaltung.add(anlage);
    }

    private static  final void listAnlagen(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        verwaltung.getAnlagen().forEach((key,value)->{
            System.out.println("Anlage" + key);
            System.out.println(value);
            System.out.println("----------------------------------------");
        });
    }

    private static final int selectAnlage(){
        Scanner reader = new Scanner(System.in);
        listAnlagen();
        System.out.println("Wählen Sie Ihre Anlagenummer?");
        return reader.nextInt();
    }
}
