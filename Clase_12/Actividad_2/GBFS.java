package Clase_12.Actividad_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GBFS {

    private List<List<Integer>> grafo;

    public GBFS(int numNodos) {
        grafo = new ArrayList<>();
        for (int i = 0; i < numNodos; i++) {
            grafo.add(new ArrayList<>());
        }
    }


    public void agregarArista(int orig, int dest) {
        grafo.get(orig).add(dest);
        grafo.get(dest).add(orig);
    }


    public void bfs(int nodoInicial) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();


        cola.add(nodoInicial);
        visitados.add(nodoInicial);


        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.print(nodo + " ");


            for (int vecino : grafo.get(nodo)) {
                if (!visitados.contains(vecino)) {
                    cola.add(vecino);
                    visitados.add(vecino);
                }
            }
        }
    }

    public static void main(String[] args) {
        GBFS grafo = new GBFS(9);


        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(3, 6);
        grafo.agregarArista(4, 7);
        grafo.agregarArista(4, 8);


        System.out.println("Recorrido BFS a partir del nodo 0:");
        grafo.bfs(0);
    }    
}
