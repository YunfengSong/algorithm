import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/7/18
 */
public class Solution22 {
    private List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return list;
        }
        generate(n, 0, 0, "");
        return list;
    }

    private void generate(int n, int left, int right, String string) {
        if (left == right && left == n) {
            list.add(string);
        }
        if (left < n) {
            generate(n, left + 1, right, string + "(");
        }
        if (left > right) {
            generate(n, left, right + 1, string + ")");
        }
    }
}
