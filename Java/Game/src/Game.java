import java.util.*;

public class Game {

    // Menue function where the start menue is shown
    public static void Menue() {

        // show the menue
        int i = 1;
        while (i == 1) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to Zerus adventure");
            System.out.println("What do you wanna do?");
            System.out.println("1. New Game");
            System.out.println("2. Story / Introduction");
            System.out.println("3. Exit Application");
            System.out.print("-");

            // get user input
            String wMenu = scan.nextLine();

            // run the action which the use has chosen
            switch (wMenu) {
                case "1":
                    introduction();
                    i = 2;
                    break;
                case "2":
                    System.out.println("It is the year 2183 and humans have complete control over their solar system. \n Travel to the now human-friendly Mars and Venus is no longer a problem. Earth is now an empty shell of itself and no longer inhabitable. \n However, there is one big problem, the raw materials from Mars and Venus are running out faster than expected due to a new over population. \n You and a small team of researchers and scientists have made it your mission to explore the next most habitable planet (Homesteat III) to offer \n humans a possible new home. In the story you are the group leader and have to make important decisions for you and your group that lead to a goal.\n The fewer team members you lose, the higher the chance that you can defeat the final boss. Depending on the intelligence or strength you gain, \n you can create different endings.");
                    System.out.println("Your team consists of 2 team members who are considered to be your extra lives (i.e. if they die, your team member will intercept your death instead). Make sure you don't lose any of your team members, good luck");
                    System.out.println("You will find Weapons on your way these give you bonus Stats (Strenght");
                    break;
                case "3":
                    System.out.println("exit");
                    i = 0;
                    break;
                default:
                    System.out.println("Wrong Input Try Again");
                    break;
            }
        }
    }
    // function to create the traveler and his mates
    public static void introduction() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Whats your Name traveler:");
        String hName = scan.nextLine();
        System.out.println("Hello " + hName);
        System.out.println("Name your first Teammate");
        String t1name = scan.nextLine();
        System.out.println("Name your second Teammate");
        String t2name = scan.nextLine();
        System.out.println("You have successfully landed on the planet Zerus and must now explore the planet. How do you want to proceed? ");
        System.out.println("You see a small mountain to the north and a large forest on the other side. \n Which area do you want to go to?");


        Teammate t1 = new Teammate(t1name);
        Teammate t2 = new Teammate(t2name);

        Traveler traveler = new Traveler(hName);


        // call the Game function and deliver the traveler and his mates
        Game(traveler, t1, t2);
    }

    // function to set up the game
    public static void Game(Traveler traveler, Teammate t1, Teammate t2) {

        Items items = new Items();
        Mountain mountain = new Mountain();
        Forest forest = new Forest();

        int i = 1;
        while (i == 1) {
            System.out.println("1. Go to the Forest 2. Go to the Mountain");
            Scanner scan = new Scanner(System.in);
            String choose = scan.nextLine();

            // ask if the player wants to go to the forest or to the mountain
            if (choose.equals("1")) {
                forest(items, traveler, t1, t2, forest);
                i = 2;
            } else if (choose.equals("2")) {
                mountain(items, traveler, t1, t2, mountain);
                i = 2;
            } else {
                System.out.println("Wrong Input try again");
            }
        }
    }

    // function for the forest story
    public static void forest(Items items, Traveler traveler, Teammate t1, Teammate t2, Forest forest) {
        // create the enmies
        Enemy aTraveler = new Enemy("Traveler", 2);
        Enemy insect = new Enemy("Insect", 4);
        Scanner scan = new Scanner(System.in);
        System.out.println(forest.forestEx);
        items.gun[2]++;
        System.out.println(forest.forestReward);
        System.out.println("Strength: " + traveler.calcStrength(items));

        System.out.println(forest.forestTrav);
        int i = 1;
        while (i == 1) {

            System.out.println(forest.acceptQ);

            String Travquest = scan.nextLine();
            if (Travquest.equals("1")) {
                System.out.println(forest.seeDeer);
                aQuest(items, forest, insect, traveler, t1, t2);
                i = 2;
            } else if (Travquest.equals("2")) {
                System.out.println(forest.walking);
                String walkOrB = scan.nextLine();
                if (walkOrB.equals("1")) {
                    System.out.println("Youve decided to go back. After a long Walk you arrived at the startpoint");
                    Game(traveler, t1, t2);
                } else if (walkOrB.equals("2")) {
                    village(items, traveler, t1, t2);
                }
                village(items, traveler, t1, t2);
                i = 2;
            } else if (Travquest.equals("3")) {
                System.out.println(forest.decToKill);
                if (aTraveler.strength <= traveler.calcStrength(items)) {
                    System.out.println("You have Killed the Merchand");
                    items.controllWard[2]++;
                    System.out.println("Gain a Controll Ward");
                    System.out.println("Satus Strenght: " + traveler.calcStrength(items));
                    System.out.println("Status Intelligence: " + traveler.calcInteligence(items));
                    village(items, traveler, t1, t2);
                }
            } else if (aTraveler.strength > traveler.calcStrength(items)) {
                System.out.println("You found a Glitch cause this is Impossible");
            } else {
                System.out.println("Wrong input try again");
            }
        }
    }

    public static void aQuest(Items items, Forest forest, Enemy insect, Traveler traveler, Teammate t1, Teammate t2) {
        Random rand = new Random();

        int n = rand.nextInt(2);
        if (n == 1) {
            System.out.println(forest.travSuccessfull);
            su1Mission(items, forest, traveler, t1, t2);
        } else {
            System.out.println(forest.travUnsuccessfull);
            System.out.println("Strength of Insect " + insect.strength + " Strength");
            if (insect.strength > traveler.calcStrength(items)) {
                if (t1.liveChecker == 1) {
                    t1.liveChecker = 0;
                    System.out.println(t1.name + " Has Died");
                    System.out.println("You have 2 Lifes Left");
                } else if (t2.liveChecker == 1) {
                    t2.liveChecker = 0;
                    System.out.println(t2.name + " Has Died");
                    System.out.println("You only have 1 Life left");
                } else if (traveler.liveChecker == 1) {
                    System.out.println("Game Over");
                    Game game = new Game();
                    Game.Menue();
                } else if (insect.strength < traveler.calcStrength(items)) {
                    traveler.reward++;
                }
                village(items, traveler, t1, t2);
            }
        }
    }
    public static void su1Mission(Items items, Forest forest, Traveler traveler, Teammate t1, Teammate t2) {
        System.out.println(forest.missionreward);
        items.chickenWings[2]++;
        System.out.println("Strength = " + traveler.calcStrength(items));
        System.out.println("You've gained 2 Coins");
        traveler.reward += 2;
        village(items, traveler, t1, t2);
    }

    public static void village(Items items, Traveler traveler, Teammate t1, Teammate t2) {
        Village village = new Village();
        while (traveler.marketChecker == 1) {
            System.out.println(village.walkingToVillage);
            System.out.println(village.tradeConv);
            System.out.println("Hello " + traveler.hName);
            System.out.println("Do you wanna join the market? y/n");
            Scanner scan = new Scanner(System.in);
            String decMark = scan.nextLine();
            if (decMark.equals("y")) {
                traveler.marketChecker = 2;
                Market market = new Market();

                market.Market(traveler, items, t1, t2);

            } else if (decMark.equals("n")) {
                traveler.marketChecker = 2;
                System.out.println(village.endbossQ);
                System.out.println("Your Current Strength: " + traveler.calcStrength(items));
                System.out.println("Your Current Intelligence: " + traveler.calcInteligence(items));
                String decideEndboss = scan.nextLine();

                int i = 1;
                while (i == 1) {
                    if (decideEndboss.equals("y")) {
                        endboss(items, traveler, t1, t2);
                        i = 2;
                    } else if (decideEndboss.equals("n")) {
                        System.out.println(village.noHelp);
                        i = 2;
                        Menue();
                    } else {
                        System.out.println("Wrong Input");
                    }
                }

            } else {
                System.out.println("Wrong input");
            }
        }
    }

    public static void mountain(Items items, Traveler traveler, Teammate t1, Teammate t2, Mountain mountain) {
        Enemy bear = new Enemy("bear", 5);
        // Scanner scan = new Scanner(System.in);


        checkCave(traveler, t1, t2, mountain, items);

    }

    public static void cave(Items items, Traveler traveler, Teammate t1, Teammate t2, Mountain mountain) {

    }

    public static void endboss(Items items, Traveler traveler, Teammate t1, Teammate t2) {
        Scanner scan = new Scanner(System.in);
        Enemy dragon = new Enemy("dragon", 10);

        if (dragon.strength <= traveler.calcInteligence(items)) {
            System.out.println("You have Talked with the Dragon and after a long Discustion hes not Attaking the Village again.");

            System.out.println("Concrats youve Won");
            int i = 1;
            while (i == 1) {
                System.out.println("Wanna try again y/n");
                String tryagain = scan.nextLine();
                if (tryagain.equals("y")) {
                    i = 2;
                    Game game = new Game();
                    Game.Menue();
                } else if (tryagain.equals("n")) {
                    i = 2;
                } else {
                    System.out.println("Wrong Input");
                }
            }
        }
        else if (dragon.strength >= traveler.calcStrength(items)) {
            System.out.println("You tried to fight the Dragon but he was too Strong for you");
            System.out.println("Game Over");
            int i = 1;
            while (i == 1) {
                System.out.println("Wanna try again y/n");
                String tryagain = scan.nextLine();
                if (tryagain.equals("y")) {
                    i = 2;
                    Game game = new Game();
                    Game.Menue();
                } else if (tryagain.equals("n")) {
                    i = 2;
                } else {
                    System.out.println("Wrong Input");
                }
            }
        } else if (dragon.strength < traveler.calcStrength(items)) {

            System.out.println("After a long fight you Defeated the Mighty Dragon");
            int i = 1;
            while (i == 1) {
                System.out.println("Wanna try again y/n");
                String tryagain = scan.nextLine();
                if (tryagain.equals("y")) {
                    i = 2;
                    Game game = new Game();
                    Game.Menue();
                } else if (tryagain.equals("n")) {
                    i = 2;
                } else {
                    System.out.println("Wrong Input");
                }
            }
        }
    }
    public static void checkCave(Traveler traveler, Teammate t1, Teammate t2, Mountain mountain, Items items){
        System.out.println(mountain.approach);
        Scanner scan = new Scanner(System.in);
        String askCave = scan.nextLine();


            if (askCave.equals("1")) {
                System.out.println(mountain.caveGoIn);
                chooseCave(traveler, t1, t2, mountain, items);
            } else if (askCave.equals("2")) {

                System.out.println("You have Decided its the best to go Back");

                Game(traveler, t1, t2);
            } else {
                System.out.println("Wrong Input");
                checkCave(traveler, t1, t2, mountain, items);
            }
    }

    public static void chooseCave(Traveler traveler, Teammate t1, Teammate t2, Mountain mountain, Items items) {
        Scanner scan = new Scanner(System.in);
        System.out.println(mountain.caveChoose);
        String decide = scan.nextLine();
        int i = 1;
        while (i == 1){


            if (decide.equals("1")) {
                System.out.println("Youve found a bag of Gold and a torch");
                traveler.reward +=20;
                items.torch[2]++;
                System.out.println("Youve Gained a Torch");
                System.out.println("At the end of Cave you see a Village");
                village(items, traveler, t1, t2);
                System.out.println("Current Strength: "+ traveler.calcStrength(items));
                System.out.println("");
            } else if (decide.equals("2")) {
                System.out.println("You see a big black room, maybe there is hiding a secret");
                String secret = scan.nextLine();
                if (secret.equals("Ich mache ihm ein Angebot, das er nicht ablehnen kann")) {
                    System.out.println("Secret Ending");
                    Menue();
                }else {
                    System.out.println("a door opend");
                    village(items, traveler, t1, t2);
                }
            }
        }
    }
}