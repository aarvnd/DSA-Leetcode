import java.util.*;

class Solution {
    public int subsequencePairCount(int[] nums) {
        int maxVal = 0;
        for (int x : nums) {
            if (x > maxVal) {
                maxVal = x;
            }
        }

        int[][] gcdTable = new int[maxVal + 1][maxVal + 1];
        for (int i = 0; i <= maxVal; i++) {
            for (int j = 0; j <= maxVal; j++) {
                gcdTable[i][j] = gcd(i, j);
            }
        }

        int MOD = 1_000_000_007;
        int[][] dp = new int[maxVal + 1][maxVal + 1];
        dp[0][0] = 1;

        int[][] nextDp = new int[maxVal + 1][maxVal + 1];

        for (int x : nums) {
            for (int i = 0; i <= maxVal; i++) {
                Arrays.fill(nextDp[i], 0);
            }

            for (int g1 = 0; g1 <= maxVal; g1++) {
                for (int g2 = 0; g2 <= maxVal; g2++) {
                    if (dp[g1][g2] == 0) continue;

                    int val = dp[g1][g2];

                    nextDp[g1][g2] += val;
                    if (nextDp[g1][g2] >= MOD) nextDp[g1][g2] -= MOD;

                    int ng1 = gcdTable[g1][x];
                    nextDp[ng1][g2] += val;
                    if (nextDp[ng1][g2] >= MOD) nextDp[ng1][g2] -= MOD;

                    int ng2 = gcdTable[g2][x];
                    nextDp[g1][ng2] += val;
                    if (nextDp[g1][ng2] >= MOD) nextDp[g1][ng2] -= MOD;
                }
            }

            int[][] temp = dp;
            dp = nextDp;
            nextDp = temp;
        }

        long ans = 0;
        for (int g = 1; g <= maxVal; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }

        return (int) ans;
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
