package Ejercicio2;

public class Actividad2 {
    static int N = 4;

    public static boolean puedeEscritorio(int habitacion[][], int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (habitacion[fila][i] == 1) {
                return false;
            }
        }
        for (int i = 0; i < N; i++) {
            if (habitacion[i][col] == 1) {
                return false;
            }
        }
        return true;
    }


    public static boolean puedeSilla(int habitacion[][], int fila, int col) {

        for (int i = 0; i < N; i++) {
            if (habitacion[fila][i] == 2) {
                return false;
            }
        }

        for (int i = 0; i < N; i++) {
            if (habitacion[i][col] == 2) {
                return false;
            }
        }
        return true;
    }
    public static void resolverDisenoInteriores() {
        int[][] habitacion = new int[N][N]; // Crear un habitacion vacío
        poneEscritorios(habitacion, 0, 0); // Iniciar colocando los escritorios
    }


    public static boolean poneEscritorios(int[][] habitacion, int fila, int escritoriosPuestos) {
        if (escritoriosPuestos == 4) { // Si hemos colocado 4 escritorios, pasar a colocar sillas
            poneSillas(habitacion, 0, 0);
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (puedeEscritorio(habitacion, i, j)) {

                    habitacion[i][j] = 1;


                    poneEscritorios(habitacion, i + 1, escritoriosPuestos + 1);

                    habitacion[i][j] = 0;
                }
            }
        }

        return false;
    }

    public static boolean poneSillas(int[][] habitacion, int fila, int sillasPuestas) {
        if (sillasPuestas == 4) {
            imprimirhabitacion(habitacion);
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (puedeSilla(habitacion, i, j) && habitacion[i][j] == 0) {
                    habitacion[i][j] = 2;

                    poneSillas(habitacion, i + 1, sillasPuestas + 1);

                    // Backtrack: quitar silla
                    habitacion[i][j] = 0;
                }
            }
        }

        return false; // No hay solución válida en esta rama
    }

    public static void imprimirhabitacion(int[][] habitacion) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (habitacion[i][j] == 1) {
                    System.out.print("E ");
                } else if (habitacion[i][j] == 2) {
                    System.out.print("S ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        resolverDisenoInteriores();
    }
}
