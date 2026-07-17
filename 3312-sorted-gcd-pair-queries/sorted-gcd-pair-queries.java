import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

        long[] cnt = new long[maxVal + 1];
        for (int g = 1; g <= maxVal; g++) {
            long count = 0;
            for (int mult = g; mult <= maxVal; mult += g) {
                count += freq[mult];
            }
            cnt[g] = count * (count - 1) / 2;
        }

        for (int g = maxVal; g >= 1; g--) {
            for (int mult = 2 * g; mult <= maxVal; mult += g) {
                cnt[g] -= cnt[mult];
            }
        }

        for (int g = 1; g <= maxVal; g++) {
            cnt[g] += cnt[g - 1];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];
            int low = 1, high = maxVal;
            int res = maxVal;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (cnt[mid] > q) {
                    res = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            ans[i] = res;
        }

        return ans;
    }
}
