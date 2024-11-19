package Clase_12.Actividad_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GDFS {
    private List<List<Integer>> grafo;


    public GDFS(int numNodos) {
        grafo = new ArrayList<>();
        for (int i = 0; i < numNodos; i++) {
            grafo.add(new ArrayList<>());
        }
    }



    public void agregarArista(int orig, int dest) {
        grafo.get(orig).add(dest);
        grafo.get(dest).add(orig);
    }



    public void dfs(int nodoInicial) {
        Set<Integer> visitados = new HashSet<>();
        dfsRecursivo(nodoInicial, visitados);
    }


    private void dfsRecursivo(int nodo, Set<Integer> visitados) {
        visitados.add(nodo); 
        System.out.print(nodo + " ");


        for (int vecino : grafo.get(nodo)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados); 
            }
        }
    }
}