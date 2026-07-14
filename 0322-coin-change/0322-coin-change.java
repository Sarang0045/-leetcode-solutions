class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        // Rows = coins
        // Columns = amounts
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= amount; j++) {

                // 0 coins are required to make amount 0
                if (j == 0) {
                    dp[i][j] = 0;
                }

                // No coins are available
                else if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE - 1;
                }

                // Current coin can be used
                else if (coins[i - 1] <= j) {

                    // Include the current coin
                    // 1 + value at (current amount - coin)
                    int include =
                            1 + dp[i][j - coins[i - 1]];

                    // Exclude the current coin
                    // Take the value from the upper row
                    int exclude =
                            dp[i - 1][j];

                    dp[i][j] =
                            Math.min(include, exclude);
                }

                // Current coin is greater than the amount
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Amount cannot be formed
        if (dp[n][amount] == Integer.MAX_VALUE - 1) {
            return -1;
        }

        // Minimum number of coins
        return dp[n][amount];
    }
}