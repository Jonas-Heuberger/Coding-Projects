package airline;

import java.io.Serializable;

public class CrewMember extends Person implements Serializable {



    public CrewMember(String vorname, String nachname, int flugnummer) {
        super(vorname, nachname, flugnummer);
    }
}
