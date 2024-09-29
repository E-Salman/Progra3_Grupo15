import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        //comentario2
        int[] arreglillo = new int[5];
        Random rando = new Random();
        for(int i = 0; i < 5; i++){
            arreglillo[i] = rando.nextInt(100);
            System.out.println(arreglillo[i]);
        }
        System.out.println("The maximum number in the array is: " + maxArray(arreglillo));
    }

    public static int maxArray(int[] arreglo){
        int max = arreglo[0];        
        for(int i = 1; i < arreglo.length; i++){
            if(arreglo[i] > max) max = arreglo[i];
        }
        return max;
    }
}