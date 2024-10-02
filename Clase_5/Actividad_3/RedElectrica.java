package Actividad_3;

import java.util.*;

public class RedElectrica {
    // Representación del grafo como una lista de adyacencia
    private Map<Integer, List<Arista>> grafo;

    public RedElectrica() {
        grafo = new HashMap<>();
    }

    // Clase Arista para representar una conexión con un costo
    class Arista {
        int destino, costo;

        public Arista(int destino, int costo) {
            this.destino = destino;
            this.costo = costo;
        }
    }

    // Agrega una arista (conexión) entre dos estaciones
    public void agregarArista(int origen, int destino, int costo) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origen).add(new Arista(destino, costo));
        grafo.get(destino).add(new Arista(origen, costo));  // Grafo no dirigido
    }

    // Algoritmo de Prim para encontrar el Árbol de Recubrimiento Mínimo
    public void algoritmoPrim(int estacionInicial) {
        // Cola de prioridad para seleccionar la arista de menor costo
        PriorityQueue<Arista> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.costo));

        // Conjunto para marcar las estaciones visitadas
        Set<Integer> visitados = new HashSet<>();
        int costoTotal = 0;

        // Inicializamos el algoritmo agregando las aristas desde la estación inicial
        pq.addAll(grafo.get(estacionInicial));
        visitados.add(estacionInicial);

        List<String> conexiones = new ArrayList<>();

        // Mientras tengamos aristas para procesar
        while (!pq.isEmpty()) {
            Arista aristaActual = pq.poll();

            // Si el destino de la arista ya fue visitado, continuamos
            if (visitados.contains(aristaActual.destino)) continue;

            // Marcamos la estación como visitada
            visitados.add(aristaActual.destino);
            costoTotal += aristaActual.costo;
            conexiones.add("Estación " + estacionInicial + " -> Estación " + aristaActual.destino + " (Costo: " + aristaActual.costo + ")");

            // Agregamos todas las aristas del nuevo nodo al conjunto
            for (Arista arista : grafo.get(aristaActual.destino)) {
                if (!visitados.contains(arista.destino)) {
                    pq.add(arista);
                }
            }
        }

        // Mostramos el conjunto de conexiones resultante y el costo total
        System.out.println("Conexiones seleccionadas en el Árbol de Recubrimiento Mínimo:");
        for (String conexion : conexiones) {
            System.out.println(conexion);
        }
        System.out.println("Costo total del MST: " + costoTotal);
    }
}