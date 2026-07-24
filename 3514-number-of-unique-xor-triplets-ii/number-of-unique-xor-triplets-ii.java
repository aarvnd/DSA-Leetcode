import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] has = new boolean[1501];
        for (int num : nums) {
            has[num] = true;
        }
        int[] U = new int[1501];
        int uSize = 0;
        for (int i = 1; i <= 1500; i++) {
            if (has[i]) {
                U[uSize++] = i;
            }
        }
        boolean[] possible = new boolean[2048];
        for (int i = 0; i < uSize; i++) {
            possible[U[i]] = true;
        }
        long[] P = new long[32];
        int[] A = new int[uSize];
        int aSize = 0;
        for (int i = 0; i < uSize; i++) {
            int z = U[i];
            for (int j = 0; j < 32; j++) {
                long mask = P[j];
                if (mask != 0) {
                    int base = j << 6;
                    while (mask != 0) {
                        int bit = Long.numberOfTrailingZeros(mask);
                        int v = base + bit;
                        possible[z ^ v] = true;
                        mask &= mask - 1;
                    }
                }
            }
            for (int j = 0; j < aSize; j++) {
                int x = A[j];
                int v = z ^ x;
                P[v >>> 6] |= (1L << (v & 63));
            }
            A[aSize++] = z;
        }
        int count = 0;
        for (int i = 0; i < 2048; i++) {
            if (possible[i]) {
                count++;
            }
        }
        return count;
    }
}
