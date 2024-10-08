package ejercicio3;
class Cliente {
    int id;
    String nombre;
    int scoring;

    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + '}';
    }
}

public class Avtividad3 {

    public static Cliente[] dosMaximos(Cliente[] clientes) {
        if (clientes.length == 1) {
            return new Cliente[] {clientes[0], new Cliente(-1, "Minimo", Integer.MIN_VALUE)};
        } else if (clientes.length == 2) {
            if (clientes[0].scoring > clientes[1].scoring) {
                return new Cliente[] {clientes[0], clientes[1]};
            } else {
                return new Cliente[] {clientes[1], clientes[0]};
            }
        }


        int mitad = clientes.length / 2;
        Cliente[] izquierda = dosMaximos(dividir(clientes, 0, mitad));
        Cliente[] derecha = dosMaximos(dividir(clientes, mitad, clientes.length));

        Cliente max1, max2;
        if (izquierda[0].scoring > derecha[0].scoring) {
            max1 = izquierda[0];
            max2 = izquierda[1].scoring > derecha[0].scoring ? izquierda[1] : derecha[0];
        } else {
            max1 = derecha[0];
            max2 = derecha[1].scoring > izquierda[0].scoring ? derecha[1] : izquierda[0];
        }

        return new Cliente[] {max1, max2};
    }


    private static Cliente[] dividir(Cliente[] clientes, int inicio, int fin) {
        Cliente[] resultado = new Cliente[fin - inicio];
        System.arraycopy(clientes, inicio, resultado, 0, fin - inicio);
        return resultado;
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente(1, "Cliente A", 50),
            new Cliente(2, "Cliente B", 20),
            new Cliente(3, "Cliente C", 70),
            new Cliente(4, "Cliente D", 90),
            new Cliente(5, "Cliente E", 23),
        };

        Cliente[] resultado = dosMaximos(clientes);
        System.out.println("Cliente con mayor scoring: " + resultado[0]);
        System.out.println("Cliente con segundo mayor scoring: " + resultado[1]);
    }
}