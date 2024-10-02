package Clase_6.ejercicio1;

public class MochilaDinamica {
    public static int[] dpKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Recuperar los objetos seleccionados
        int[] selectedItems = new int[n];
        int w = capacity;
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedItems[i - 1] = 1;
                w -= weights[i - 1];
            }
        }

        return selectedItems;
    }

    public static void main(String[] args) {
        int[] weights = {3, 4, 2};
        int[] values = {4, 5, 3};
        int capacity = 6;
        
        int[] selectedItems = dpKnapsack(weights, values, capacity);
        System.out.println("Objetos seleccionados (Programación Dinámica):");
        for (int i = 0; i < selectedItems.length; i++) {
            if (selectedItems[i] == 1) {
                System.out.println("Objeto " + (i + 1));
            }
        }
    }
}
