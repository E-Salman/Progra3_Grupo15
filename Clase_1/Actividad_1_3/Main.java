package Clase_1.Actividad_1_3;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero para la suma recursiva: ");
        int numero = scanner.nextInt();
        System.out.println(sumaRecursiva(numero));
    }    
    
    //SUSTRACCION
    //a = 1
    //b = 1
    //k = 0
    //a = 1 ENTONCES --> O(n^(k + 1)) --> O(n)

    private static int sumaRecursiva(int i){
        if(i == 0){
            return 0;
        }
        return i + sumaRecursiva(i - 1);
    }
    
}