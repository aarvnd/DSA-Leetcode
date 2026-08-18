import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    int num = val - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    if (((rows[i] >> num) & 1) == 1 ||
                        ((cols[j] >> num) & 1) == 1 ||
                        ((boxes[boxIndex] >> num) & 1) == 1) {
                        return false;
                    }

                    rows[i] |= (1 << num);
                    cols[j] |= (1 << num);
                    boxes[boxIndex] |= (1 << num);
                }
            }
        }
        return true;
    }
}
