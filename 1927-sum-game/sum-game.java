import java.util.*;

class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sL = 0, sR = 0;
        int qL = 0, qR = 0;
        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                qL++;
            } else {
                sL += c - '0';
            }
        }
        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                qR++;
            } else {
                sR += c - '0';
            }
        }
        if ((qL + qR) % 2 != 0) {
            return true;
        }
        return 2 * (sL - sR) != 9 * (qR - qL);
    }
}
