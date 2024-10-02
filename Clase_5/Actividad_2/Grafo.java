package Actividad_2;

public class Grafo {
    private int[][] matrizAdyacencia;
    private int numVertices;

    // Constructor: Inicializa el grafo con un número determinado de vértices
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    // Operación: Agregar Arista
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1;
            System.out.println("Arista agregada de " + origen + " a " + destino);
        } else {
            System.out.println("Índice de vértice no válido.");
        }
    }

    // Operación: Eliminar Arista
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 0;
            System.out.println("Arista eliminada de " + origen + " a " + destino);
        } else {
            System.out.println("Índice de vértice no válido.");
        }
    }

    // Operación: Verificar si existe una Arista
    public boolean verificarArista(int origen, int destino) {
        if (origen >= 0 && destino >= 0 && origen < numVertices && destino < numVertices) {
            return matrizAdyacencia[origen][destino] == 1;
        } else {
            System.out.println("Índice de vértice no válido.");
            return false;
        }
    }

    // Operación: Listar adyacentes a un vértice dado
    public void listarAdyacentes(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            System.out.print("Adyacentes de " + vertice + ": ");
            boolean tieneAdyacentes = false;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    System.out.print(i + " ");
                    tieneAdyacentes = true;
                }
            }
            if (!tieneAdyacentes) {
                System.out.print("Ninguno");
            }
            System.out.println();
        } else {
            System.out.println("Índice de vértice no válido.");
        }
    }

    // Operación: Contar el grado de salida de un vértice
    public int gradoSalida(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            int gradoSalida = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    gradoSalida++;
                }
            }
            return gradoSalida;
        } else {
            System.out.println("Índice de vértice no válido.");
            return -1;
        }
    }

    // Operación: Contar el grado de entrada de un vértice
    public int gradoEntrada(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            int gradoEntrada = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[i][vertice] == 1) {
                    gradoEntrada++;
                }
            }
            return gradoEntrada;
        } else {
            System.out.println("Índice de vértice no válido.");
            return -1;
        }
    }

    // Mostrar la matriz de adyacencia 
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }
}