import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m + 1];
        last[m] = n;
        int p = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }
            last[j] = p;
            if (p >= 0) {
                p--;
            }
        }

        int[] ans = new int[m];
        int j = 0;
        boolean changed = false;
        for (int i = 0; i < n && j < m; ) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
                i++;
            } else {
                if (!changed && last[j + 1] > i) {
                    ans[j] = i;
                    changed = true;
                    j++;
                    i++;
                } else {
                    i++;
                }
            }
        }

        if (j == m) {
            return ans;
        } else {
            return new int[0];
        }
    }
}
