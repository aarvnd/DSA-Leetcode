import java.util.*;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int numOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                numOnes++;
            }
        }

        int[] B_start = new int[n + 2];
        int[] B_end = new int[n + 2];
        int[] B_size = new int[n + 2];
        int[] Z_start = new int[n + 2];
        int[] Z_end = new int[n + 2];
        int[] Z_size = new int[n + 2];

        int[] left_Z = new int[n + 2];
        int[] right_Z = new int[n + 2];

        int[] pos_to_B = new int[n];
        int[] pos_to_Z = new int[n];

        int k = 0;
        int m = 0;
        int idx = 0;
        while (idx < n) {
            int j = idx;
            while (j < n && s.charAt(j) == s.charAt(idx)) {
                j++;
            }
            int len = j - idx;
            if (s.charAt(idx) == '1') {
                k++;
                B_start[k] = idx;
                B_end[k] = j - 1;
                B_size[k] = len;
                for (int p = idx; p < j; p++) {
                    pos_to_B[p] = k;
                }
                left_Z[k] = m;
            } else {
                m++;
                Z_start[m] = idx;
                Z_end[m] = j - 1;
                Z_size[m] = len;
                for (int p = idx; p < j; p++) {
                    pos_to_Z[p] = m;
                }
                if (k > 0) {
                    right_Z[k] = m;
                }
            }
            idx = j;
        }

        int[] W = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            int lz = left_Z[i];
            int rz = right_Z[i];
            int l_sz = (lz > 0) ? Z_size[lz] : 0;
            int r_sz = (rz > 0) ? Z_size[rz] : 0;
            W[i] = l_sz + r_sz;
        }

        int LOG = 18;
        int[] logTable = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }

        int[] st_W = new int[LOG * (k + 1)];
        for (int i = 1; i <= k; i++) {
            st_W[i] = W[i];
        }
        for (int len = 1; len < LOG; len++) {
            int half = 1 << (len - 1);
            for (int i = 1; i + (1 << len) - 1 <= k; i++) {
                st_W[len * (k + 1) + i] = Math.max(st_W[(len - 1) * (k + 1) + i], st_W[(len - 1) * (k + 1) + i + half]);
            }
        }

        long[] st_Z = new long[LOG * (m + 1) * 3];
        for (int j = 1; j <= m; j++) {
            st_Z[j * 3] = ((long) Z_size[j] << 32) | j;
        }
        long[] tempZ = new long[3];
        for (int len = 1; len < LOG; len++) {
            int half = 1 << (len - 1);
            for (int j = 1; j + (1 << len) - 1 <= m; j++) {
                int offsetRes = (len * (m + 1) + j) * 3;
                int offsetA = ((len - 1) * (m + 1) + j) * 3;
                int offsetB = ((len - 1) * (m + 1) + j + half) * 3;
                mergeMax(st_Z, offsetA, st_Z, offsetB, tempZ, 3);
                System.arraycopy(tempZ, 0, st_Z, offsetRes, 3);
            }
        }

        long[] st_B = new long[LOG * (k + 1) * 5];
        for (int i = 1; i <= k; i++) {
            st_B[i * 5] = ((long) B_size[i] << 32) | i;
        }
        long[] tempB = new long[5];
        for (int len = 1; len < LOG; len++) {
            int half = 1 << (len - 1);
            for (int i = 1; i + (1 << len) - 1 <= k; i++) {
                int offsetRes = (len * (k + 1) + i) * 5;
                int offsetA = ((len - 1) * (k + 1) + i) * 5;
                int offsetB = ((len - 1) * (k + 1) + i + half) * 5;
                mergeMin(st_B, offsetA, st_B, offsetB, tempB, 5);
                System.arraycopy(tempB, 0, st_B, offsetRes, 5);
            }
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        long[] res_Z = new long[3];
        long[] res_B = new long[5];
        long[] top3 = new long[3];

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            int i_min = k + 1;
            int low = 1, high = k;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (B_start[mid] > l) {
                    i_min = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            int i_max = 0;
            low = 1;
            high = k;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (B_end[mid] < r) {
                    i_max = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (i_min > i_max) {
                ans.add(numOnes);
                continue;
            }

            int P_1 = 0;
            if (i_min == i_max) {
                P_1 = get_val(i_min, l, r, Z_start, Z_end, left_Z, right_Z);
            } else if (i_min + 1 == i_max) {
                P_1 = Math.max(get_val(i_min, l, r, Z_start, Z_end, left_Z, right_Z),
                               get_val(i_max, l, r, Z_start, Z_end, left_Z, right_Z));
            } else {
                P_1 = Math.max(get_val(i_min, l, r, Z_start, Z_end, left_Z, right_Z),
                               get_val(i_max, l, r, Z_start, Z_end, left_Z, right_Z));
                int q_l = i_min + 1;
                int q_r = i_max - 1;
                int len = logTable[q_r - q_l + 1];
                int max_W = Math.max(st_W[len * (k + 1) + q_l], st_W[len * (k + 1) + q_r - (1 << len) + 1]);
                P_1 = Math.max(P_1, max_W);
            }

            int j_min = m + 1;
            low = 1;
            high = m;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (Z_start[mid] >= l) {
                    j_min = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            int j_max = 0;
            low = 1;
            high = m;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (Z_end[mid] <= r) {
                    j_max = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            query_Z_flat(j_min, j_max, logTable, st_Z, m, res_Z);
            System.arraycopy(res_Z, 0, top3, 0, 3);

            int z_l = pos_to_Z[l];
            int z_r = pos_to_Z[r];

            if (z_l == z_r && z_l > 0) {
                long cand = ((long) (r - l + 1) << 32) | z_l;
                addCandidate(top3, cand);
            } else {
                if (z_l > 0 && Z_start[z_l] < l) {
                    long cand = ((long) (Z_end[z_l] - l + 1) << 32) | z_l;
                    addCandidate(top3, cand);
                }
                if (z_r > 0 && Z_end[z_r] > r) {
                    long cand = ((long) (r - Z_start[z_r] + 1) << 32) | z_r;
                    addCandidate(top3, cand);
                }
            }

            query_B_flat(i_min, i_max, logTable, st_B, k, res_B);

            int P_2 = -1000000000;
            for (int bi = 0; bi < 5; bi++) {
                long b_packed = res_B[bi];
                if (b_packed == 0) break;
                int i = (int) (b_packed & 0xFFFFFFFFL);
                int b_sz = B_size[i];
                for (int zj = 0; zj < 3; zj++) {
                    long z_packed = top3[zj];
                    if (z_packed == 0) break;
                    int j = (int) (z_packed & 0xFFFFFFFFL);
                    int z_sz = (int) (z_packed >>> 32);
                    if (j != i && j != i + 1) {
                        P_2 = Math.max(P_2, z_sz - b_sz);
                    }
                }
            }

            int maxGain = Math.max(P_1, P_2);
            ans.add(numOnes + maxGain);
        }

        return ans;
    }

    private int get_val(int i, int l, int r, int[] Z_start, int[] Z_end, int[] left_Z, int[] right_Z) {
        int lz = left_Z[i];
        int rz = right_Z[i];
        int left_len = (lz > 0) ? Z_end[lz] - Math.max(l, Z_start[lz]) + 1 : 0;
        int right_len = (rz > 0) ? Math.min(r, Z_end[rz]) - Z_start[rz] + 1 : 0;
        return left_len + right_len;
    }

    private void query_Z_flat(int j1, int j2, int[] logTable, long[] st_Z, int m, long[] res) {
        res[0] = res[1] = res[2] = 0;
        if (j1 > j2) return;
        int len = logTable[j2 - j1 + 1];
        int offsetA = (len * (m + 1) + j1) * 3;
        int offsetB = (len * (m + 1) + j2 - (1 << len) + 1) * 3;
        mergeMax(st_Z, offsetA, st_Z, offsetB, res, 3);
    }

    private void query_B_flat(int i1, int i2, int[] logTable, long[] st_B, int k_val, long[] res) {
        res[0] = res[1] = res[2] = res[3] = res[4] = 0;
        if (i1 > i2) return;
        int len = logTable[i2 - i1 + 1];
        int offsetA = (len * (k_val + 1) + i1) * 5;
        int offsetB = (len * (k_val + 1) + i2 - (1 << len) + 1) * 5;
        mergeMin(st_B, offsetA, st_B, offsetB, res, 5);
    }

    private void mergeMax(long[] A, int offA, long[] B, int offB, long[] res, int K) {
        int i = 0, j = 0, k = 0;
        while (k < K) {
            long va = (i < K) ? A[offA + i] : 0;
            long vb = (j < K) ? B[offB + j] : 0;
            if (va == 0 && vb == 0) break;
            long chosen;
            if (va >= vb) {
                chosen = va;
                i++;
            } else {
                chosen = vb;
                j++;
            }
            if (chosen == 0) continue;
            boolean dup = false;
            int chosen_idx = (int) (chosen & 0xFFFFFFFFL);
            for (int p = 0; p < k; p++) {
                if (((int) (res[p] & 0xFFFFFFFFL)) == chosen_idx) {
                    dup = true;
                    break;
                }
            }
            if (!dup) {
                res[k++] = chosen;
            }
        }
        while (k < K) {
            res[k++] = 0;
        }
    }

    private void mergeMin(long[] A, int offA, long[] B, int offB, long[] res, int K) {
        int i = 0, j = 0, k = 0;
        while (k < K) {
            long va = (i < K) ? A[offA + i] : 0;
            long vb = (j < K) ? B[offB + j] : 0;
            if (va == 0 && vb == 0) break;
            long chosen;
            if (va != 0 && (vb == 0 || va < vb)) {
                chosen = va;
                i++;
            } else {
                chosen = vb;
                j++;
            }
            if (chosen == 0) continue;
            boolean dup = false;
            int chosen_idx = (int) (chosen & 0xFFFFFFFFL);
            for (int p = 0; p < k; p++) {
                if (((int) (res[p] & 0xFFFFFFFFL)) == chosen_idx) {
                    dup = true;
                    break;
                }
            }
            if (!dup) {
                res[k++] = chosen;
            }
        }
        while (k < K) {
            res[k++] = 0;
        }
    }

    private void addCandidate(long[] top3, long cand) {
        if (cand == 0) return;
        for (int i = 0; i < 3; i++) {
            if (top3[i] == cand) return;
            if (cand > top3[i]) {
                for (int j = 2; j > i; j--) {
                    top3[j] = top3[j - 1];
                }
                top3[i] = cand;
                break;
            }
        }
    }
}
