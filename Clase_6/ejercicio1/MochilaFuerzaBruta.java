package Clase_6.ejercicio1;

public class MochilaFuerzaBruta {
    public static int[] bruteForceKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int maxBenefit = 0;
        int bestCombination = 0;

        for (int i = 0; i < (1 << n); i++) {
            int totalWeight = 0;
            int totalValue = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    totalWeight += weights[j];
                    totalValue += values[j];
                }
            }
            if (totalWeight <= capacity && totalValue > maxBenefit) {
                maxBenefit = totalValue;
                bestCombination = i;
            }
        }

        // Recuperar los objetos seleccionados
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if ((bestCombination & (1 << i)) > 0) {
                result[i] = 1; // seleccionados
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] weights = {3, 4, 2};
        int[] values = {4, 5, 3};
        int capacity = 6;
        
        int[] selectedItems = bruteForceKnapsack(weights, values, capacity);
        System.out.println("Objetos seleccionados (Fuerza Bruta):");
        for (int i = 0; i < selectedItems.length; i++) {
            if (selectedItems[i] == 1) {
                System.out.println("Objeto " + (i + 1));
            }
        }
    }
}