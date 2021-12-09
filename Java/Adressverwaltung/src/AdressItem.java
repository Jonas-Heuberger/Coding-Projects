import java.util.Scanner;

public class AdressItem {
    //Attribute

    String id;
    String nachname;
    String vorname;
    String strasse;
    String plz;
    String ort;

    public AdressItem(String id, String nachname, String vorname, String strasse, String plz, String ort) {
        this.id = id;
        this.nachname = nachname;
        this.vorname = vorname;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }

    void edit(){


    }

    public static String AbrageString(){
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.next();
        return txt;
    }


}
