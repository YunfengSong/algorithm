/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 * 输入: 1->2->2->1
 * 输出: true
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            ListNode secHead = slow.next;
            slow.next = null;
            while (secHead != null) {
                ListNode next = secHead.next;
                secHead.next = slow.next;
                secHead = next;
            }
            secHead = slow.next;
            slow.next = null;
            slow = head;

            while (slow != null && secHead != null) {
                if (slow.val != secHead.val) {
                    return false;
                }
                slow = slow.next;
                secHead = secHead.next;
            }

        }
        return slow == null || slow.next == null;
    }
}
