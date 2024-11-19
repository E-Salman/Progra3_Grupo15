package Clase_12.Actividad_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RedAlmacenes {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();


        Almacen a1 = new Almacen(1, "Almacen Libertador");
        Almacen a2 = new Almacen(2, "Almacen Callao");
        Almacen a3 = new Almacen(3, "Almacen Figueroa Alcorta");
        Almacen a4 = new Almacen(4, "Almacen Cordoba");
        Almacen a5 = new Almacen(5, "Almacen Corrientes");


        grafo.agregarAlmacen(a1);
        grafo.agregarAlmacen(a2);
        grafo.agregarAlmacen(a3);
        grafo.agregarAlmacen(a4);
        grafo.agregarAlmacen(a5);


        grafo.conectarAlmacenes(1, 2);
        grafo.conectarAlmacenes(1, 3);
        grafo.conectarAlmacenes(2, 4);
        grafo.conectarAlmacenes(3, 5);


        grafo.dfs(1); 
        grafo.bfs(1); 
    }
}