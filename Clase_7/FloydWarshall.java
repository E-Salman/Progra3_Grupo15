package Clase_7;

public class FloydWarshall {

    // Número de nodos
    final static int INF = 99999; // Un número grande para representar el infinito
    final static int N = 4; // Número de nodos

    // Método para ejecutar el algoritmo de Floyd-Warshall
    public static void floydWarshall(int grafo[][]) {
        int dist[][] = new int[N][N]; // Matriz para almacenar las distancias
        int i, j, k;

        // Inicializar la matriz de distancias igual que la matriz del grafo
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                dist[i][j] = grafo[i][j];
            }
        }

        // Algoritmo de Floyd-Warshall
        for (k = 0; k < N; k++) {
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    // Actualiza la distancia solo si el nodo intermedio mejora el camino
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz final de distancias
        printSolution(dist);
    }

    // Método para imprimir la matriz de distancias
    public static void printSolution(int dist[][]) {
        System.out.println("Matriz de las distancias más cortas entre todos los pares de nodos:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    // Método principal
    public static void main(String[] args) {
        /* Grafo de ejemplo
           1 → 2, peso 2
           2 → 4, peso 4
           1 → 4, peso 5
           4 → 3, peso 2
           Usamos una matriz de adyacencia para representar el grafo. 
           El valor INF indica que no hay conexión directa entre los nodos.
        */
        int grafo[][] = {
                {0, 2, INF, 5},  // Nodos conectados desde 1
                {INF, 0, INF, 4},  // Nodos conectados desde 2
                {INF, INF, 0, INF},  // Nodos conectados desde 3
                {INF, INF, 2, 0}   // Nodos conectados desde 4
        };

        // Ejecutar el algoritmo de Floyd-Warshall
        floydWarshall(grafo);
    }
}
