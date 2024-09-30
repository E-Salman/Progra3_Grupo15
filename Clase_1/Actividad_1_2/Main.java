package Clase_1.Actividad_1_2;

import java.math.BigInteger;
//ejemplo de como se declaran los datos long y bigInt
public class Main{
    public static void main(String[] args) {
        long numeroLong = 34354656L;
        System.out.println("El tipo de dato long es: " + numeroLong);

        BigInteger numeroBig = new BigInteger("2432343245454354");
        System.out.println("El tipo de dato bigInteger es: " + numeroBig);
    }

}