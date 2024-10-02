package Actividad_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Actividad_4.Logistica.Carretera;

public class Main {
    
    public static void main(String[] args) {
        // Representación del grafo como una lista de adyacencia
        Map<Integer, List<Carretera>> grafo = new HashMap<>();

        // Agrega conexiones (carreteras) entre los centros de distribución
        grafo.putIfAbsent(0, new ArrayList<>());
        grafo.putIfAbsent(1, new ArrayList<>());
        grafo.putIfAbsent(2, new ArrayList<>());
        grafo.putIfAbsent(3, new ArrayList<>());
        grafo.putIfAbsent(4, new ArrayList<>());

        // Conexiones con tiempos de viaje (en minutos)
        grafo.get(0).add(new Carretera(1, 10)); // Carretera de centro 0 a 1 con tiempo de 10 minutos
        grafo.get(0).add(new Carretera(2, 15)); // Carretera de centro 0 a 2 con tiempo de 15 minutos
        grafo.get(1).add(new Carretera(3, 12)); // Carretera de centro 1 a 3 con tiempo de 12 minutos
        grafo.get(2).add(new Carretera(4, 10)); // Carretera de centro 2 a 4 con tiempo de 10 minutos
        grafo.get(3).add(new Carretera(4, 2));  // Carretera de centro 3 a 4 con tiempo de 2 minutos
        grafo.get(3).add(new Carretera(2, 1));  // Carretera de centro 3 a 2 con tiempo de 1 minuto

        // Aplica algoritmo de Dijkstra desde el centro de distribución principal (nodo 0)
        Logistica.dijkstra(grafo, 0);
    }

    
}
