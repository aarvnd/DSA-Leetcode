import java.util.*;

class Solution {
    public String smallestNumber(String num, long t) {
        long temp_t = t;
        int total_a = 0, total_b = 0, total_c = 0, total_d = 0;
        while (temp_t % 2 == 0) { total_a++; temp_t /= 2; }
        while (temp_t % 3 == 0) { total_b++; temp_t /= 3; }
        while (temp_t % 5 == 0) { total_c++; temp_t /= 5; }
        while (temp_t % 7 == 0) { total_d++; temp_t /= 7; }
        if (temp_t > 1) {
            return "-1";
        }

        int[][] dp = new int[65][45];
        for (int i = 0; i <= 60; i++) {
            for (int j = 0; j <= 40; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                int val = 100000;
                if (i > 0) {
                    val = Math.min(val, 1 + dp[Math.max(0, i - 3)][j]);
                    val = Math.min(val, 1 + dp[Math.max(0, i - 2)][j]);
                    val = Math.min(val, 1 + dp[Math.max(0, i - 1)][j]);
                }
                if (j > 0) {
                    val = Math.min(val, 1 + dp[i][Math.max(0, j - 2)]);
                    val = Math.min(val, 1 + dp[i][Math.max(0, j - 1)]);
                }
                if (i > 0 || j > 0) {
                    val = Math.min(val, 1 + dp[Math.max(0, i - 1)][Math.max(0, j - 1)]);
                }
                dp[i][j] = val;
            }
        }

        int[] f2 = {0, 0, 1, 0, 2, 0, 1, 0, 3, 0};
        int[] f3 = {0, 0, 0, 1, 0, 0, 1, 0, 0, 2};
        int[] f5 = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
        int[] f7 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};

        int n = num.length();
        int[] pref_a = new int[n + 1];
        int[] pref_b = new int[n + 1];
        int[] pref_c = new int[n + 1];
        int[] pref_d = new int[n + 1];

        int first_zero = n;
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (c == '0') {
                first_zero = i;
                break;
            }
            int d = c - '0';
            pref_a[i + 1] = pref_a[i] + f2[d];
            pref_b[i + 1] = pref_b[i] + f3[d];
            pref_c[i + 1] = pref_c[i] + f5[d];
            pref_d[i + 1] = pref_d[i] + f7[d];
        }

        if (first_zero == n &&
            pref_a[n] >= total_a &&
            pref_b[n] >= total_b &&
            pref_c[n] >= total_c &&
            pref_d[n] >= total_d) {
            return num;
        }

        int best_i = -1;
        int best_d = -1;

        for (int i = Math.min(n - 1, first_zero); i >= 0; i--) {
            int start_d = (i == first_zero) ? 1 : (num.charAt(i) - '0' + 1);
            boolean found = false;
            for (int d = start_d; d <= 9; d++) {
                int A = pref_a[i] + f2[d];
                int B = pref_b[i] + f3[d];
                int C = pref_c[i] + f5[d];
                int D = pref_d[i] + f7[d];

                int req_a = Math.max(0, total_a - A);
                int req_b = Math.max(0, total_b - B);
                int req_c = Math.max(0, total_c - C);
                int req_d = Math.max(0, total_d - D);

                int rem = n - 1 - i;
                if (req_c + req_d + dp[req_a][req_b] <= rem) {
                    best_i = i;
                    best_d = d;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (best_i != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(num, 0, best_i);
            sb.append(best_d);

            int cur_a = pref_a[best_i] + f2[best_d];
            int cur_b = pref_b[best_i] + f3[best_d];
            int cur_c = pref_c[best_i] + f5[best_d];
            int cur_d = pref_d[best_i] + f7[best_d];

            for (int pos = best_i + 1; pos < n; pos++) {
                int rem = n - 1 - pos;
                for (int g = 1; g <= 9; g++) {
                    int next_a = cur_a + f2[g];
                    int next_b = cur_b + f3[g];
                    int next_c = cur_c + f5[g];
                    int next_d = cur_d + f7[g];

                    int req_a = Math.max(0, total_a - next_a);
                    int req_b = Math.max(0, total_b - next_b);
                    int req_c = Math.max(0, total_c - next_c);
                    int req_d = Math.max(0, total_d - next_d);

                    if (req_c + req_d + dp[req_a][req_b] <= rem) {
                        sb.append(g);
                        cur_a = next_a;
                        cur_b = next_b;
                        cur_c = next_c;
                        cur_d = next_d;
                        break;
                    }
                }
            }
            return sb.toString();
        }

        int target_len = Math.max(n + 1, total_c + total_d + dp[total_a][total_b]);
        StringBuilder sb = new StringBuilder();
        int cur_a = 0, cur_b = 0, cur_c = 0, cur_d = 0;
        for (int pos = 0; pos < target_len; pos++) {
            int rem = target_len - 1 - pos;
            for (int g = 1; g <= 9; g++) {
                int next_a = cur_a + f2[g];
                int next_b = cur_b + f3[g];
                int next_c = cur_c + f5[g];
                int next_d = cur_d + f7[g];

                int req_a = Math.max(0, total_a - next_a);
                int req_b = Math.max(0, total_b - next_b);
                int req_c = Math.max(0, total_c - next_c);
                int req_d = Math.max(0, total_d - next_d);

                if (req_c + req_d + dp[req_a][req_b] <= rem) {
                    sb.append(g);
                    cur_a = next_a;
                    cur_b = next_b;
                    cur_c = next_c;
                    cur_d = next_d;
                    break;
                }
            }
        }
        return sb.toString();
    }
}
