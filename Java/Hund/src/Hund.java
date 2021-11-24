public class Hund {
    // Attribute
    int alter;
    String art;
    String fellfarbe;
    boolean kannPfoteGeben;

    //Methoden
    public void bellen(){
        System.out.println("Wuff Wuff");
    }
    public void plusRechnen(int num1, int num2, int num3){
        System.out.println(num1 + num2 + num3);
    }
    public static int rechnePlus(int num1, int num2){
        return num1 + num2;
    }

}
