package Lohnverwaltung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {

    public static List<OfficeWorker> officeWorkerList = new ArrayList<>();
    public static List<SalesRepresentative> salesRepresentativeList = new ArrayList<>();

    public static void userinterface(){
        System.out.println("""
                1: Mitarbeiter erstellen 
                2: Vertrag erstellen
                3: Mitarbeiter anzeigen
                4: Vertäge anzeigen
                5: Löhne anzeigen""");
        int query = queryInterger();

        switch (query){
            case 1 -> addWorker();
            case 2 -> createContract();
            case 3 -> showWorkers();
            case 4 -> showContracts();
            case 5 -> calculateSalaries();
            default -> {
                System.out.println("Ungültige Eingabe, bitte versuchen Sie es erneut");
                userinterface();
            }
        }
    }

    public static void addWorker(){
        System.out.println("""
                1: Innendienstmitarbeiter
                2: Aussendienstmitarbeiter""");
        
        int query = queryInterger();
        
        if (query == 1) {
            System.out.println("Vorname");
            String firstname = queryString();

            System.out.println("Nachname");
            String lastname = queryString();

            System.out.println("Lohn");
            double salary = queryDouble();
            OfficeWorker officeWorker = new OfficeWorker(firstname, lastname, salary);
            officeWorkerList.add(officeWorker);
            FileHandler.write(officeWorker, "file.jh");
        } else if (query == 2){
            System.out.println("Vorname");
            String firstname = queryString();

            System.out.println("Nachname");
            String lastname = queryString();

            System.out.println("Lohn");
            double salary = queryDouble();

            System.out.println("Provision");
            double commission = queryDouble();

            SalesRepresentative salesRepresentative = new SalesRepresentative(firstname, lastname, salary, commission);
            salesRepresentativeList.add(salesRepresentative);
            FileHandler.write(salesRepresentative, "file.jh");

        } else {
            System.out.println("Ungültige Eingabe, bitte versuchen Sie es erneut");
        }
        
        userinterface();
    }

    public static void createContract(){
        System.out.println("Welcher Mitarbeiter");
        int tempWorker = queryInterger();
        if (salesRepresentativeList.size() == 0){
            System.out.println("Bitte erstelle zuerst einen Aussendienstmitarbeiter");

        } else {
            if (tempWorker >= 1 || tempWorker <= salesRepresentativeList.size()){
                SalesRepresentative temp = salesRepresentativeList.get(tempWorker - 1);
                temp.addContract();
                FileHandler.write(temp, "file.jh");

            } else{
                System.out.println("Ungültige Eingabe, bitte versuchen Sie es nohcmal");
            }
        }
        userinterface();
    }

    public static void showWorkers(){
        for (OfficeWorker w: officeWorkerList) {
            System.out.println(w.firstname + " "+ w.lastname + " " + w.salary + "CHF");
        }

        for (SalesRepresentative s: salesRepresentativeList) {
            System.out.println(s.firstname + " " + s.lastname + " " + s.commission + "%" );

        }
        userinterface();
    }

    public static void showContracts(){
        int counter = 1;
        for (SalesRepresentative s: salesRepresentativeList) {
            System.out.println(s.lastname + ":");
            for (Contract c: s.contractList) {
                System.out.println("Lohnverwaltung.Contract "+ counter + ": " + c.companyName + " " + c.date + " " + c.volume);
            }
        }
        userinterface();
    }



    public static int queryInterger(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }

    public static String queryString(){
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.next();
        return txt;
    }
    
    public static double queryDouble(){
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        return num;
    }

    public static void calculateSalaries(){
        System.out.println("wie viel Monate");
      int months = queryInterger();

        for (OfficeWorker o: officeWorkerList) {
            System.out.println(o.firstname + ": " + o.salary * months);
        }
        for (SalesRepresentative s: salesRepresentativeList) {
            s.calculateEarnings(s.salary, s.commission);
            System.out.println(s.firstname + ": " + s.earnings * months);
        }
        userinterface();
    }

}
