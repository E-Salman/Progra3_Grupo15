package Clase_12.Actividad_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Grafo {
    private Map<Integer, Almacen> almacenes; 
    private Map<Integer, List<Integer>> adyacencias;


    public Grafo() {
        almacenes = new HashMap<>();
        adyacencias = new HashMap<>();
    }


    public void agregarAlmacen(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
        adyacencias.putIfAbsent(almacen.getId(), new ArrayList<>());
    }


    public void conectarAlmacenes(int id1, int id2) {
        if (!almacenes.containsKey(id1) || !almacenes.containsKey(id2)) {
            System.out.println("Uno o ambos almacenes no existen.");
            return;
        }
        adyacencias.get(id1).add(id2);
        adyacencias.get(id2).add(id1); // Conexión bidireccional
    }


    public void dfs(int idInicial) {
        if (!almacenes.containsKey(idInicial)) {
            System.out.println("El almacén inicial no existe.");
            return;
        }
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS desde " + almacenes.get(idInicial).getNombre() + ":");
        dfsRecursivo(idInicial, visitados);
        System.out.println();
    }


    private void dfsRecursivo(int id, Set<Integer> visitados) {
        visitados.add(id);
        System.out.print(almacenes.get(id).getNombre() + " -> ");


        for (int vecino : adyacencias.get(id)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }


    public void bfs(int idInicial) {
        if (!almacenes.containsKey(idInicial)) {
            System.out.println("El almacén inicial no existe.");
            return;
        }
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        System.out.println("Recorrido BFS desde " + almacenes.get(idInicial).getNombre() + ":");


        cola.add(idInicial);
        visitados.add(idInicial);


        while (!cola.isEmpty()) {
            int id = cola.poll();
            System.out.print(almacenes.get(id).getNombre() + " -> ");


            for (int vecino : adyacencias.get(id)) {
                if (!visitados.contains(vecino)) {
                    cola.add(vecino);
                    visitados.add(vecino);
                }
            }
        }
        System.out.println();
    }
}