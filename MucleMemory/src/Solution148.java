import javafx.scene.input.DataFormat;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode second = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(second));
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (first != null && second != null) {
            if (first.val > second.val) {
                pre.next = second;
                second = second.next;
            } else {
                pre.next = first;
                first = first.next;
            }
            pre = pre.next;
        }
        pre.next = first == null ? second : first;
        return dummy.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
