package com.company;

import java.util.Scanner;


public class ArrayList {

    public static void main(String[] args) {
	// write your code here


        int x = 1;
        while (true) {
            System.out.println("Auto 1");
            String car1 = abfrage();

            System.out.println("Auto 2");
            String car2 = abfrage();

            System.out.println("Auto 3");
            String car3 = abfrage();


            java.util.ArrayList<String> cars = new java.util.ArrayList<>();
            cars.add(car1);
            cars.add(car2);
            cars.add(car3);
            System.out.println(cars);
            System.out.println(cars.get(1));

            System.out.println(cars.contains("Mercedes"));

        }
    }

    static String abfrage(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }
}
