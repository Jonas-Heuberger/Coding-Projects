import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Geben Sie jeweils die Anzahl der Kleidungsstücke an");

        System.out.println("Wie viele T-Shirts haben Sie?");
        int userTShirts = abfrageINT();

        System.out.println("Wie viele Hosen haben Sie?");
        int userHosen = abfrageINT();

        System.out.println("Wie viele Socken haben Sie?");
        int userSocken = abfrageINT();

        System.out.println("Wie viele Unterhosen haben Sie?");
        int userUnterhosen = abfrageINT();

        System.out.println("Wie viele Pullis haben Sie?");
        int userPullis = abfrageINT();

        Kleiderschrank Kleider = new Kleiderschrank(userTShirts, userHosen, userSocken, userUnterhosen, userPullis);

        System.out.println(Kleider.TShirts);
        System.out.println(Kleider.Hosen);
        System.out.println(Kleider.Socken);
        System.out.println(Kleider.Unterhosen);
        System.out.println(Kleider.Pullis);

    }
    private static int abfrageINT(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }
}
