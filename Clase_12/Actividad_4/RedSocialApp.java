package Clase_12.Actividad_4;

public class RedSocialApp {
    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();


        Usuario u1 = new Usuario(1, "Enzo");
        Usuario u2 = new Usuario(2, "Julian");
        Usuario u3 = new Usuario(3, "Claudio");
        Usuario u4 = new Usuario(4, "Franco");
        Usuario u5 = new Usuario(5, "Exequiel");


        redSocial.agregarUsuario(u1);
        redSocial.agregarUsuario(u2);
        redSocial.agregarUsuario(u3);
        redSocial.agregarUsuario(u4);
        redSocial.agregarUsuario(u5);


        redSocial.conectarUsuarios(1, 2); // Enzo <-> Julian
        redSocial.conectarUsuarios(1, 3); // Enzo <-> Claudio
        redSocial.conectarUsuarios(2, 4); // Julian <-> Franco
        redSocial.conectarUsuarios(3, 5); // Claudio <-> Exequiel


        redSocial.dfs(1); // Recorrido DFS desde Enzo
        redSocial.bfs(1); // Recorrido BFS desde Enzo
    }
}