public class Rechteck {
    int laenge;
    int breite;

    public Rechteck(int laenge, int breite) {
        this.laenge = laenge;
        this.breite = breite;
    }

    public void flaeche(){
        int flaeche = laenge * breite;
        System.out.println(flaeche);
    }
}
