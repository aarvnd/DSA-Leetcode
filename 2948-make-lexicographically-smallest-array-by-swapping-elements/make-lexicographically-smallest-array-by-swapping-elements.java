import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];
        int start = 0;

        for (int i = 1; i <= n; i++) {
            if (i == n || pairs[i][0] - pairs[i - 1][0] > limit) {
                int len = i - start;
                int[] tempIndices = new int[len];
                for (int j = 0; j < len; j++) {
                    tempIndices[j] = pairs[start + j][1];
                }
                Arrays.sort(tempIndices);
                for (int j = 0; j < len; j++) {
                    result[tempIndices[j]] = pairs[start + j][0];
                }
                start = i;
            }
        }

        return result;
    }
}
