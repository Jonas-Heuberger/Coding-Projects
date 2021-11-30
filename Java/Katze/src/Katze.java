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
    void springen(){
        System.out.println("Katze springt");
    }
}
