package Clase_4.Actividad_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> comprobantes = new ArrayList<>();
        comprobantes.add(1000);
        comprobantes.add(500);
        comprobantes.add(100);
        comprobantes.add(50);
        comprobantes.add(10);
        comprobantes.add(5);
        comprobantes.add(1);

        int monto = 1550;

        System.out.println("Los comprobantes utilizados fueron: " + contarComprobantes(comprobantes, monto) );
    }
    //O(n^2) + O(n log (n))
    public static List<Integer> contarComprobantes(List<Integer>comprobantes, int monto){
        List<Integer> comprobantesUsados = new ArrayList<>();
        Collections.sort(comprobantes);

        for(int i = comprobantes.size() - 1; i >= 0; i-- ){
            while (monto >= comprobantes.get(i)){
            comprobantesUsados.add(comprobantes.get(i));
                monto-= comprobantes.get(i);

            }
        }
        return comprobantesUsados;
    }
    

}
