import java.util.*;

class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int val : stones) {
            sum += val;
        }
        int dp = sum;
        for (int i = n - 1; i > 1; i--) {
            sum -= stones[i];
            dp = Math.max(dp, sum - dp);
        }
        return dp;
    }
}
