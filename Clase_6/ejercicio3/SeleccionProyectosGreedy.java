package Clase_6.ejercicio3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class SeleccionProyectosGreedy {
    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;
        int maxBeneficio = maxBeneficioGreedy(costos, beneficios, presupuesto);
        System.out.println("El beneficio máximo que se puede obtener es: " + maxBeneficio);
    }
    public static int maxBeneficioGreedy(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        double[][] proyectos = new double[n][3];
        // Crear un array que combine costos, beneficios y ratio (beneficio/costo)
        for (int i = 0; i < n; i++) {
            proyectos[i][0] = costos[i];
            proyectos[i][1] = beneficios[i];
            proyectos[i][2] = (double) beneficios[i] / costos[i];  // ratio beneficio/costo
        }
        // Ordenar los proyectos por mayor ratio beneficio/costo
        Arrays.sort(proyectos, Comparator.comparingDouble(o -> -o[2]));
        int beneficioTotal = 0;
        int costoTotal = 0;
        List<Integer> proyectosSeleccionados = new ArrayList<>();
        // Seleccionar los proyectos en base al ratio beneficio/costo
        for (int i = 0; i < n; i++) {
            int costoProyecto = (int) proyectos[i][0];
            int beneficioProyecto = (int) proyectos[i][1];

            if (costoTotal + costoProyecto <= presupuesto) {
                costoTotal += costoProyecto;
                beneficioTotal += beneficioProyecto;
                proyectosSeleccionados.add(i);
            }
        }
        return beneficioTotal;
    }
}

