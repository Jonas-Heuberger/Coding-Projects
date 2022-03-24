package Lohnverwaltung;

import java.io.Serializable;

abstract public class Worker implements Serializable {
    String firstname, lastname;
    double salary;

    public Worker (String firstname, String lastname, double salary){
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
    }
}
