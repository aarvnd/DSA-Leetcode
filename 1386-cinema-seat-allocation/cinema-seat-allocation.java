import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << col));
            }
        }

        int ans = 2 * n;
        int leftMask = 60;
        int rightMask = 960;
        int midMask = 240;

        for (int mask : map.values()) {
            ans -= 2;
            boolean leftFree = (mask & leftMask) == 0;
            boolean rightFree = (mask & rightMask) == 0;
            if (leftFree && rightFree) {
                ans += 2;
            } else if (leftFree || rightFree || (mask & midMask) == 0) {
                ans += 1;
            }
        }

        return ans;
    }
}
