/**
 * @author: Yunfeng
 * @create: 2020-07-16
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 **/
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        while (l1 == null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

}
