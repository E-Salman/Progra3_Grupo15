package Actividad_4;

import java.util.*;

public class Logistica {
    static class Carretera {
        int destino;
        int tiempo;

        public Carretera(int destino, int tiempo) {
            this.destino = destino;
            this.tiempo = tiempo;
        }
    }
    public static void dijkstra(Map<Integer, List<Carretera>> grafo, int centroPrincipal) {
        PriorityQueue<Carretera> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.tiempo));

        Map<Integer, Integer> tiemposMinimos = new HashMap<>();
        for (int nodo : grafo.keySet()) {
            tiemposMinimos.put(nodo, Integer.MAX_VALUE);
        }
        tiemposMinimos.put(centroPrincipal, 0);

        pq.add(new Carretera(centroPrincipal, 0));

        while (!pq.isEmpty()) {
            Carretera carreteraActual = pq.poll();

            int nodoActual = carreteraActual.destino;
            int tiempoActual = carreteraActual.tiempo;

            if (tiempoActual > tiemposMinimos.get(nodoActual)) {
                continue;
            }

            for (Carretera carretera : grafo.get(nodoActual)) {
                int tiempoNuevo = tiempoActual + carretera.tiempo;

                if (tiempoNuevo < tiemposMinimos.get(carretera.destino)) {
                    tiemposMinimos.put(carretera.destino, tiempoNuevo);
                    pq.add(new Carretera(carretera.destino, tiempoNuevo));
                }
            }
        }

        System.out.println("Tiempos mínimos de entrega desde el centro principal:");
        for (Map.Entry<Integer, Integer> entry : tiemposMinimos.entrySet()) {
            System.out.println("Centro de distribución " + entry.getKey() + " -> Tiempo de entrega: " + entry.getValue() + " minutos");
        }
    }
}