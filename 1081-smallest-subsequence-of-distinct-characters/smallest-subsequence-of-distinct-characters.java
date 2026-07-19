import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a']) {
                continue;
            }
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && last[sb.charAt(sb.length() - 1) - 'a'] > i) {
                seen[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            seen[c - 'a'] = true;
        }
        return sb.toString();
    }
}
