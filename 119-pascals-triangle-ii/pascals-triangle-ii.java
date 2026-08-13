import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        long current = 1;
        row.add((int) current);
        for (int i = 1; i <= rowIndex; i++) {
            current = current * (rowIndex - i + 1) / i;
            row.add((int) current);
        }
        return row;
    }
}
