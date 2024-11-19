package Clase_13;

import java.util.*;

public class Main {

    static class Viaje {
        String destino;
        int costo;

        Viaje(String destino, int costo) {
            this.destino = destino;
            this.costo = costo;
        }
    }

    public static void main(String[] args) {
        Map<String, List<Viaje>> grafo = new HashMap<>();
        agregarConexion(grafo, "Belgrano", "Villa Crespo", 100);
        agregarConexion(grafo, "Belgrano", "Caballito", 300);
        agregarConexion(grafo, "Villa Crespo", "Caballito", 50);
        agregarConexion(grafo, "Villa Crespo", "Villa Mitre", 200);
        agregarConexion(grafo, "Caballito", "Villa Mitre", 100);

        String origen = "Belgrano";
        String destino = "Villa Mitre";

        int costoMinimo = buscarCaminoUCS(grafo, origen, destino);

        if (costoMinimo != -1) {
            System.out.println("El costo mínimo desde " + origen + " hasta " + destino + " es: " + costoMinimo);
        } else {
            System.out.println("No existe un camino desde " + origen + " hasta " + destino);
        }
    }

    private static void agregarConexion(Map<String, List<Viaje>> grafo, String origen, String destino, int costo) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.get(origen).add(new Viaje(destino, costo));
    }

    private static int buscarCaminoUCS(Map<String, List<Viaje>> grafo, String origen, String destino) {
        PriorityQueue<Viaje> cola = new PriorityQueue<>(new Comparator<Viaje>() {
            @Override
            public int compare(Viaje n1, Viaje n2) {
                return n1.costo - n2.costo;
            }
        });

        Map<String, Integer> costos = new HashMap<>();
        Set<String> visitados = new HashSet<>();

        cola.add(new Viaje(origen, 0));
        costos.put(origen, 0);

        while (!cola.isEmpty()) {
            Viaje actual = cola.poll();

            if (visitados.contains(actual.destino)) continue;
            visitados.add(actual.destino);

            if (actual.destino.equals(destino)) {
                return actual.costo;
            }

            for (Viaje vecino : grafo.getOrDefault(actual.destino, new ArrayList<>())) {
                if (!visitados.contains(vecino.destino)) {
                    int nuevoCosto = actual.costo + vecino.costo;

                    if (nuevoCosto < costos.getOrDefault(vecino.destino, Integer.MAX_VALUE)) {
                        costos.put(vecino.destino, nuevoCosto);
                        cola.add(new Viaje(vecino.destino, nuevoCosto));
                    }
                }
            }
        }

        return -1;
    }
}
