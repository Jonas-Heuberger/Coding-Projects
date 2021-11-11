import java.util.Scanner;

public class main {
	
    public static void main(String[] args) {
        System.out.println("Geben Sie eine Zahl ein");
		Scanner scanner = new Scanner(System.in);
		int amount = scanner.nextInt();
		//your code goes here
		amount = calculate(amount);
        printAmount(amount);
	}

	private static int calculate(int amount){
        for(int i = 0; i < 3; i++){
            amount = amount - (amount/100)*10;
        }
        return amount;
	}

    private static void printAmount(int amount){
        System.out.println(amount);
    }
}
