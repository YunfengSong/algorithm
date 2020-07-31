import java.util.Stack;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/7/28
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class Solution32 {
    public int longestValueParantheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int res = 0;
        int start = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    res = stack.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
                }
            }

        }
    return res;
    }
}
