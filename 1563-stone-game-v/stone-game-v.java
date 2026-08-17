import java.util.*;

class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];
        int[][] valL = new int[n][n];
        int[][] valR = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            valL[i][i] = sum[i + 1];
            valR[i][i] = -sum[i];
        }

        int[] mid = new int[n];
        for (int i = 0; i < n; i++) {
            mid[i] = i;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (2 * sum[i + 1] > sum[j + 1] + sum[i]) {
                    dp[i][j] = sum[j + 1] + valR[i + 1][j];
                } else {
                    while (mid[i] < j - 1 && 2 * sum[mid[i] + 2] <= sum[j + 1] + sum[i]) {
                        mid[i]++;
                    }
                    int m = mid[i];
                    if (2 * sum[m + 1] == sum[j + 1] + sum[i]) {
                        dp[i][j] = Math.max(valL[i][m] - sum[i], sum[j + 1] + valR[m + 1][j]);
                    } else {
                        dp[i][j] = valL[i][m] - sum[i];
                        if (m + 2 <= j) {
                            dp[i][j] = Math.max(dp[i][j], sum[j + 1] + valR[m + 2][j]);
                        }
                    }
                }
                valL[i][j] = Math.max(valL[i][j - 1], sum[j + 1] + dp[i][j]);
                valR[i][j] = Math.max(valR[i + 1][j], dp[i][j] - sum[i]);
            }
        }

        return dp[0][n - 1];
    }
}
