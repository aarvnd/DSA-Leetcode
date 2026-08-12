import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            count.put(val, count.getOrDefault(val, 0) + 1);
            while (count.get(val) > k) {
                count.put(nums[left], count.get(nums[left]) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
