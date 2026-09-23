class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(word1.charAt(i-1)== word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {     
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
        int lcs = dp [n][m];
        return (n-lcs) + (m-lcs);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna