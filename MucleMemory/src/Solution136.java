/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
