import java.time.chrono.MinguoChronology;
import java.util.Stack;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) – 将元素 x 推入栈中。
 * pop() – 删除栈顶的元素。
 * top() – 获取栈顶元素。
 * getMin() – 检索栈中的最小元素。
 */
public class Solution155 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public Solution155() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() > x) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }


    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
