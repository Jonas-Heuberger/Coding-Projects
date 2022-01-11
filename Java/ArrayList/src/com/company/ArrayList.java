package com.company;

import java.util.Scanner;


public class ArrayList {

    public static void main(String[] args) {
	// write your code here



        for (int i = 0; true; i++) {
            System.out.println("Auto " + i);
            String car = abfrage();

            java.util.ArrayList<String> cars = new java.util.ArrayList<>();
            OOP c = new OOP(car);

            System.out.println(cars + " " + i);
            System.out.println(cars.get(i));

            System.out.println(cars.contains("Mercedes"));

        }
    }

    static String abfrage(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }
}
