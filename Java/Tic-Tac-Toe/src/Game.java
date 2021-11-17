import java.util.Scanner;

public class Game {
    int PlayerOne = 0;
    int PlayerTwo = 1;

    public static int Abfrage(){
        System.out.println("Wo wollen sie ihr Symbol Plazieren? ");
        Scanner scan = new Scanner(System.in);
        int Zahl = scan.nextInt();
        return Zahl;
    }



}
