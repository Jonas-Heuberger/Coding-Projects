import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AdressItem userAdresse = AdressItem();

        System.out.println("id: " + userAdresse.id);
        System.out.println("Nachname: " + userAdresse.nachname);
        System.out.println("Vorname: " + userAdresse.vorname);
        System.out.println("Strasse: " + userAdresse.strasse);
        System.out.println("PLZ: " + userAdresse.plz);
        System.out.println("Ort: " + userAdresse.ort);
    }

     private static int AbfrageINT(){
        Scanner scanner = new Scanner(System.in);
        int zahl = scanner.nextInt();
        return zahl;
    }

    private static String AbrageString(){
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.next();
        return txt;
    }

    private static AdressItem AdressItem(){
        System.out.println("geben Sie Ihre ID ein: ");
        int userId = AbfrageINT();

        System.out.println("geben Sie Ihren Nachname ein: ");
        String userNachname = AbrageString();

        System.out.println("geben Sie Ihren Vornamen ein: ");
        String userVorname = AbrageString();

        System.out.println("geben Sie Ihre Strasse ein: ");
        String userStrasse = AbrageString();

        System.out.println("geben Sie Ihre PLZ ein: ");
        int userPLZ = AbfrageINT();

        System.out.println("geben Sie Ihren Ort ein: ");
        String userOrt = AbrageString();

        AdressItem userAdresse = new AdressItem(userId, userNachname, userVorname, userStrasse, userPLZ, userOrt);
        return userAdresse;
    }

}
