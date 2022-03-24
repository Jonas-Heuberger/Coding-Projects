package Lohnverwaltung;

import java.io.*;

public class FileHandler {
    public static void write(Object obj, String fileName){
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(obj);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error while writing: " + e);
        }
    }
}