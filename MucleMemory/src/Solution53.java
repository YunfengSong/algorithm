/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/1
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }


        int res = 0;
        int max = 0;

        for (int num : nums) {
            max = Math.max(max + num, num);
            res = Math.max(res, max);
        }

        return res;

    }
}
