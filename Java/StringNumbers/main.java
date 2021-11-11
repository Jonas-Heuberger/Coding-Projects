public class main {
    public static void main(String[] args) {
        spell(5);
    }


        public static void spell(int Zahl){ // erstellen der spell Methode
            switch (Zahl){ // erstellen eine switch statements welches den Wert der Zahl überprüft
                case 0:
                    System.out.println("This number is named:");
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("This number is named:");
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("This number is named:");
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("This number is named:");
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("This number is named:");
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("This number is named:");
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("This number is named:");
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("This number is named:");
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("This number is named:");
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("This number is named:");
                    System.out.println("Nine");
                    break;
                default:
                    System.out.println("This ain't a 1 digit number pal!");
                    break;
            }
        }
    }

