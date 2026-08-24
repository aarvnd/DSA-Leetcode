import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, target, new ArrayList<>(), result, candidates);
        return result;
    }

    private void backtrack(int start, int target, List<Integer> current, List<List<Integer>> result, int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], current, result, candidates);
            current.remove(current.size() - 1);
        }
    }
}
