package airline;

import java.io.Serializable;

public class Person implements Serializable {
    String vorname;
    String nachname;
    int flugnummer;

    public Person(String vorname, String nachname, int flugnummer) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.flugnummer = flugnummer;
    }

}
