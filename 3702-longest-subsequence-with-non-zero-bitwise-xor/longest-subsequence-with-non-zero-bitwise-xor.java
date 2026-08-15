import java.util.*;

class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xorSum = 0;
        boolean hasNonZero = false;
        for (int num : nums) {
            xorSum ^= num;
            if (num != 0) {
                hasNonZero = true;
            }
        }
        if (xorSum != 0) {
            return n;
        }
        if (hasNonZero) {
            return n - 1;
        }
        return 0;
    }
}
