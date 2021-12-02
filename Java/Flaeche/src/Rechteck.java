public class Rechteck {
    int laenge;
    int breite;

    public Rechteck(int laenge, int breite) {
        this.laenge = laenge;
        this.breite = breite;
    }

     void flaeche(){
        int flaeche = laenge * breite;
        System.out.println(flaeche);
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }
}
