// Code from Jonas Keil

public class Main {
    public static void main(String[] args) {
        Hund laprador = new Hund(4, "laprador", "braun", true);
        Hund hundObject1 = new Hund(5, "dackel", "braun", true);
        hundObject1.bellen("wuff wuff");
        hundObject1.plusRechnen(1,3, 4);
        int Number = hundObject1.rechnePlus(1, 2);
        System.out.println(Number);
    }

}
