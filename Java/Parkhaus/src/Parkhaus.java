package Java.Parkhaus;
public class Parkhaus {

    //Erstellen von Parkplätzen
    Parkplatz pOne = new Parkplatz();
    Parkplatz pTwo = new Parkplatz();
    Parkplatz pTre = new Parkplatz();

    //Erstellen von Autos
    Autos cOne = new Autos(); 
    Autos cTwo = new Autos();
    Autos cTre = new Autos();

    public Parkplatz parkplatzArray[] = new Parkplatz[3];
    public Autos carArray[] = new Autos[3];

//Parkfelder zuteilen
    public void zuteilung(){
      pOne.parkSpotNumber = 1;
      cOne.carNumber = 1;
      pTwo.parkSpotNumber = 2;
      cTwo.carNumber = 2;
      pTre.parkSpotNumber = 3;
      cTre.carNumber = 3;

      parkplatzArray[0] = pOne;
      parkplatzArray[1] = pTwo;
      parkplatzArray[2] = pTre;

      carArray[0] = cOne;
      carArray[1] = cTwo;
      carArray[2] = cTre;

      
    }

    public void checkSpace(){
      for(int i = 0; i < parkplatzArray.length; i++){
          if(carArray[i].parked = parkplatzArray[i].hasCarOnIt){
              carArray[i].parked = true;
              parkplatzArray[i].hasCarOnIt = true;
              carArray[i].parkSpot = parkplatzArray[i].parkSpotNumber;
          }

        System.out.println("Car " + carArray[i].carNumber + " has parked on parkspot " + cOne.parkSpot);
      }
    }
}
