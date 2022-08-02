import java.util.Scanner;

public class Market {
    // item name and costs
    int gun = 2;
    int granades = 3;
    int chickenWings = 12;
    int shovel = 2;
    int torch = 2;
    int machineGun = 13;
    int controllWard = 5;
    int textBook = 4;

    // Market function to show the market items
    public void Market(Traveler traveler, Items items, Teammate t1, Teammate t2) {
        System.out.println("Du besitzt: " + traveler.reward);
        System.out.println("""
                1. Gun Cost: 2
                2. Granades Cost: 3
                3. Chicken Wings Cost: 12
                4. Shovel Cost: 2
                5. Torch Cost 2
                6. Machine Gun Cost: 13
                7. Controll Ward Cost: 5
                8. Text Book Cost: 4
                9. Exit Market

                """);

        // check with option the player has chosen
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        // call the right function
        switch (item) {
            case "1" -> buyGun(items, traveler, t1, t2);
            case "2" -> buyGranades(items, traveler, t1, t2);
            case "3" -> buyChickenWings(items, traveler, t1, t2);
            case "4" -> buyShovel(items, traveler, t1, t2);
            case "5" -> buyTorch(items, traveler, t1, t2);
            case "6" -> buyMachineGun(items, traveler, t1, t2);
            case "7" -> buyControllWard(items, traveler, t1, t2);
            case "8" -> buyTextBook(items, traveler, t1, t2);
            case "9" -> Exit(items, traveler, t1, t2);
            default -> Market(traveler, items, t1, t2); // if the input was wrong the Market function is called again
        }
    }

    // functions to buy items
    public void buyGun(Items items, Traveler traveler, Teammate t1, Teammate t2) {
        Market market = new Market();
        if (traveler.reward >= market.gun) {
            traveler.reward -= market.gun;
            items.gun[2] += 1;
            System.out.println("you have a new Gun");
        } else {
            System.out.println("You don't have enough coins to buy this gun");
        }
        Market(traveler, items, t1, t2);
    }

    public void buyGranades(Items items, Traveler traveler, Teammate t1, Teammate t2) {
        Market market = new Market();
        if (traveler.reward >= market.granades) {
            traveler.reward -= market.granades;
            items.granades[2] += 1;
            System.out.println("you have a new Granade");
        } else {
            System.out.println("You don't have enough coins to buy this Granade");
        }
        Market(traveler, items, t1, t2);
    }

    public void buyChickenWings(Items items, Traveler traveler, Teammate t1, Teammate t2) {
        Market market = new Market();
        if (traveler.reward >= market.chickenWings) {
            traveler.reward -= market.chickenWings;
            items.chickenWings[2] += 1;
            System.out.println("you have a new Chicken Wing");
        } else {
            System.out.println("You don't have enough coins to buy this Chicken Wing");
        }
        Market(traveler, items, t1, t2);
    }

    public void buyShovel(Items items, Traveler traveler, Teammate t1, Teammate t2) {
        Market market = new Market();
        if (traveler.reward >= market.shovel) {
            traveler.reward -= market.shovel;
            items.shovel[2] += 1;
            System.out.println("you have a new Shovel");
        } else {
            System.out.println("You don't have enough coins to buy this Shovel");
        }
        Market(traveler, items, t1, t2);
    }

    public void buyTorch(Items items, Traveler traveler, Teammate t1, Teammate t2) {
        Market market = new Market();
        if (traveler.reward >= market.torch) {
            traveler.reward -= market.torch;
            items.torch[2] += 1;
            System.out.println("you have a new Torch");
        } else {
            System.out.println("You don't have enough coins to buy this Torch");
        }
        Market(traveler, items, t1, t2);
    }

    public void buyMachineGun(Items items, Traveler traveler, Teammate t1, Teammate t2) {
        Market market = new Market();
        if (traveler.reward >= market.machineGun) {
            traveler.reward -= market.machineGun;
            items.machineGun[2] += 1;
            System.out.println("you have a new Machine Gun");
        } else {
            System.out.println("You don't have enough coins to buy this Machine Gun");
        }
        Market(traveler, items, t1, t2);
    }

    public void buyControllWard(Items items, Traveler traveler, Teammate t1, Teammate t2) {
        Market market = new Market();
        if (traveler.reward >= market.controllWard) {
            traveler.reward -= market.controllWard;
            items.controllWard[2] += 1;
            System.out.println("you have a new Controll Ward");
        } else {
            System.out.println("You don't have enough coins to buy this Controll Ward");
        }
        Market(traveler, items, t1, t2);
    }

    public void buyTextBook(Items items, Traveler traveler, Teammate t1, Teammate t2) {
        Market market = new Market();
        if (traveler.reward >= market.textBook) {
            traveler.reward -= market.textBook;
            items.textBook[2] += 1;
            System.out.println("you have a new Text Book");
        } else {
            System.out.println("You don't have enough coins to buy this Text Book");
        }
        Market(traveler, items, t1, t2);
    }

    // exit function which goes into the village function
    public void Exit(Items items, Traveler traveler, Teammate t1, Teammate t2) {
        Game game = new Game();
        game.village(items, traveler, t1, t2);
        System.out.println("Good Bye");
    }
}