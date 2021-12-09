public class AdressItem {
    //Attribute

    int id;
    String nachname;
    String vorname;
    String strasse;
    int plz;
    String ort;

    public AdressItem(int id, String nachname, String vorname, String strasse, int plz, String ort) {
        this.id = id;
        this.nachname = nachname;
        this.vorname = vorname;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }

    void edit(){
        Main.AdressItem();
    }


}
