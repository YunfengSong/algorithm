import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/7/31
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Solution39 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        dfs(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int start, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                list.add(candidates[i]);
                dfs(candidates, i, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}
