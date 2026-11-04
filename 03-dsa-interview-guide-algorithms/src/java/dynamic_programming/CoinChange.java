package dynamic_programming;

import java.util.Arrays;

/**
 * LeetCode 322: Coin Change.
 * Fewest number of coins needed to make up a given amount.
 * Time: O(amount * len(coins)) | Space: O(amount)
 * 
 * @author CodeByTushu
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Min coins for " + amount + ": " + coinChange(coins, amount)); // Output: 3 (5+5+1)
    }
}
