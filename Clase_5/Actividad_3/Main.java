package Actividad_3;

public class Main {
    public static void main(String[] args) {
        RedElectrica red = new RedElectrica();

        red.agregarArista(0, 1, 10);
        red.agregarArista(0, 2, 6);
        red.agregarArista(0, 3, 5);
        red.agregarArista(1, 3, 15);
        red.agregarArista(2, 3, 4);

        red.algoritmoPrim(0);
    }
}
