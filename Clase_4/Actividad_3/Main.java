package Clase_4.Actividad_3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Articulo[] articulos = {new Articulo(38.00,5.00),
            new Articulo(10.00,8.00),
            new Articulo(22.00,6.50),
            new Articulo(26.00,30.00),
            new Articulo(7.00,30.00),
            new Articulo(236.00,41.00),
            new Articulo(777.00,4.90)};

        double w = 60;
        System.out.println("Los articulos agregados al camion: " + mochilaFraccional(articulos, w));
      }
    // O(n log n)
    public static List<Articulo> mochilaFraccional(Articulo[]articulos,double w){
        List<Articulo> articulosAgregados = new ArrayList<>();
        Arrays.sort(articulos, Comparator.comparingDouble(Articulo::ratio).reversed());

        for(Articulo articulo : articulos){
            if(w <= 0){
                break;
            }if(articulo.peso <= w){
                w -= articulo.peso;
                articulosAgregados.add(articulo);
            }else{
                articulosAgregados.add(articulo);
                w =0;            
            }
        }
        return articulosAgregados;
    } 
}
