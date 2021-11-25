import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        System.out.println("Sie werden nun ihr Auto erstellen, viel Spass");

        System.out.println("Von welcher Marke ist ihr Auto?");
        String userMarke = stringAbfrage();

        System.out.println("Welche Farbe hat ihr Auto?");
        String userFarbe = stringAbfrage();

        System.out.println("mit welchem Treibstoff wird ihr Fahrzeug betriebn?");
        String userTreibstoff = stringAbfrage();

        System.out.println("Wie gross ist das Tankvolumen?");
        int userTankvolumen = intAbfrage();

        Auto User = new Auto(userMarke, userFarbe, userTreibstoff, userTankvolumen);

        Auto Mercedes = new Auto("Mercedes", "Schwarz", "Benzin", 100);
        Auto Audi = new Auto("Audi", "Rot", "Benzin", 89);
        Auto BMW = new Auto("BMW", "Blau", "Diesel", 96);

        Auto[] Autos = {User, Mercedes, Audi, BMW};


        autoMarke(Autos);
    }

        /*int Black = countBlack(Autos);
        System.out.println(Black + " Autos sind Schwarz");

    }
*/
    public static void autoMarke(Auto[] Autos){
        for (int i = 0; i < Autos.length; i++) {
            System.out.println(Autos[i].Marke);
        }
    }
/*
    public static int countBlack(Auto[] Autos){
         int counter = 0;
        for (int i = 0; i < Autos.length; i++){
            if(Autos[i].Farbe.equals("Schwarz")){
                counter++;
            }
        }
        return counter;
    }*/

    public static String stringAbfrage(){
        Scanner scanner = new Scanner(System.in);
        String Wert = scanner.nextLine();
        return Wert;
    }
    public static int intAbfrage(){
        Scanner scanner = new Scanner(System.in);
        int Wert = scanner.nextInt();
        return Wert;
    }
}
