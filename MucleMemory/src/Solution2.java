/**
 * @Auther: songyunfeng
 * @Date: 2020/5/19 10:53
 * @Description:addTwoNums 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int sum = 0;
        int more = 0;
        ListNode pre = dummy;
        while (l1 != null || l2 != null || more > 0) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + more;
            more = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            pre.next = node;
            pre = node;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
}
