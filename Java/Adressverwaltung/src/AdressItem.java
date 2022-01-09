import java.util.Scanner;

public class AdressItem {
    //Attribute

    int id;
    String nachname;
    String vorname;
    String strasse;
    String plz;
    String ort;

    public AdressItem(String nachname, String vorname, String strasse, String plz, String ort) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }

    void edit(){
        id = AbrageINT();



    }

    public static String AbrageString(){
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.next();
        return txt;
    }

    public static int AbrageINT(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }


}
