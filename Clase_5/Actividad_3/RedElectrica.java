package Actividad_3;

import java.util.*;

public class RedElectrica {
    // Representación del grafo como una lista de adyacencia
    private Map<Integer, List<Arista>> grafo;

    public RedElectrica() {
        grafo = new HashMap<>();
    }

    class Arista {
        int destino, costo;

        public Arista(int destino, int costo) {
            this.destino = destino;
            this.costo = costo;
        }
    }

    public void agregarArista(int origen, int destino, int costo) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origen).add(new Arista(destino, costo));
        grafo.get(destino).add(new Arista(origen, costo));
    }

    public void algoritmoPrim(int estacionInicial) {

        PriorityQueue<Arista> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.costo));

        Set<Integer> visitados = new HashSet<>();
        int costoTotal = 0;

        pq.addAll(grafo.get(estacionInicial));
        visitados.add(estacionInicial);

        List<String> conexiones = new ArrayList<>();

        while (!pq.isEmpty()) {
            Arista aristaActual = pq.poll();

            if (visitados.contains(aristaActual.destino)) continue;

            visitados.add(aristaActual.destino);
            costoTotal += aristaActual.costo;
            conexiones.add("Estación " + estacionInicial + " -> Estación " + aristaActual.destino + " (Costo: " + aristaActual.costo + ")");

            for (Arista arista : grafo.get(aristaActual.destino)) {
                if (!visitados.contains(arista.destino)) {
                    pq.add(arista);
                }
            }
        }

        System.out.println("Conexiones seleccionadas en el Árbol de Recubrimiento Mínimo:");
        for (String conexion : conexiones) {
            System.out.println(conexion);
        }
        System.out.println("Costo total del MST: " + costoTotal);
    }
}