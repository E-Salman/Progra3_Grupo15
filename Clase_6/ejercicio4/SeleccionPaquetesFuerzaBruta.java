package Clase_6.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class SeleccionPaquetesFuerzaBruta {

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 2010, 100, 300};
        int presupuesto = 35;

        int maxGanancia = maxGananciaFuerzaBruta(costos, ganancias, presupuesto);
        System.out.println("La ganancia maxima que se puede obtener es: " + maxGanancia);
    }

    // Fuerza bruta: Explora todas las combinaciones posibles de paquetes
    public static int maxGananciaFuerzaBruta(int[] costos, int[] ganancias, int presupuesto) {
        return helper(costos, ganancias, presupuesto, 0, 0, 0);
    }

    private static int helper(int[] costos, int[] ganancias, int presupuesto, int idx, int costoActual, int gananciaActual) {
        if (idx == costos.length) {
            return costoActual <= presupuesto ? gananciaActual : 0;
        }

        // No seleccionar el paquete actual
        int sinPaquete = helper(costos, ganancias, presupuesto, idx + 1, costoActual, gananciaActual);

        // Seleccionar el paquete actual (solo si no excede el presupuesto)
        int conPaquete = 0;
        if (costoActual + costos[idx] <= presupuesto) {
            conPaquete = helper(costos, ganancias, presupuesto, idx + 1, costoActual + costos[idx], gananciaActual + ganancias[idx]);
        }

        // Devolver la máxima ganancia posible
        return Math.max(sinPaquete, conPaquete);
    }
}

