import java.util.Random;

public class Main {
    public static void main(String[] args){
        int[] arr = new int[5];
        Random rando = new Random();
        for(int i = 0; i < 5; i++){
            arr[i] = rando.nextInt(100);
            System.out.println(arr[i]);
        }
        System.out.println("The maximum number in the array is: " + maxArray(arr));
    }

    public static int maxArray(int[] arreglo){
        int max = arreglo[0];
        for(int i = 1; i < arreglo.length; i++){
            if(arreglo[i] > max) max = arreglo[i];
        }
        return max;
    }
}