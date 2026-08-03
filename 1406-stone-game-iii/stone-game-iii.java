import java.util.*;

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[4];
        for (int i = n - 1; i >= 0; i--) {
            int maxVal = Integer.MIN_VALUE;
            int sum = 0;
            for (int k = 1; k <= 3 && i + k <= n; k++) {
                sum += stoneValue[i + k - 1];
                maxVal = Math.max(maxVal, sum - dp[(i + k) % 4]);
            }
            dp[i % 4] = maxVal;
        }
        int result = dp[0];
        if (result > 0) {
            return "Alice";
        } else if (result < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
