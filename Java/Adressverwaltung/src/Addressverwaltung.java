import java.util.Scanner;

public class Addressverwaltung {
    public static void main(String[] args) {

        AdressItem userAdresse = AdressItem();
        showUserAdresse(userAdresse);
    }



    public static String AbrageString(){
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.next();
        return txt;
    }

    public static AdressItem AdressItem(){
        System.out.println("geben Sie Ihre ID ein: ");
        String userId = AbrageString();

        System.out.println("geben Sie Ihren Nachname ein: ");
        String userNachname = AbrageString();

        System.out.println("geben Sie Ihren Vornamen ein: ");
        String userVorname = AbrageString();

        System.out.println("geben Sie Ihre Strasse ein: ");
        String userStrasse = AbrageString();

        System.out.println("geben Sie Ihre PLZ ein: ");
        String userPLZ = AbrageString();

        System.out.println("geben Sie Ihren Ort ein: ");
        String userOrt = AbrageString();

        checkInput();

        AdressItem userAdresse = new AdressItem(userId, userNachname, userVorname, userStrasse, userPLZ, userOrt);
        return userAdresse;
    }

    private static void checkInput(){
        System.out.println("ist das Korrekt? ");
        String correct = AbrageString();
        if (correct.equals("ja")){
            System.out.println("Perfekt vielen Dank");
        } else {
            AdressItem();
        }
    }

    private static void showUserAdresse(AdressItem userAdresse){
        System.out.println("id: " + userAdresse.id);
        System.out.println("Nachname: " + userAdresse.nachname);
        System.out.println("Vorname: " + userAdresse.vorname);
        System.out.println("Strasse: " + userAdresse.strasse);
        System.out.println("PLZ: " + userAdresse.plz);
        System.out.println("Ort: " + userAdresse.ort);
    }

}
