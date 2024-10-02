public class Actividad2 {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int[] resultado = encontrarDosMayores(arr, 0, arr.length - 1);
        System.out.println("El mayor es: " + resultado[0]);
        System.out.println("El segundo mayor es: " + resultado[1]);
    }

    public static int[] encontrarDosMayores(int[] arr, int inicio, int fin) {
        if (fin - inicio == 1) {
            if (arr[inicio] > arr[fin]) {
                return new int[] { arr[inicio], arr[fin] };
            } else {
                return new int[] { arr[fin], arr[inicio] };
            }
        }
        if (fin - inicio == 0) {
            return new int[] { arr[inicio], Integer.MIN_VALUE };
        }

        int medio = (inicio + fin) / 2;
        int[] izquierda = encontrarDosMayores(arr, inicio, medio);
        int[] derecha = encontrarDosMayores(arr, medio + 1, fin);

        int mayor1 = Math.max(izquierda[0], derecha[0]);
        int mayor2;

        if (mayor1 == izquierda[0]) {
            mayor2 = Math.max(izquierda[1], derecha[0]);
        } else {
            mayor2 = Math.max(izquierda[0], derecha[1]);
        }

        return new int[] { mayor1, mayor2 };
    }
}