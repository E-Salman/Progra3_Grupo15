public class QuickSort {

    // Método para realizar el ordenamiento QuickSort
    public static void quickSort(int[] arreglo, int bajo, int alto) {
        if (bajo < alto) {
            // Encuentra el índice de partición
            int indiceParticion = particion(arreglo, bajo, alto);

            // Ordena los elementos antes y después de la partición
            quickSort(arreglo, bajo, indiceParticion - 1);
            quickSort(arreglo, indiceParticion + 1, alto);
        }
    }

    // Método para realizar la partición
    public static int particion(int[] arreglo, int bajo, int alto) {
        int pivote = arreglo[alto];  // Elegimos el último elemento como pivote
        int i = (bajo - 1);  // Índice del elemento más pequeño

        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual es menor o igual que el pivote
            if (arreglo[j] <= pivote) {
                i++;

                // Intercambia arreglo[i] y arreglo[j]
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        // Intercambia arreglo[i+1] y arreglo[alto] (o el pivote)
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[alto];
        arreglo[alto] = temp;

        return i + 1;  // Retorna el índice de partición
    }

    // Método principal para probar el QuickSort
    public static void main(String[] args) {
        int[] arrayDesordenado = {34, 7, 23, 32, 5, 62};

        System.out.println("Array desordenado:");
        for (int i : arrayDesordenado) {
            System.out.print(i + " ");
        }

        // Llamada al método quickSort
        quickSort(arrayDesordenado, 0, arrayDesordenado.length - 1);

        System.out.println("\nArray ordenado:");
        for (int i : arrayDesordenado) {
            System.out.print(i + " ");
        }
    }
}
