public class Hund {
    // Attribute
    int alter;
    String art;
    String fellfarbe;
    boolean kannPfoteGeben;

    //Konstruktor
    public Hund(int alter, String art, String fellfarbe, boolean kannPfoteGeben){
        this.alter = alter;
        this.art = art;
        this.fellfarbe = fellfarbe;
        this.kannPfoteGeben = kannPfoteGeben;

    }

    //Methoden
    public void bellen(String bellen){
        System.out.println(bellen);
    }
    public void plusRechnen(int num1, int num2, int num3){
        System.out.println(num1 + num2 + num3);
    }
    public static int rechnePlus(int num1, int num2){
        return num1 + num2;
    }

}
