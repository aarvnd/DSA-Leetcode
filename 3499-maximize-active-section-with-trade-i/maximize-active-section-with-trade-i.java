import java.util.*;

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int initialOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                initialOnes++;
            }
        }

        int[] A = new int[n + 2];
        int[] B = new int[n + 2];
        int aSize = 0;
        int bSize = 0;

        int currentLen = 1;
        char currentChar = '1';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == currentChar) {
                currentLen++;
            } else {
                if (currentChar == '1') {
                    A[aSize++] = currentLen;
                } else {
                    B[bSize++] = currentLen;
                }
                currentChar = c;
                currentLen = 1;
            }
        }
        if (currentChar == '1') {
            A[aSize++] = currentLen + 1;
        } else {
            B[bSize++] = currentLen;
            A[aSize++] = 1;
        }

        if (aSize < 3) {
            return initialOnes;
        }

        int k = bSize;
        int[] prefMax = new int[k];
        int[] suffMax = new int[k];

        prefMax[0] = B[0];
        for (int i = 1; i < k; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], B[i]);
        }

        suffMax[k - 1] = B[k - 1];
        for (int i = k - 2; i >= 0; i--) {
            suffMax[i] = Math.max(suffMax[i + 1], B[i]);
        }

        int maxChange = 0;
        for (int i = 1; i < k; i++) {
            int lenAi = A[i];
            int lenBi_minus_1 = B[i - 1];
            int lenBi = B[i];

            int opt1 = lenBi_minus_1 + lenBi;
            maxChange = Math.max(maxChange, opt1);

            int maxOtherB = 0;
            if (i - 2 >= 0) {
                maxOtherB = Math.max(maxOtherB, prefMax[i - 2]);
            }
            if (i + 1 < k) {
                maxOtherB = Math.max(maxOtherB, suffMax[i + 1]);
            }
            if (maxOtherB > 0) {
                int opt2 = maxOtherB - lenAi;
                maxChange = Math.max(maxChange, opt2);
            }
        }

        return initialOnes + maxChange;
    }
}
