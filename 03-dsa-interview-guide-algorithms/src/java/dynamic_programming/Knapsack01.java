package dynamic_programming;

import java.util.Arrays;

/**
 * 0/1 Knapsack Problem.
 * Maximum value within weight capacity W.
 * Time: O(N * W) | Space: O(W) (Space-optimized 1D array)
 * 
 * @author CodeByTushu
 */
public class Knapsack01 {

    public static int knapSack(int capacity, int[] weights, int[] values, int n) {
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            // Traverse backwards to prevent using the same item twice
            for (int w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], values[i] + dp[w - weights[i]]);
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        int n = values.length;

        System.out.println("Maximum Profit: " + knapSack(capacity, weights, values, n));
    }
}
