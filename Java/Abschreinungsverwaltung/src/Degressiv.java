public class Degressiv extends Anlage {

    double prozentsatz;

    public Degressiv(double betrag, int alter, int zeitspanne, double prozentsatz) {
        super(betrag, alter, zeitspanne);
        this.prozentsatz = prozentsatz;
    }

    public double degressiv(double betrag, int alter, double prozentsatz){
        for (int i = 0; i < alter; i++) {
            double abschreibungsBetrag = (betrag / 100) * prozentsatz;
            betrag = betrag - abschreibungsBetrag;
        }
        return betrag;
    }
}
