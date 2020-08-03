import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class Solution215 {
    public int findKthLargeest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.peek();
    }
}
