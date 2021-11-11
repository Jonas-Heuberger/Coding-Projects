public class main {
    public static void main(String[] args) {
       int num = 50;
       int solArr[] = solveArr(num);
    }

    public static int[] solveArr(int num){
      int arr[] = {2, 5, 7, 15, 3, 4, 6};
      int solArr[] = new int[2];

      /*Your Code*/
      for(int i = 0; i < arr.length; i++){
        
        for(int j = i + 1; j < arr.length; j++ ){
          if (arr[i] + arr[j] == num) { // *, /, -
            solArr[0] = arr[i];
            solArr[1] = arr[j];
            System.out.println("The number " + solArr[0] + " and the number " + solArr[1] + " add up " + num);

          }

        }



      
      }

      



      return solArr;
    }
}

