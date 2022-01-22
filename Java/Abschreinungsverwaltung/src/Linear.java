public class Linear extends Anlage{

    public Linear(double betrag, int alter, int zeitspanne) {
        super(betrag, alter, zeitspanne);
    }


    public double linear(double betrag, int alter, int zeitspanne){

       double jaehlicherAbzug = betrag / zeitspanne;

    for (int i = 0; i < alter; i++){
        betrag = betrag - jaehlicherAbzug;
    }
    return betrag;
}

}
