/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *输入: [1,3,4,2,2]
 * 输出: 2
 */
public class Solution283 {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            while (fast == slow) {
                slow = 0;
                while (nums[fast] != nums[slow]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
