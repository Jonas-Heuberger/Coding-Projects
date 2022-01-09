public class Hund extends Tierverwaltung {
    String beine = "4";
    public Hund(String tierart, String name, String fellfarbe, String alter, String geschlecht,String gewicht, String geräusch) {
        super(tierart, name, fellfarbe, alter, geschlecht, gewicht, geräusch);

    }
    void pfoteGeben(){
        System.out.println("Hund gibt Pfote");
    }

    public static void wuff(){
        System.out.println("wuff wuff");
    }
}
