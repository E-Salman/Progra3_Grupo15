package Clase_6.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class SeleccionProyectosFuerzaBruta {

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        int maxBeneficio = maxBeneficioFuerzaBruta(costos, beneficios, presupuesto);
        System.out.println("El beneficio máximo que se puede obtener es: " + maxBeneficio);
    }

    // Función que encuentra el beneficio máximo usando fuerza bruta
    public static int maxBeneficioFuerzaBruta(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int maxBeneficio = 0;

        // Evaluamos todas las combinaciones posibles de proyectos
        for (int i = 0; i < (1 << n); i++) {  // Generar todas las combinaciones posibles de n proyectos
            int costoTotal = 0;
            int beneficioTotal = 0;
            List<Integer> seleccionados = new ArrayList<>();

            // Verificar qué proyectos están en la combinación actual
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {  // Si el bit j está activado, incluimos el proyecto j
                    costoTotal += costos[j];
                    beneficioTotal += beneficios[j];
                    seleccionados.add(j);
                }
            }

            // Si el costo total de los proyectos seleccionados no excede el presupuesto
            if (costoTotal <= presupuesto) {
                maxBeneficio = Math.max(maxBeneficio, beneficioTotal);
            }
        }

        return maxBeneficio;
    }
}

