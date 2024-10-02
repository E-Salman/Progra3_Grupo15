package Clase_4.Actividad_3;

public class Articulo {
    double valor;
    double peso;
    
    public Articulo(double valor, double peso){
        this.peso = peso;
        this.valor = valor;
    }

    public double ratio(){
        return valor/peso;
    }

    public String toString(){
        return "Peso: " + peso + " Valor: " + valor;
    }
}
