public class main {
    public static void main(String[] args) {
        Katze cat = new Katze(4, "braun", "blau", "tiger", 40);
        cat.miauen("miau");
        Katze[] array = new Katze[1];
        array[0] = cat;
        System.out.println(array[0].alter);
        cat.springen(4);
        System.out.println(cat.alter);
        Hund dog = new Hund(4, 4, "braun", "braun", true);
        dog.showDog();
    }

}
