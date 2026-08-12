import java.util.*;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int quotient = 0;
        while (a <= b) {
            int temp_b = b;
            int temp_q = -1;
            while (temp_b >= -1073741824 && temp_b + temp_b >= a) {
                temp_b += temp_b;
                temp_q += temp_q;
            }
            a -= temp_b;
            quotient += temp_q;
        }

        return negative ? quotient : -quotient;
    }
}
