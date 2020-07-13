/**
 * @author: Yunfeng
 * @create: 2020-07-12
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 滑动窗口法
 **/
public class Solution11 {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return  res;
    }
}
