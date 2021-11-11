public class main {
    public static void main(String[] args) {
     
     /*
        int arr[ ] = new int[3];
        for (int i = 2; i < 3; i++) {
        arr[i] = i;
}

int res = arr[0] + arr[2];
System.out.println(res);

*/

int result = 0;
for (int i = 0; i < 5; i++) {
  if (i == 3) { 
     result = result + 10;
   } else {
     result = result + i;
   }	
}
System.out.println(result);
    }
    
}
