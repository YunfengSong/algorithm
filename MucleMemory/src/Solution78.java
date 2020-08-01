import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/1
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Solution78 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }


        dfs(nums, 0, new ArrayList<>());
        return res;
    }


    private void dfs(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        dfs(nums, index + 1, list);
        list.add(nums[index]);
        dfs(nums, index + 1, list);
        list.add(list.size() - 1);

    }
}
