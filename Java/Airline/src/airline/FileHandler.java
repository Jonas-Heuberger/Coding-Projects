package airline;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {
    private static String name = "anlagen.jh";

    public static void safeAnlage(Verwaltung verwaltung){
        try {
            FileOutputStream fos = new FileOutputStream(name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(verwaltung);
            oos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Verwaltung readAnlagen(){
        try {
            FileInputStream fis = new FileInputStream(name);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Verwaltung verwaltung = (Verwaltung) ois.readObject();
            ois.close();
            return verwaltung;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new Verwaltung();

    }
}
