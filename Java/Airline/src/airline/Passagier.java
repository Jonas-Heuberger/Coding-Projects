package airline;

public class Passagier extends Person {
    double preis;
    int age;

    public Passagier(String vorname, String nachname, int flugnummer, double preis, int age) {
        super(vorname, nachname, flugnummer);
        this.preis = preis;
        this.age = age;
    }
}
