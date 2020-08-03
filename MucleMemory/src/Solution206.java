/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Solution206 {
    public ListNode reverselist(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }


    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverselist(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
