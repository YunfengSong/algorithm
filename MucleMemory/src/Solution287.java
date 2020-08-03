/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Solution287 {
    public void moveZeros(int[] nums) {
        if (nums == null) {
            return;
        }

        int k = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[k++] = num;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
