/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 */
public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }


        int[] res = new int[nums.length];
        for (int i = 0, product = 1; i < nums.length; i++) {
            res[i] = product;
            product *= nums[i];
        }

        for (int i = nums.length - 1, product = 1; i >= 0; i--) {
            res[i] *= product;
            product *= nums[i];
        }
        return res;
    }
}
