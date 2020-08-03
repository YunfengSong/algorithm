/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = 1;
        int min = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            res = Math.max(max ,res);
        }
        return res;
    }
}
