public class Tierverwaltung {
     String tierart;
     String name;
     String fellfarbe;
     String alter;
     String geschlecht;
     String gewicht;
     String grösse;
     String geräusch;

    public Tierverwaltung(String tierart, String name, String fellfarbe, String alter, String geschlecht, String gewicht, String geräusch) {
        this.tierart = tierart;
        this.name = name;
        this.fellfarbe = fellfarbe;
        this.alter = alter;
        this.geschlecht = geschlecht;
        this.gewicht = gewicht;
        this.geräusch = geräusch;
    }


    void geräuschErzeugen(String geräusch) {
        System.out.println(geräusch);
    }

    void schlafen(String tierart){
        System.out.println(tierart + " " + "schläft");
    }


}
