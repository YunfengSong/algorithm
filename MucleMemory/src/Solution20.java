import java.util.Stack;

/**
 * @author: Yunfeng
 * @create: 2020-07-16
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 输入: "([)]"
 * 输出: false
 **/
public class Solution20 {
    public boolean isValid(String s) {
        if (s == null || (s.length() & 1) == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            } else if (s.charAt(i) == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            } else if (s.charAt(i) == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }

        }
        return stack.isEmpty();
    }
}
