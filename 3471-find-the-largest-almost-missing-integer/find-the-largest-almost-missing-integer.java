import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] counts = new int[51];

        for (int i = 0; i <= n - k; i++) {
            boolean[] present = new boolean[51];
            for (int j = i; j < i + k; j++) {
                present[nums[j]] = true;
            }
            for (int val = 0; val <= 50; val++) {
                if (present[val]) {
                    counts[val]++;
                }
            }
        }

        for (int val = 50; val >= 0; val--) {
            if (counts[val] == 1) {
                return val;
            }
        }

        return -1;
    }
}
