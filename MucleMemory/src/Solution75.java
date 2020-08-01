import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/1
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
    }
}
