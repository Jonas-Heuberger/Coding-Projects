package Java.Parkhaus;

public class Parkhaus {

    //Erstellen von Parkplätzen
    Parkplatz pOne = new Parkplatz();
    Parkplatz pTwo = new Parkplatz();
    Parkplatz pTre = new Parkplatz();
    Parkplatz pFor = new Parkplatz();

    //Erstellen von Java.Parkhaus.Autos
    Autos cOne = new Autos();
    Autos cTwo = new Autos();
    Autos cTre = new Autos();
    Autos cFor = new Autos();

    int arrSize = 4;

    public Parkplatz[] parkplatzArray = new Parkplatz[arrSize];
    public Autos[] carArray = new Autos[arrSize];

    //Parkfelder zuteilen
    public void zuteilung(){
        pOne.parkSpotNumber = 1;
        cOne.carNumber = 1;
        pTwo.parkSpotNumber = 2;
        cTwo.carNumber = 2;
        pTre.parkSpotNumber = 3;
        cTre.carNumber = 3;
        pFor.parkSpotNumber = 4;
        cFor.carNumber = 4;

        parkplatzArray[0] = pOne;
        parkplatzArray[1] = pTwo;
        parkplatzArray[2] = pTre;
        parkplatzArray[3] = pFor;

        carArray[0] = cOne;
        carArray[1] = cTwo;
        carArray[2] = cTre;
        carArray[3] = cFor;
    }

    public void checkSpace(){
        for(int i = 0; i < carArray.length; i++){
            for(int j = parkplatzArray.length-1; j >= 0; j--){
                if (!parkplatzArray[j].hasCarOnIt){ //if no car on parking spot
                    carArray[i].parkSpot = parkplatzArray[j].parkSpotNumber; //car gets park sports number
                    carArray[i].parked = true; //car is parked
                    parkplatzArray[j].hasCarOnIt = carArray[i].parked; //park spot now has car on it
                    System.out.println("Car " + carArray[i].carNumber + " has parked on parkspot " + parkplatzArray[j].parkSpotNumber);
                    break;
                }
            }
        }
    }
}