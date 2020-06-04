/**
 * @Auther: songyunfeng
 * @Date: 2020/5/20 12:02
 * @Description:findMedianSortedArrays nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = nums1.length;
        int halfLen = (nums1.length + nums2.length + 1) >> 1;

        while (left <= right) {
            int i = (left + right) >> 1;
            //TODO

        }
        return 0.0;
    }
}
