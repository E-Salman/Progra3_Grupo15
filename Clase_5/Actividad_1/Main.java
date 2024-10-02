package Actividad_1;

import java.util.*;

class Usuario {
    String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}

class RedSocial {
    private Map<Usuario, Set<Usuario>> seguidores;

    public RedSocial() {
        this.seguidores = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        if (!seguidores.containsKey(usuario)) {
            seguidores.put(usuario, new HashSet<>());
            System.out.println("Usuario " + usuario.nombre + " agregado.");
        } else {
            System.out.println("El usuario " + usuario.nombre + " ya existe.");
        }
    }

    public void seguir(Usuario seguidor, Usuario seguido) {
        if (!seguidores.containsKey(seguidor) || !seguidores.containsKey(seguido)) {
            System.out.println("Uno o ambos usuarios no existen.");
            return;
        }
        if (seguidores.get(seguidor).contains(seguido)) {
            System.out.println(seguidor.nombre + " ya sigue a " + seguido.nombre);
        } else {
            seguidores.get(seguidor).add(seguido);
            System.out.println(seguidor.nombre + " ahora sigue a " + seguido.nombre);
        }
    }

    public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
        if (!seguidores.containsKey(seguidor) || !seguidores.containsKey(seguido)) {
            System.out.println("Uno o ambos usuarios no existen.");
            return;
        }
        if (seguidores.get(seguidor).contains(seguido)) {
            seguidores.get(seguidor).remove(seguido);
            System.out.println(seguidor.nombre + " dejó de seguir a " + seguido.nombre);
        } else {
            System.out.println(seguidor.nombre + " no sigue a " + seguido.nombre);
        }
    }

    public void listaDeSeguidos(Usuario usuario) {
        if (!seguidores.containsKey(usuario)) {
            System.out.println("El usuario no existe.");
            return;
        }
        Set<Usuario> seguidos = seguidores.get(usuario);
        System.out.println("Lista de usuarios que " + usuario.nombre + " sigue:");
        if (seguidos.isEmpty()) {
            System.out.println("No sigue a nadie.");
        } else {
            for (Usuario seguido : seguidos) {
                System.out.println(seguido.nombre);
            }
        }
    }

    public void listaDeSeguidores(Usuario usuario) {
        if (!seguidores.containsKey(usuario)) {
            System.out.println("El usuario no existe.");
            return;
        }
        System.out.println("Lista de seguidores de " + usuario.nombre + ":");
        boolean tieneSeguidores = false;
        for (Map.Entry<Usuario, Set<Usuario>> entry : seguidores.entrySet()) {
            if (entry.getValue().contains(usuario)) {
                System.out.println(entry.getKey().nombre);
                tieneSeguidores = true;
            }
        }
        if (!tieneSeguidores) {
            System.out.println("No tiene seguidores.");
        }
    }
}

public class Main { 
    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();

        Usuario juan = new Usuario("Juan");
        Usuario maria = new Usuario("Maria");
        Usuario pedro = new Usuario("Pedro");
        Usuario ana = new Usuario("Ana");

        redSocial.agregarUsuario(juan);
        redSocial.agregarUsuario(maria);
        redSocial.agregarUsuario(pedro);
        redSocial.agregarUsuario(ana);

        redSocial.seguir(juan, maria);
        redSocial.seguir(maria, pedro);
        redSocial.seguir(juan, ana);
        redSocial.seguir(pedro, ana);
        redSocial.seguir(maria, ana);

        redSocial.seguir(juan, ana);

        redSocial.dejarDeSeguir(juan, ana);
        redSocial.dejarDeSeguir(juan, ana); 

        redSocial.listaDeSeguidos(juan);
        redSocial.listaDeSeguidores(ana);
    }
}