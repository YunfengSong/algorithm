/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int num : nums) {
            if (num == res) {
                count++;
            } else {
                if (count == 1) {
                    res = num;
                } else {
                    count--;
                }
            }
        }
        return res;
    }
}
