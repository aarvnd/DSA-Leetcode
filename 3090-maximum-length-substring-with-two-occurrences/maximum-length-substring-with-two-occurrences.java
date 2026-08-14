import java.util.*;

class Solution {
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int left = 0;
        int maxLen = 0;
        int n = s.length();
        for (int right = 0; right < n; right++) {
            int charIdx = s.charAt(right) - 'a';
            count[charIdx]++;
            while (count[charIdx] > 2) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
