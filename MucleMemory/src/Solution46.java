import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/1
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution46 {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return res;
        }

        visited = new boolean[nums.length];
        permute(0, nums, new ArrayList());
        return res;

    }

    private void permute(int index, int[] nums, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                permute(index + 1, nums, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }


}
