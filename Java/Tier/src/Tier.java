public class Tier {
    public static void main(String[] args) {
        Hund h = new Hund("Hund", "Bello", "grau", "10", "Männlich", " 15kg", "wuff wuff");
        h.geräuschErzeugen(h.geräusch);
        h.schlafen(h.tierart);
        h.pfoteGeben();
        System.out.println(h.beine);

        Katze k = new Katze("Katze", "Fiona", "grau", "4", "Weiblich", "12.5", "Miau");
        k.geräuschErzeugen(k.geräusch);
        k.schlafen(k.tierart);
        k.schnurren();
    }

}
