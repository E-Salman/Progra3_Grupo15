package Clase_6.ejercicio4;

import java.util.Arrays;
import java.util.Comparator;

public class SeleccionPaquetesGreedy {

    public static void main(String[] args) {
        int[] costos = {12, 202, 15, 25};
        int[] ganancias = {150, 2030, 100, 300};
        int presupuesto = 35;

        int maxGanancia = maxGananciaGreedy(costos, ganancias, presupuesto);
        System.out.println("La ganancia máxima que se puede obtener es: " + maxGanancia);
    }

    public static int maxGananciaGreedy(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        double[][] paquetes = new double[n][3];

        // Crear un array que combine costos, ganancias y ratio (ganancia/costo)
        for (int i = 0; i < n; i++) {
            paquetes[i][0] = costos[i];
            paquetes[i][1] = ganancias[i];
            paquetes[i][2] = (double) ganancias[i] / costos[i];  // ratio ganancia/costo
        }

        // Ordenar los paquetes por mayor ratio ganancia/costo
        Arrays.sort(paquetes, Comparator.comparingDouble(o -> -o[2]));

        int gananciaTotal = 0;
        int costoTotal = 0;

        // Seleccionar los paquetes en base al ratio ganancia/costo
        for (int i = 0; i < n; i++) {
            int costoPaquete = (int) paquetes[i][0];
            int gananciaPaquete = (int) paquetes[i][1];

            if (costoTotal + costoPaquete <= presupuesto) {
                costoTotal += costoPaquete;
                gananciaTotal += gananciaPaquete;
            }
        }

        return gananciaTotal;
    }
}

