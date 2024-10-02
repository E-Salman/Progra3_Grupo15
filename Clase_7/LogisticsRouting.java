package Clase_7;

import java.util.Scanner;

public class LogisticsRouting {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito

    // Variables de instancia para la matriz de distancias y la matriz de recuperación de caminos
    private int[][] dist;
    private int[][] P; // Matriz de recuperación de caminos

    public static void main(String[] args) {
        LogisticsRouting logistics = new LogisticsRouting();
        int graph[][] = { 
            {0, 10, INF, 30, 100},  // Centro 0
            {INF, 0, 50, INF, INF},  // Centro 1
            {INF, INF, 0, 20, 10},    // Centro 2
            {INF, INF, INF, 0, 60},   // Centro 3
            {INF, INF, INF, INF, 0}    // Centro 4
        };
        int V = graph.length;
        logistics.floydWarshall(graph, V);

        // Pedir vértices de origen y destino
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el centro de distribución de origen (0 a " + (V - 1) + "): ");
        int origen = sc.nextInt();
        System.out.print("Ingrese el centro de distribución de destino (0 a " + (V - 1) + "): ");
        int destino = sc.nextInt();

        // Imprimir el camino más corto entre el origen y el destino
        System.out.print("El camino más corto desde " + origen + " hasta " + destino + " es: ");
        logistics.imprimirCamino(origen, destino);
        sc.close();
    }

    // Algoritmo de Floyd-Warshall
    void floydWarshall(int graph[][], int V) {
        dist = new int[V][V];
        P = new int[V][V]; // Inicializamos la matriz P

        // Inicializar las matrices de distancias y recuperación de caminos
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (i != j && graph[i][j] != INF) {
                    P[i][j] = i; // Si hay un camino directo entre i y j, el antecesor es i
                } else {
                    P[i][j] = -1; // Si no hay camino, se inicializa como -1
                }
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        P[i][j] = P[k][j]; // Guardamos el vértice intermedio que permitió reducir la distancia
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist, V);
    }

    // Función para imprimir el camino más corto usando la matriz P
    void imprimirCamino(int origen, int destino) {
        if (P[origen][destino] == -1) {
            System.out.println("No hay camino entre " + origen + " y " + destino);
            return;
        }
        imprimirCaminoRecursivo(origen, destino);
        System.out.println(destino); // Finalmente imprimimos el destino
    }

    // Método recursivo para reconstruir el camino desde origen hasta destino
    void imprimirCaminoRecursivo(int origen, int destino) {
        if (P[origen][destino] == origen) {
            System.out.print(origen + " -> ");
            return;
        }
        imprimirCaminoRecursivo(origen, P[origen][destino]);
        System.out.print(P[origen][destino] + " -> ");
    }

    // Función para imprimir la matriz de distancias
    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de centros de distribución:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}



