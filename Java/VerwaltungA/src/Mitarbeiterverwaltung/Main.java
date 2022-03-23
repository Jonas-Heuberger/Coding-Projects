package Mitarbeiterverwaltung;

public class Main {
    public static void main(String[] args) {
        Verwaltung verwaltung = FileHandler.readAnlagen();
        UserInterface userInterface = new UserInterface(verwaltung);
        userInterface.start();

        FileHandler.safeAnlage(verwaltung);
    }
}
