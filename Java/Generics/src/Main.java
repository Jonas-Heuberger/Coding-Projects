public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4};
        Double[] doubleArray = {1.6, 4.8, 7.4};
        ausgeben(intArray);

    }
    public static <Type> void ausgeben(Type[] array){
        for (Type t : array) {
            System.out.println(t);
        }
    }
}
