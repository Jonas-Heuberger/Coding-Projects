package Lohnverwaltung;

import java.io.Serializable;
import java.util.Scanner;

public class Contract implements Serializable {
    String companyName, date;
    double volume;



     void getConctractInformation(){
        System.out.println("Firmenname");
         companyName = queryString();

        System.out.println("Datum");
         date = queryString();

        System.out.println("Verkaufspreis");
         volume = queryDouble();
    }

    public static String  queryString(){
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.next();
        return txt;
    }


    public static double queryDouble(){
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        return num;
    }
}
