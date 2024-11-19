package Clase_12.Actividad_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class RedSocial {
    private Map<Integer, Usuario> usuarios; 
    private Map<Integer, List<Integer>> amistades; 


    public RedSocial() {
        usuarios = new HashMap<>();
        amistades = new HashMap<>();
    }


    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        amistades.putIfAbsent(usuario.getId(), new ArrayList<>());
    }


    public void conectarUsuarios(int id1, int id2) {
        if (!usuarios.containsKey(id1) || !usuarios.containsKey(id2)) {
            System.out.println("Uno o ambos usuarios no existen.");
            return;
        }
        amistades.get(id1).add(id2);
        amistades.get(id2).add(id1); 
    }


    public void dfs(int idInicial) {
        if (!usuarios.containsKey(idInicial)) {
            System.out.println("El usuario inicial no existe.");
            return;
        }
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS desde " + usuarios.get(idInicial).getNombre() + ":");
        dfsRecursivo(idInicial, visitados);
        System.out.println();
    }


    private void dfsRecursivo(int id, Set<Integer> visitados) {
        visitados.add(id);
        System.out.print(usuarios.get(id).getNombre() + " -> ");


        for (int amigo : amistades.get(id)) {
            if (!visitados.contains(amigo)) {
                dfsRecursivo(amigo, visitados);
            }
        }
    }


    public void bfs(int idInicial) {
        if (!usuarios.containsKey(idInicial)) {
            System.out.println("El usuario inicial no existe.");
            return;
        }
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        System.out.println("Recorrido BFS desde " + usuarios.get(idInicial).getNombre() + ":");


        cola.add(idInicial);
        visitados.add(idInicial);


        while (!cola.isEmpty()) {
            int id = cola.poll();
            System.out.print(usuarios.get(id).getNombre() + " -> ");


            for (int amigo : amistades.get(id)) {
                if (!visitados.contains(amigo)) {
                    cola.add(amigo);
                    visitados.add(amigo);
                }
            }
        }
        System.out.println();
    }
}
