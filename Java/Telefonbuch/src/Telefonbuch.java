package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Telefonbuch {

    private static int id = 0;

   private static List<Telefon> telefonList = new ArrayList<>();

   

    public static void menue(){
        System.out.println("""
                1. Hinzufügen
                2. Bearbeiten
                3. Anzeigen
                4. Löschen
                """);

                String option = scanString();
            
                switch (option) {
                    case "1":
                        add();
                    case "2":
                        edit();
                    case "3":
                        show();
                    case "4": 
                        delete();                
                    default:  
                        System.out.println("Wrong Input");
                        menue();
                }
    }

    private static void add(){
       
        System.out.println("Vorname");
        String vorname = scanString();

        System.out.println("Nachname");
        String nachname = scanString();

        System.out.println("Adresse");
        String adresse = scanString();

        System.out.println("Telefon Nummer");
        String telefonnummer = scanString();

        System.out.println("URL");
        String url = scanString();

        System.out.println("Id Nummer");
        int idNummer = scanInt();

        Telefon telefon = new Telefon(id, vorname, nachname, adresse, telefonnummer, url, idNummer);

        id++;

        telefonList.add(telefon);
        
        menue();

    }

    private static void edit(){

        System.out.println("Welche ID");
        int userId = scanInt();

        System.out.println("Vorname");
        String vorname = scanString();

        System.out.println("Nachname");
        String nachname = scanString();

        System.out.println("Adresse");
        String adresse = scanString();

        System.out.println("Telefon Nummer");
        String telefonnummer = scanString();

        System.out.println("URL");
        String url = scanString();

        System.out.println("Id Nummer");
        int idNummer = scanInt();

        
        Telefon tel = telefonList.get(userId);
        Telefon save = new Telefon(tel.id, vorname, nachname, adresse, telefonnummer, url, idNummer);
        telefonList.set(userId, save);
    
       menue();
    }

    private static void show(){
        for (Telefon t: telefonList) {
            System.out.println(t.id + " " + t.vorname + " "+ t.nachname + " " + t.adresse + " " + t.telefonnummer + " " + t.url + " " + t.idNummer);
        }

        menue();
    }

    private static void delete(){
        System.out.println("Welche ID");
        int userId = scanInt();

        telefonList.remove(userId);
        for (int i = userId; i > telefonList.size(); i++){
            Telefon tel = telefonList.get(i);
            id--;
            telefonList.set(i, tel);
        }
       menue();
    }

    private static String scanString(){
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        return txt;
    }

    private static int scanInt(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }
}
