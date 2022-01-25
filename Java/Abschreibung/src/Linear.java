public class Linear extends Werte {

    public Linear(double betrag, double jahre){
        super.betrag = betrag;
        super.jahre = jahre;
    }

    double prozentsatz(double betrag, double jahre){
        return betrag / jahre;
    }

    void berechneLinear(double betrag, double jahre, double prozentsatz){
        for (int i = 1; i <= jahre; i++){
             betrag = betrag - prozentsatz;
            System.out.println("Linear Jahr " + i + ": " + betrag);
        }
    }
}
