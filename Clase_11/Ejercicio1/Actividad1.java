package Ejercicio1;

public class Actividad1 {
    static int N = 4; 

    public static void main(String[] args) {
        int[][] tablero = new int[N][N]; 
        colocarReinas(tablero, 0, 0, 0); 
    }

    static void colocarReinas(int[][] tablero, int cantidadReinas, int fila, int columnasOcupadas) {
        if (cantidadReinas == 2) {
            imprimirTablero(tablero);
            return;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (((columnasOcupadas >> j) & 1) == 0 && segura(tablero, i, j)) {
                    tablero[i][j] = 1;
                    colocarReinas(tablero, cantidadReinas + 1, i + 1, columnasOcupadas | (1 << j));
                    tablero[i][j] = 0;
                }
            }
        }
    }

    static boolean segura(int[][] tablero, int i, int j) {
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < N; l++) {
                if (tablero[k][l] == 1) {
                    if (Math.abs(i - k) == Math.abs(j - l)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
