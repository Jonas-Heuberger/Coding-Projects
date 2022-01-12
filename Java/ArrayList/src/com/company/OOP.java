package com.company;

import java.util.Scanner;

public class OOP {

String name;

public OOP() {
    System.out.println("Name");
    this.name = abfrage();
}
    static String abfrage(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }

}
