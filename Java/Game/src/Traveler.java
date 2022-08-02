public class Traveler {
    // attributes for the traveler
    String hName;
    int liveChecker = 1;
    int reward = 0;
    int marketChecker = 1;

    // constructor for the Traveler
    public Traveler(String hName) {
        this.hName = hName;
    }

    // function to calculate the strength
    public int calcStrength(Items items) {
        return (items.gun[1] * items.gun[2]) + (items.chickenWings[1] * items.chickenWings[2])
                + (items.controllWard[1] * items.controllWard[2]) + (items.machineGun[1] * items.machineGun[2])
                + (items.shovel[1] * items.shovel[2]) + (items.textBook[1] * items.textBook[2])
                + (items.granades[1] * items.granades[2]) + (items.torch[1] * items.torch[2]);
    }

    // function to calculate the inteligence
    public int calcInteligence(Items items) {
        return (items.gun[0] * items.gun[2]) + (items.chickenWings[0] * items.chickenWings[2])
                + (items.controllWard[0] * items.controllWard[2]) + (items.machineGun[0] * items.machineGun[2])
                + (items.shovel[0] * items.shovel[2]) + (items.textBook[0] * items.textBook[2])
                + (items.granades[0] * items.granades[2]) + (items.torch[0] * items.torch[2]);
    }

    // int travelerReward = traveler.coins(traveler);
    // System.out.println("you have " + travelerReward + " coins");
}
