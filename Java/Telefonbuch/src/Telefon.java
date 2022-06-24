package src;
public class Telefon extends Person {

    String telefonnummer;
    String url;
    int idNummer;

    public Telefon(int id, String vorname, String nachname, String adresse, String telefonnummer, String url, int idNummer){
        super(id, vorname, nachname, adresse);
        this.telefonnummer = telefonnummer;
        this.url = url;
        this.idNummer = idNummer;

    }





    
}
