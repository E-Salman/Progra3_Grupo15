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
    //O(n^2) + O(n log (n))
    public static boolean esExacto(int[] monedas, int vuelto){ 
        Arrays.sort(monedas);//n log (n)
        for (int i = monedas.length - 1; i >= 0; i--) { //n
            while(vuelto >= monedas[i]){ //n^2
                vuelto -= monedas[i];
            }
        }
        return vuelto == 0;
    }
}

/* 
 *                  PSEUDCODIGO 
 *  Funcion esExacto(monedas, vuelto)
 *      Ordenar de menor a mayor(monedas) 
 *      Para i de n a 0
 *          Mientras(vuelto >= monedas[i])
 *              vuelto <-- vuelto - monedas[i]
 *          Fin Mientras
 *      Fin Para
 *  Devolver (vuelto == 0)
*/