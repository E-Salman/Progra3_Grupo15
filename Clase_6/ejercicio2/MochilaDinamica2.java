package Clase_6.ejercicio2;

public class MochilaDinamica2 {
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
        int[] weights = {2, 5, 6, 7};
        int[] values = {4, 2, 1, 6};
        int capacity = 10;
        
        int[] selectedItems = dpKnapsack(weights, values, capacity);
        System.out.println("Objetos seleccionados (Programación Dinámica):");
        for (int i = 0; i < selectedItems.length; i++) {
            if (selectedItems[i] == 1) {
                System.out.println("Objeto " + (i + 1));
            }
        }
    }
}
