import java.util.ArrayList;
import java.util.Scanner;

public class Einkaufsliste {
    public static void main(String[] args) {
        ArrayList <String> Einkaufsliste = new ArrayList<>();

        for (int id = 0; true; id++){
            System.out.println("Eintrag hinzufügen? [j/n]");
            String s = abfrage();

            if (s.equals("j")){
                System.out.println("Produkt: ");
                String produkt = abfrage();
                Einkaufsliste.add(id + produkt);
            }
            if (s.equals("n")){
                System.out.println("Ihre Einkaufsliste: ");
                for (String produkt : Einkaufsliste) {
                    System.out.println(produkt);
                }
                break;
            }
        }
    }
    private static String abfrage(){
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.next();
        return txt;
    }
}
