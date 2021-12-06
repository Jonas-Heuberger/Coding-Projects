public class Rechteck {
    int laenge;
    int breite;
    int hoehe;

    public Rechteck(int laenge, int breite, int hoehe) {
        this.laenge = laenge;
        this.breite = breite;
        this.hoehe = hoehe;
    }

     void flaeche(){
        int flaeche = laenge * breite;
        System.out.println(flaeche + " m2");
    }
    void Volumen(){
        int volumen = laenge * breite * hoehe;
        System.out.println(volumen + " m3");
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
