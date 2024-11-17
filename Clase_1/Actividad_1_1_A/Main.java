package Clase_1.Actividad_1_1_A;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Ingrese el tamanio del arreglo: ");
        int cantidad = scanner.nextInt();
        scanner.close();
        int[] arreglirijillo = new int[cantidad]; 
        Random rando = new Random(); 
    
        for (int i = 0; i < cantidad; i++) { //O(n)
            arreglirijillo[i] = rando.nextInt(100);
            System.out.println(arreglirijillo[i]);
        }
        System.out.println("The maximum number in the array is: " + maxArray(arreglirijillo));
    }

    public static int maxArray(int[] arreglo) {
        int max = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) { //O(n)
            if (arreglo[i] > max)
                max = arreglo[i];
        }
        return max;
    }
    //complejidad: O(2n)
    //hola mundo
}