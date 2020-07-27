import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: Yunfeng
 * @create: 2020-07-21
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 **/
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        for (ListNode list : lists) {
            if (lists != null) {
                priorityQueue.offer(list);
            }
        }

        while (!priorityQueue.isEmpty()) {
            pre.next = priorityQueue.poll();
            pre = pre.next;
            if (pre.next != null) {
                priorityQueue.offer(pre.next);
            }
        }
        return dummy.next;
    }
}
