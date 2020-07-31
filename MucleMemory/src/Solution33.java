/**
 * @Description
 * @Author yunfeng
 * @Date 2020/7/31
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 算法时间复杂度必须是 O(log n) 级别
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1 || (target < nums[0] && target > nums[nums.length - 1])) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] >= nums[low]) {
                if (nums[mid] > target && nums[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }


        }
        return -1;
    }
}
