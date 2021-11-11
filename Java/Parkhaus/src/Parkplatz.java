package Java.Parkhaus;

public class Parkplatz {
    boolean hasCarOnIt = false;
    int parkSpotNumber = 0;

    public void checkIfhasCarOnIt(boolean isOnParkingField){
        if(isOnParkingField){
          hasCarOnIt = true;
        } else {
          hasCarOnIt = false;
        }
    }
}
