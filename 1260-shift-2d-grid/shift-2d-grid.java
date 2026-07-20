import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int currentIdx = i * n + j;
                int origIdx = (currentIdx - k + total) % total;
                int origR = origIdx / n;
                int origC = origIdx % n;
                row.add(grid[origR][origC]);
            }
            result.add(row);
        }
        return result;
    }
}
