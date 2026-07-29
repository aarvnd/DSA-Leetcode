import java.util.*;

class Solution {
    public String smallestPalindrome(String s, int k) {
        int[][] C = new int[5005][22];
        for (int i = 0; i <= 5000; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= 21; j++) {
                if (j > i) {
                    C[i][j] = 0;
                } else {
                    long val = (long) C[i - 1][j - 1] + C[i - 1][j];
                    if (val > 1000001) {
                        C[i][j] = 1000001;
                    } else {
                        C[i][j] = (int) val;
                    }
                }
            }
        }

        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        int mid = -1;
        int[] H = new int[26];
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 != 0) {
                mid = i;
            }
            H[i] = counts[i] / 2;
        }

        long total = getPermutations(H, C);
        if (total < k) {
            return "";
        }

        int m = 0;
        for (int count : H) {
            m += count;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int c = 0; c < 26; c++) {
                if (H[c] > 0) {
                    H[c]--;
                    long ways = getPermutations(H, C);
                    if (k <= ways) {
                        sb.append((char) ('a' + c));
                        break;
                    } else {
                        k -= ways;
                        H[c]++;
                    }
                }
            }
        }

        String firstHalf = sb.toString();
        String middle = (mid != -1) ? String.valueOf((char) ('a' + mid)) : "";
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();
        return firstHalf + middle + secondHalf;
    }

    private long getPermutations(int[] A, int[][] C) {
        long V = 1;
        int S = 0;
        for (int count : A) {
            if (count > 0) {
                S += count;
                long comb = getComb(S, count, C);
                if (V > 1000001 || comb > 1000001) {
                    V = 1000001;
                } else {
                    V = V * comb;
                    if (V > 1000001) {
                        V = 1000001;
                    }
                }
            }
        }
        return V;
    }

    private long getComb(int n, int k, int[][] C) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        k = Math.min(k, n - k);
        if (k > 20) return 1000001;
        return C[n][k];
    }
}
