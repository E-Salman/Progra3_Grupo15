package ejercicio4;
import java.util.ArrayList;
import java.util.List;

public class Actividad4 {

    public static List<Integer> nElementosMasGrandes(List<Integer> lista, int n) {
        if (lista.isEmpty() || n == 0) {
            return new ArrayList<>();
        }

        int pivote = lista.get(0);

        List<Integer> listaMayores = new ArrayList<>();
        List<Integer> listaMenores = new ArrayList<>();

        for (int elemento : lista) {
            if (elemento > pivote) {
                listaMayores.add(elemento);
            } else {
                listaMenores.add(elemento);
            }
        }

        if (listaMayores.size() == n) {
            return listaMayores;
        }

        if (listaMayores.size() > n) {
            return nElementosMasGrandes(listaMayores, n);
        }

        List<Integer> resultado = new ArrayList<>(listaMayores);
        resultado.addAll(nElementosMasGrandes(listaMenores, n - listaMayores.size()));
        return resultado;
    }

    public static void main(String[] args) {
        List<Integer> lista = List.of(10, 4, 5, 8, 6, 11, 26, 7);
        int n = 3;
        List<Integer> resultado = nElementosMasGrandes(lista, n);
        System.out.println("Los " + n + " elementos más grandes son: " + resultado);
    }
}
