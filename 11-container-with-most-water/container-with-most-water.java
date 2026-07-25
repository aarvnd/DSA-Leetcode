import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int hLeft = height[left];
            int hRight = height[right];
            int currentArea = Math.min(hLeft, hRight) * (right - left);
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }
            if (hLeft < hRight) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
