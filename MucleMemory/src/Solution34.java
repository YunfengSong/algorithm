/**
 * @Description
 * @Author yunfeng
 * @Date 2020/7/31
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target){
                high = mid - 1;
            } else {
                int left = mid;
                int right = mid;
                while (left >= low && nums[left] == target) {
                    left--;
                }
                while (right <= high && nums[right] == target) {
                    right ++;
                }
                return new int[]{left + 1, right - 1};
            }
            }
            return new int[]{-1 , -1};
        }
    }
