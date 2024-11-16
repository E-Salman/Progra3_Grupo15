package Ejercicio1;

public class Actividad1 {
    static int N = 4; // Tamaño del tablero (4x4)

    public static void main(String[] args) {
        int[][] tablero = new int[N][N]; // Crear un tablero vacío de 4x4
        colocarReinas(tablero, 0, 0, 0); // Llamar a la función para colocar las 2 reinas
    }

    // Función para colocar dos reinas en el tablero
    static void colocarReinas(int[][] tablero, int cantidadReinas, int fila, int columnasOcupadas) {
        // Si colocamos exactamente 2 reinas, imprimimos la configuración
        if (cantidadReinas == 2) {
            imprimirTablero(tablero); // Imprimir configuración válida
            return;
        }

        // Intentar colocar la reina en las siguientes filas (a partir de fila)
        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Verificar si la posición (i, j) es válida para colocar una reina
                if (((columnasOcupadas >> j) & 1) == 0 && segura(tablero, i, j)) {
                    tablero[i][j] = 1; // Colocar la reina en la posición (i, j)
                    colocarReinas(tablero, cantidadReinas + 1, i + 1, columnasOcupadas | (1 << j)); // Colocar la siguiente reina
                    tablero[i][j] = 0; // Deshacer la colocación (retroceder)
                }
            }
        }
    }

    // Función para verificar si es seguro colocar una reina en (i, j)
    static boolean segura(int[][] tablero, int i, int j) {
        // Verificar las diagonales
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < N; l++) {
                if (tablero[k][l] == 1) {
                    if (Math.abs(i - k) == Math.abs(j - l)) {
                        return false; // Las reinas están en la misma diagonal
                    }
                }
            }
        }
        return true;
    }

    // Función para imprimir el tablero
    static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("Q ");  // 'Q' representa la reina
                } else {
                    System.out.print("- ");  // '.' representa una casilla vacía
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
