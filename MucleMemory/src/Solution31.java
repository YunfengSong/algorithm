/**
 * @Description
 * @Author yunfeng
 * @Date 2020/7/18
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--) {

            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }
        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]){
                swap(nums, i, firstSmall);
                reverse(nums, firstSmall + 1, nums.length - 1);
                return;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

}
