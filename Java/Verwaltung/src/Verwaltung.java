import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 //Kommentar
public class Verwaltung implements Serializable {

    public static int id = 1;

    List<Storage> items = new ArrayList<>();

   public static String abfrage(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }

    public static int abfrageINT(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }

  public  void addItem(){
        System.out.println("Wert eingeben: ");
        String temp = abfrage();

      System.out.println("log in Monaten angeben");
        int log = abfrageINT();
        Storage it = new Storage(id, temp, log);
        id++;
        items.add(it);
       userInterface();
    }

  public  void editItem(){
        System.out.println("Welche ID");
        int userId = abfrageINT();

        System.out.println("Wert eingeben: ");
        String tempj = abfrage();

      System.out.println("log in Monat");
      int log = abfrageINT();

        Storage temp = items.get(userId);
        Storage it = new Storage(temp.id-1, tempj, log);
        items.set(userId-1, it);

       userInterface();
    }

   public  void deleteItem(){
        System.out.println("Welche ID");
        int userId = abfrageINT();
        items.remove(userId-1);
        for (int i = userId-1; i > items.size(); i++){
            Storage temp = items.get(i);
            temp.id--;
            items.set(i, temp);
        }
       userInterface();
    }

   public  void showItem(){
      for (int i =0; i < items.size(); i++) {
          Storage j = items.get(i);
          System.out.println("id: " + j.id + " " + j.value + j.log);
      }
       userInterface();
    }
    
    public void showItemOverYear() {
        for (int i =0; i < items.size(); i++) {
            Storage j = items.get(i);
            if(j.log >= 12) {
                System.out.println("id: " + j.id + " " + j.value + j.log);
            }
        }
            userInterface();
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
