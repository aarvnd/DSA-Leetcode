import java.util.*;

class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String current = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int len = current.length();
            for (int j = 0; j < len; ) {
                char c = current.charAt(j);
                int count = 0;
                while (j < len && current.charAt(j) == c) {
                    count++;
                    j++;
                }
                next.append(count).append(c);
            }
            current = next.toString();
        }
        return current;
    }
}
