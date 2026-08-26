import java.util.*;

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                indices.add(i);
            }
        }

        if (indices.size() < k) {
            return "";
        }

        String best = null;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i <= indices.size() - k; i++) {
            int start = indices.get(i);
            int end = indices.get(i + k - 1);
            int len = end - start + 1;
            String sub = s.substring(start, end + 1);

            if (len < minLen) {
                minLen = len;
                best = sub;
            } else if (len == minLen) {
                if (best == null || sub.compareTo(best) < 0) {
                    best = sub;
                }
            }
        }

        return best == null ? "" : best;
    }
}
