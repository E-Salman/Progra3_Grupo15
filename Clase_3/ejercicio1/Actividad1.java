package ejercicio1;
class Cliente {
    int id;
    String nombre;
    int scoring;

    Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }
}

public class Actividad1 {

    public static Cliente encontrarMaximoCliente(Cliente[] clientes, int inicio, int fin) {
   
        if (inicio == fin) {
            return clientes[inicio];
        }

        int mitad = (inicio + fin) / 2;

        Cliente clienteIzq = encontrarMaximoCliente(clientes, inicio, mitad);

        Cliente clienteDer = encontrarMaximoCliente(clientes, mitad + 1, fin);

        if (clienteIzq.scoring >= clienteDer.scoring) {
            return clienteIzq;
        } else {
            return clienteDer;
        }
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente(1, "Cliente1", 85),
            new Cliente(2, "Cliente2", 90),
            new Cliente(3, "Cliente3", 78),
            new Cliente(4, "Cliente4", 95),
            new Cliente(5, "Cliente5", 88)
        };

        Cliente maxCliente = encontrarMaximoCliente(clientes, 0, clientes.length - 1);
        System.out.println("Cliente con el scoring máximo: " + maxCliente.nombre + " con un scoring de " + maxCliente.scoring);
    }
}