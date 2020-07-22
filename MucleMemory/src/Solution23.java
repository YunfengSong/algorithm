import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Yunfeng
 * @create: 2020-07-21
 **/
public class Solution23 {
    public ListNode mergeLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        Queue<ListNode> minHep = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                minHep.offer(list);
            }
        }

        while (!minHep.isEmpty()) {
            pre.next = minHep.poll();
            pre = pre.next;
            if (pre.next != null) {
                minHep.offer(pre.next);
            }
        }

        return dummy.next;
    }
}
