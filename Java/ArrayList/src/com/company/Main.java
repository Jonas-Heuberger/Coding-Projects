package com.company;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
	// write your code here


        int x = 1;
        for (int i = 0; i < x; i++) {
            System.out.println("Auto 1");
            String car1 = abfrage();

            System.out.println("Auto 2");
            String car2 = abfrage();

            System.out.println("Auto 3");
            String car3 = abfrage();

            ArrayList<String> cars = new ArrayList<String>();
            cars.add(car1);
            cars.add(car2);
            cars.add(car3);
            System.out.println(cars);
            System.out.println(cars.get(1));
            i--;
        }
    }

    static String abfrage(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }
}   
