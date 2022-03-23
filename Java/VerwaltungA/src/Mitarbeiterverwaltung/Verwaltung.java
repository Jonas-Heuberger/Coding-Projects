package Mitarbeiterverwaltung;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class Verwaltung implements Serializable {
    public int getLetzteID() {
        return letzteID;
    }

    public LinkedHashMap<Integer, Anlage> getAnlagen() {
        return anlagen;
    }

    private int letzteID = 0;
    private LinkedHashMap<Integer, Anlage> anlagen= new LinkedHashMap<Integer, Anlage>();

    public void add(Anlage anlage){
        letzteID++;
        anlagen.put(letzteID, anlage);
    }

    public void delete(int id){
        this.anlagen.remove(id);
    }
}
