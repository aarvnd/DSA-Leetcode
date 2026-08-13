import java.util.*;

class Solution {
    private char[] prefChar;
    private int[] prefLen;
    private char[] suffChar;
    private int[] suffLen;
    private int[] maxLen;

    private void merge(int treeIdx, int leftIdx, int rightIdx, int leftSize, int rightSize) {
        prefChar[treeIdx] = prefChar[leftIdx];
        prefLen[treeIdx] = prefLen[leftIdx];
        if (prefLen[leftIdx] == leftSize && prefChar[leftIdx] == prefChar[rightIdx]) {
            prefLen[treeIdx] += prefLen[rightIdx];
        }

        suffChar[treeIdx] = suffChar[rightIdx];
        suffLen[treeIdx] = suffLen[rightIdx];
        if (suffLen[rightIdx] == rightSize && suffChar[rightIdx] == suffChar[leftIdx]) {
            suffLen[treeIdx] += suffLen[leftIdx];
        }

        maxLen[treeIdx] = Math.max(maxLen[leftIdx], maxLen[rightIdx]);
        if (suffChar[leftIdx] == prefChar[rightIdx]) {
            maxLen[treeIdx] = Math.max(maxLen[treeIdx], suffLen[leftIdx] + prefLen[rightIdx]);
        }
    }

    private void build(int treeIdx, int L, int R, char[] s) {
        if (L == R) {
            prefChar[treeIdx] = s[L];
            prefLen[treeIdx] = 1;
            suffChar[treeIdx] = s[L];
            suffLen[treeIdx] = 1;
            maxLen[treeIdx] = 1;
            return;
        }
        int mid = L + (R - L) / 2;
        build(2 * treeIdx, L, mid, s);
        build(2 * treeIdx + 1, mid + 1, R, s);
        merge(treeIdx, 2 * treeIdx, 2 * treeIdx + 1, mid - L + 1, R - mid);
    }

    private void update(int treeIdx, int L, int R, int idx, char val) {
        if (L == R) {
            prefChar[treeIdx] = val;
            suffChar[treeIdx] = val;
            return;
        }
        int mid = L + (R - L) / 2;
        if (idx <= mid) {
            update(2 * treeIdx, L, mid, idx, val);
        } else {
            update(2 * treeIdx + 1, mid + 1, R, idx, val);
        }
        merge(treeIdx, 2 * treeIdx, 2 * treeIdx + 1, mid - L + 1, R - mid);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int numQueries = queryIndices.length;
        char[] sArr = s.toCharArray();

        prefChar = new char[4 * n];
        prefLen = new int[4 * n];
        suffChar = new char[4 * n];
        suffLen = new int[4 * n];
        maxLen = new int[4 * n];

        build(1, 0, n - 1, sArr);

        int[] ans = new int[numQueries];
        for (int i = 0; i < numQueries; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = maxLen[1];
        }

        return ans;
    }
}
