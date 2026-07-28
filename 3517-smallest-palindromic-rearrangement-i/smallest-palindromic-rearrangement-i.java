import java.util.*;

class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                middle = (char) ('a' + i);
            }
            int halfCount = count[i] / 2;
            for (int j = 0; j < halfCount; j++) {
                firstHalf.append((char) ('a' + i));
            }
        }

        StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();
        if (middle != 0) {
            firstHalf.append(middle);
        }
        firstHalf.append(secondHalf);

        return firstHalf.toString();
    }
}
