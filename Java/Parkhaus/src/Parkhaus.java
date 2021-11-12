package Java.Parkhaus;
public class Parkhaus {
    Parkplatz pOne = new Parkplatz();
    Parkplatz pTwo = new Parkplatz();
    Parkplatz pTre= new Parkplatz();

    Autos cOne = new Autos();
    Autos cTwo = new Autos();
    Autos cTre = new Autos();


    public void zuteilung(){
      

      pOne.parkSpotNumber = 1;
      cOne.carNumber = 1;
      ptwo.parkSpotNumber = 2;
      cTwo.carNumber = 2;
      pTre.parkSpotNumber = 3;
      cTre.carNumber = 3;
    }

    public void checkSpace(){
      
    }
}
