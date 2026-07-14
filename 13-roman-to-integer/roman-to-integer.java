import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int current = getValue(s.charAt(i));
            if (i + 1 < n) {
                int next = getValue(s.charAt(i + 1));
                if (current < next) {
                    ans -= current;
                } else {
                    ans += current;
                }
            } else {
                ans += current;
            }
        }
        return ans;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
