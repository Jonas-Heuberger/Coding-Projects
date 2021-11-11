import java.util.Scanner;


public class main {

    public static void main(String[] args) {
        System.out.println("Enter a String ");
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		char[] arr = text.toCharArray();
		
		//your code goes here
		for(int i = arr.length - 1; i >= 0; i--){
			System.out.println(arr[i]);

		}
		
	}
    
}
