import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        int totalPushes = 0;
        for (int i = 0; i < 26; i++) {
            int f = freq[25 - i];
            if (f == 0) break;
            totalPushes += f * (i / 8 + 1);
        }
        return totalPushes;
    }
}
