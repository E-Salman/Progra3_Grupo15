package Actividad_2;

public class Main{

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);

        // Agregar aristas
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);

        // Verificar una arista
        System.out.println("¿Existe una arista de 0 a 2? " + grafo.verificarArista(0, 2));

        // Eliminar una arista
        grafo.eliminarArista(2, 3);
        System.out.println("¿Existe una arista de 2 a 3? " + grafo.verificarArista(2, 3));

        // Listar adyacentes de un vértice
        grafo.listarAdyacentes(0);
        grafo.listarAdyacentes(2);

        // Contar grado de entrada y salida
        System.out.println("Grado de salida de 0: " + grafo.gradoSalida(0));
        System.out.println("Grado de entrada de 2: " + grafo.gradoEntrada(2));

        // Mostrar la matriz de adyacencia
        grafo.mostrarMatrizAdyacencia();
    }
}