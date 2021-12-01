public class Katze {
    //Attribute
    int alter;
    String fellfarbe;
    String augenfarbe;
    String rasse;
    int grösse;

    //Konstruktor
    public Katze(int alter, String fellfarbe, String augenfarbe, String rasse, int grösse){
        this.alter = alter;
        this.fellfarbe = fellfarbe;
        this.augenfarbe = augenfarbe;
        this.rasse = rasse;
        this.grösse = grösse;
    }
    //Methoden

    public void miauen(String miauen){
        System.out.println(miauen);
    }
    void springen(int höhe){
        System.out.println("Katze springt " + höhe + " Meter hoch");
    }


    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getFellfarbe() {
        return fellfarbe;
    }

    public void setFellfarbe(String fellfarbe) {
        this.fellfarbe = fellfarbe;
    }

    public String getAugenfarbe() {
        return augenfarbe;
    }

    public void setAugenfarbe(String augenfarbe) {
        this.augenfarbe = augenfarbe;
    }

    public String getRasse() {
        return rasse;
    }

    public void setRasse(String rasse) {
        this.rasse = rasse;
    }

    public int getGrösse() {
        return grösse;
    }

    public void setGrösse(int grösse) {
        this.grösse = grösse;
    }
}
