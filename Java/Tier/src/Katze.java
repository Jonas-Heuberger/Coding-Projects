public class Katze extends Tierverwaltung{
public Katze(String tierart, String name, String fellfarbe, String alter, String geschlecht,String gewicht, String geräusch){
    super (tierart, name, fellfarbe, alter, geschlecht, gewicht, geräusch);

}
void schnurren(){
    System.out.println("Katze schnurrt");
}
}
