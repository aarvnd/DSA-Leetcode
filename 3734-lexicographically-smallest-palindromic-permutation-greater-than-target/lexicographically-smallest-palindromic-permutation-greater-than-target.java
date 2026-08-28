import java.util.*;

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                mid = (char) ('a' + i);
            }
        }

        if (oddCount > 1) return "";
        if (n % 2 == 0 && oddCount > 0) return "";
        if (n % 2 != 0 && oddCount != 1) return "";

        int m = n / 2;
        int[] M = new int[26];
        for (int i = 0; i < 26; i++) {
            M[i] = count[i] / 2;
        }

        for (int L = m; L >= 0; L--) {
            int[] req = new int[26];
            boolean possible = true;
            for (int i = 0; i < L; i++) {
                int c = target.charAt(i) - 'a';
                req[c]++;
                if (req[c] > M[c]) {
                    possible = false;
                    break;
                }
            }
            if (!possible) continue;

            int[] rem = new int[26];
            for (int i = 0; i < 26; i++) {
                rem[i] = M[i] - req[i];
            }

            if (L < m) {
                int targetChar = target.charAt(L) - 'a';
                int chosen = -1;
                for (int c = targetChar + 1; c < 26; c++) {
                    if (rem[c] > 0) {
                        chosen = c;
                        break;
                    }
                }
                if (chosen == -1) continue;

                StringBuilder sb = new StringBuilder();
                sb.append(target, 0, L);
                sb.append((char) ('a' + chosen));
                rem[chosen]--;
                for (int i = 0; i < 26; i++) {
                    while (rem[i] > 0) {
                        sb.append((char) ('a' + i));
                        rem[i]--;
                    }
                }
                String P = sb.toString();
                String revP = new StringBuilder(P).reverse().toString();
                if (n % 2 == 0) {
                    return P + revP;
                } else {
                    return P + mid + revP;
                }
            } else {
                String P = target.substring(0, m);
                String revP = new StringBuilder(P).reverse().toString();
                if (n % 2 == 0) {
                    if (revP.compareTo(target.substring(m)) > 0) {
                        return P + revP;
                    }
                } else {
                    char targetMid = target.charAt(m);
                    if (mid > targetMid) {
                        return P + mid + revP;
                    } else if (mid == targetMid) {
                        if (revP.compareTo(target.substring(m + 1)) > 0) {
                            return P + mid + revP;
                        }
                    }
                }
            }
        }

        return "";
    }
}
