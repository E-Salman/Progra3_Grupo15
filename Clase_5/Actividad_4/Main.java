package Actividad_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Actividad_4.Logistica.Carretera;

public class Main {
    
    public static void main(String[] args) {
        Map<Integer, List<Carretera>> grafo = new HashMap<>();

        grafo.putIfAbsent(0, new ArrayList<>());
        grafo.putIfAbsent(1, new ArrayList<>());
        grafo.putIfAbsent(2, new ArrayList<>());
        grafo.putIfAbsent(3, new ArrayList<>());
        grafo.putIfAbsent(4, new ArrayList<>());

        grafo.get(0).add(new Carretera(1, 10));
        grafo.get(0).add(new Carretera(2, 15));
        grafo.get(1).add(new Carretera(3, 12));
        grafo.get(2).add(new Carretera(4, 10));
        grafo.get(3).add(new Carretera(4, 2));
        grafo.get(3).add(new Carretera(2, 1));

        Logistica.dijkstra(grafo, 0);
    }

    
}
