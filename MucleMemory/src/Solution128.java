import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Solution128 {
    public int longestConsecetive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            map.put(num, 1 + map.getOrDefault(num + 1, 0));

            while (map.containsKey(num - 1)) {
                map.put(num - 1, map.get(num--) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }

}
