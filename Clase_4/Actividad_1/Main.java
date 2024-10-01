package Clase_4.Actividad_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] monedas = {10,5,15,25,1};
        int vuelto = 23;

        if(esExacto(monedas, vuelto)){
            System.out.println("El vuelto es exacto");
        }else{
            System.out.println("El vuelto no es exacto");
        }
        
    }
    
    public static boolean esExacto(int[] monedas, int vuelto){
        Arrays.sort(monedas);
        for (int i = monedas.length - 1; i >= 0; i--) {
            while(vuelto >= monedas[i]){
                vuelto -= monedas[i];
            }
        }
        return vuelto==0;

    }
}
