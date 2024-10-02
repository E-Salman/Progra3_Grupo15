package Actividad_4;

import java.util.*;

public class Logistica {
    // Clase para representar una arista en el grafo (tiempo de viaje entre dos centros de distribución)
    static class Carretera {
        int destino;
        int tiempo;

        public Carretera(int destino, int tiempo) {
            this.destino = destino;
            this.tiempo = tiempo;
        }
    }

    // Implementación del algoritmo de Dijkstra para calcular el tiempo mínimo desde el centro de distribución principal
    public static void dijkstra(Map<Integer, List<Carretera>> grafo, int centroPrincipal) {
        // Usamos una cola de prioridad para siempre seleccionar el nodo con menor tiempo de viaje
        PriorityQueue<Carretera> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.tiempo));

        // Mapa para almacenar el tiempo mínimo a cada nodo (centro de distribución)
        Map<Integer, Integer> tiemposMinimos = new HashMap<>();
        for (int nodo : grafo.keySet()) {
            tiemposMinimos.put(nodo, Integer.MAX_VALUE); // Inicialmente todos los tiempos son infinitos
        }
        tiemposMinimos.put(centroPrincipal, 0); // El tiempo mínimo al nodo fuente es 0

        // Comenzamos desde el centro de distribución principal
        pq.add(new Carretera(centroPrincipal, 0));

        // Mientras haya nodos por procesar
        while (!pq.isEmpty()) {
            Carretera carreteraActual = pq.poll(); // Nodo actual con el menor tiempo

            int nodoActual = carreteraActual.destino;
            int tiempoActual = carreteraActual.tiempo;

            // Si el tiempo actual es mayor al tiempo mínimo registrado, continuamos
            if (tiempoActual > tiemposMinimos.get(nodoActual)) {
                continue;
            }

            // Recorremos todos los nodos adyacentes
            for (Carretera carretera : grafo.get(nodoActual)) {
                int tiempoNuevo = tiempoActual + carretera.tiempo;

                // Si encontramos un tiempo de viaje más corto, actualizamos y añadimos a la cola
                if (tiempoNuevo < tiemposMinimos.get(carretera.destino)) {
                    tiemposMinimos.put(carretera.destino, tiempoNuevo);
                    pq.add(new Carretera(carretera.destino, tiempoNuevo));
                }
            }
        }

        // los tiempos mínimos de entrega desde el centro principal a todos los demás centros
        System.out.println("Tiempos mínimos de entrega desde el centro principal:");
        for (Map.Entry<Integer, Integer> entry : tiemposMinimos.entrySet()) {
            System.out.println("Centro de distribución " + entry.getKey() + " -> Tiempo de entrega: " + entry.getValue() + " minutos");
        }
    }
}