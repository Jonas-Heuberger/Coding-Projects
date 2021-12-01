public class Hund {
    int alter;
    int grösse;
    String rasse;
    String farbe;
    boolean magKatzen;

    public Hund(int alter, int grösse, String rasse, String farbe, boolean magKatzen) {
        this.alter = alter;
        this.grösse = grösse;
        this.rasse = rasse;
        this.farbe = farbe;
        this.magKatzen = magKatzen;
    }
    void showDog(){
        System.out.println("""
                     __
                                        /  \\
                                       / ..|\\
                                      (_\\  |_)
                                      /  \\@'\s
                                     /     \\
                                _   /  `   |
                                \\\\/  \\  | _\\
                                 \\   /_ || \\\\_
                                  \\____)|_) \\_)
                """);
    }
}
