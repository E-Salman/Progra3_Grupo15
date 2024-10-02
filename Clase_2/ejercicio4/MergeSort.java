package Clase_2.ejercicio4;
public class MergeSort {

    // Método principal que ordena el arreglo
    public static void mergeSort(int[] arreglo) {
        if (arreglo.length < 2) {
            return; // Si el arreglo tiene 0 o 1 elementos, ya está ordenado
        }
        int medio = arreglo.length / 2;

        // Dividir el arreglo en dos mitades
        int[] izquierda = new int[medio];
        int[] derecha = new int[arreglo.length - medio];

        // Copiar los elementos a las mitades
        for (int i = 0; i < medio; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = medio; i < arreglo.length; i++) {
            derecha[i - medio] = arreglo[i];
        }

        // Llamadas recursivas para ordenar las mitades
        mergeSort(izquierda);
        mergeSort(derecha);

        // Mezclar las mitades ordenadas
        merge(arreglo, izquierda, derecha);
    }

    // Método para mezclar dos subarreglos ordenados en un único arreglo
    public static void merge(int[] arreglo, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        // Comparar y mezclar los elementos de izquierda y derecha
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }

        // Copiar los elementos restantes de izquierda (si hay)
        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }

        // Copiar los elementos restantes de derecha (si hay)
        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }

    // Método principal para probar el MergeSort
    public static void main(String[] args) {
        int[] arrayDesordenado = {34, 7, 23, 32, 5, 62};

        System.out.println("Array desordenado:");
        for (int i : arrayDesordenado) {
            System.out.print(i + " ");
        }

        // Llamada al método mergeSort
        mergeSort(arrayDesordenado);

        System.out.println("\nArray ordenado:");
        for (int i : arrayDesordenado) {
            System.out.print(i + " ");
        }
    }
}

