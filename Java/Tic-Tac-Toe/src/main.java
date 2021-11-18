public class main {
    public static void main(String[] args) {
        System.out.println(" 1 | 2 | 3\n" +
                " ---------\n" +
                " 4 | 5 | 6\n" +
                " ---------\n" +
                " 7 | 8 | 9");
        double Position = Game.Abfrage();

        if (Position == 1){
            Position = Grid.twoD_arr[0][0];
        }
        if (Position == 2){
            Position = Grid.twoD_arr[1][0];
        }
        if (Position == 3){
            Position = Grid.twoD_arr[2][0];
        }
        if (Position == 4){
            Position = Grid.twoD_arr[0][1];
        }
        if (Position == 5){
            Position = Grid.twoD_arr[1][1];
        }
        if (Position == 6){
            Position = Grid.twoD_arr[2][1];
        }
        if (Position == 7){
            Position = Grid.twoD_arr[0][2];
        }
        if (Position == 8){
            Position = Grid.twoD_arr[1][2];
        }
        if (Position == 9){
            Position = Grid.twoD_arr[2][2];
        }

    }
}
