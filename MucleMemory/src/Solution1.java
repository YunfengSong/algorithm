import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: songyunfeng
 * @Date: 2020/5/19 09:53
 * @Description: two sum
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target-nums[i], i);
        }
        return null;
    }
}
