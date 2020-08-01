/**
 * @Description
 * @Author yunfeng
 * @Date 2020/7/31
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution42 {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return  0;
        }

        int low = 0;
        int high = height.length - 1;
        int res = 0;
        int lowMax = 0;
        int hightMax = 0;
        while (low < high) {
            if (height[low] < height[high]) {
                lowMax = Math.max(lowMax, height[low]);
                res += lowMax - height[low];
                low++;
            } else {
                hightMax = Math.max(hightMax, height[high]);
                res += hightMax - height[high];
                high--;
            }
        }
    return res;
    }
}
