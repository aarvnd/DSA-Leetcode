class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int n = cost.length;
       int[] dp = new int[n+1];
       dp[0] =0;
       dp[1] =0;
       for(int i = 2; i <=n; i++){
        dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
       }
       return dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna