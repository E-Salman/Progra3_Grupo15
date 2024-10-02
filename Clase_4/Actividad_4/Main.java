package Clase_4.Actividad_4;

public class Main {
        public static void main(String[] args){
        System.out.println( getMinimumCost(3, new int[]{1, 3, 5, 7, 9}));

    }

    static int getMinimumCost(int k, int[] c) {
        int precioTotal = 0;
        int[] floresCompradas = new int[k];
        int contAmigos = 0;
        for(int i = c.length -1 ; i >= 0; i--){
            precioTotal += (floresCompradas[contAmigos] + 1) * c[i];
            floresCompradas[contAmigos] ++;
            contAmigos++;
            if(contAmigos == k){
                contAmigos = 0;
            }
        }
        return precioTotal;
    }
    
}
