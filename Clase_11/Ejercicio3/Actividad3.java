package Ejercicio3;

public class Actividad3 {
    static int N = 4;
    static int[][] habitacion = new int[N][N];

    public static boolean puedo(int[][] habitacion, int fila, int col, int tipo) {
        for (int i = 0; i < N; i++) {
            if (habitacion[fila][i] == tipo || habitacion[i][col] == tipo) {
                return false;
            }
        }
        return true;
    }

    public static boolean ponerCI(int[][] habitacion, int fila, int tipo) {
        if (fila == N) {
            if (tipo == 1) { 
                return ponerCI
        (habitacion, 0, 2);
            }
            imprimirHabitacion(habitacion);
            return true;
        }

        boolean exito = false;
        for (int col = 0; col < N; col++) {
            if (puedo(habitacion, fila, col, tipo)) {
                habitacion[fila][col] = tipo;
                exito |= ponerCI
        (habitacion, fila + 1, tipo);
                habitacion[fila][col] = 0; 
            }
        }
        return exito;
    }

    public static void imprimirHabitacion(int[][] habitacion) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (habitacion[i][j] == 1) {
                    System.out.print("C "); 
                } else if (habitacion[i][j] == 2) {
                    System.out.print("I "); 
                } else {
                    System.out.print(". "); 
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ponerCI(habitacion, 0, 1); 
    }
}
