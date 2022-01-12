import java.util.Scanner;

public class Item {

	int id;
	String Value1;
	String Value2;
	String Value3;

	public Item(int id, String Value1, String Value2, String Value3){
		this.id = id;
		System.out.println("Value 1");
		this.Value1 = abfrage();

		System.out.println("Value 2");
		this.Value2 = abfrage();

		System.out.println("Value 3");
		this.Value3 = abfrage();
	}

	private String abfrage(){
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		return s;
	}
	
}
