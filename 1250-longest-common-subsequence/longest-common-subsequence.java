class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(text1, text2, 0, 0);
    }
    private int fun(String s, String t, int i, int j) {
        if (i >= s.length() || j >= t.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int m = 0;
        if (s.charAt(i) == t.charAt(j)) {
            m = 1 + fun(s, t, i + 1, j + 1);
        } else {
            int a = fun(s, t, i + 1, j);
            int b = fun(s, t, i, j + 1);
            m = Math.max(a, b);
        }
        return dp[i][j] = m;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna