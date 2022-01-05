public class Degressiv extends Werte {
    public Degressiv(double betrag, double jahre, double prozentsatz) {
        super.betrag = betrag;
        super.jahre = jahre;
        super.prozentsatz = prozentsatz;
    }

   void berechneDegressiv(double betrag, double jahre, double prozentsatz1){
       for (int i = 1; i <= jahre; i++) {

          double zwischenresultat = (betrag / 100) * prozentsatz1;
           betrag -= zwischenresultat;

           System.out.println("Degressiv Jahr " + i + ": " + betrag);
       }
    }
}
