package Mitarbeiterverwaltung;

import java.util.*;

public class Menu {

    protected LinkedHashMap<Character, MenuItem> items = new LinkedHashMap<Character, MenuItem>();

    public void addMenuItem(char key, String text, Menu.Funktion funct) {
        MenuItem item = new MenuItem(key, text, funct);
        items.put(item.key, item);
    }

    public Menu.Funktion getMenuItemFunktion(char key) {
        MenuItem item = items.get(key);
        return item.getFunktion();
    }

    public void anzeigen() {
        char auswahl = ' ';

        for (int i = 0; 50 > i; i++) {
            System.out.println();
        }

        System.out.println("M e n u e\n");

        items.forEach((key,value) -> System.out.println(value));

        System.out.println("\n0   Beenden\n");
        System.out.println("...Bitte wählen...");

        Scanner reader = new Scanner(System.in);
        auswahl = reader.next(".").charAt(0);

        if ('0' == auswahl) {
            return;
        }
        else {
            this.getMenuItemFunktion(auswahl).eval();

            System.out.println("...bitte Taste drücken...");
            new java.util.Scanner(System.in).nextLine();

            this.anzeigen();
        }


    }

    public interface Funktion {
        void eval();
    }

    private class MenuItem {
        protected char key;
        protected String text;
        protected Menu.Funktion funct;

        MenuItem() {
            this.key = '0';
            this.text = "";
            this.funct = null;
        }

        MenuItem(char key, String text, Menu.Funktion funct) {
            this.key = key;
            this.text = text;
            this.funct = funct;
        }

        public Menu.Funktion getFunktion() {
            return this.funct;
        }

        @Override
        public String toString() {
            return this.key + "   " + this.text;
        }
    }

}
