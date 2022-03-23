package Mitarbeiterverwaltung;

public class AussendienstMitarbeiter extends Mitarbeiter {
    double provision;
    public AussendienstMitarbeiter(String firstname, String lastname, double salary, double provision) {
        super(firstname, lastname, salary);
        this.provision = provision;
    }
}

