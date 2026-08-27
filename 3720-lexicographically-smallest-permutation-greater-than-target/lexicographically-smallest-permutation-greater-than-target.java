import java.util.*;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] sCount = new int[26];
        for (int i = 0; i < n; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        int[][] pref = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                pref[i + 1][j] = pref[i][j];
            }
            pref[i + 1][target.charAt(i) - 'a']++;
        }

        for (int i = n - 1; i >= 0; i--) {
            boolean possible = true;
            for (int j = 0; j < 26; j++) {
                if (pref[i][j] > sCount[j]) {
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                continue;
            }

            int[] rem = new int[26];
            for (int j = 0; j < 26; j++) {
                rem[j] = sCount[j] - pref[i][j];
            }

            int targetChar = target.charAt(i) - 'a';
            int choice = -1;
            for (int j = targetChar + 1; j < 26; j++) {
                if (rem[j] > 0) {
                    choice = j;
                    break;
                }
            }

            if (choice != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.substring(0, i));
                sb.append((char) ('a' + choice));
                rem[choice]--;
                for (int j = 0; j < 26; j++) {
                    for (int k = 0; k < rem[j]; k++) {
                        sb.append((char) ('a' + j));
                    }
                }
                return sb.toString();
            }
        }

        return "";
    }
}
