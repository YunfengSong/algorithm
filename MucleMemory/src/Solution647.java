/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 *
输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 */
public class Solution647 {
    private int res = 0;

    public int contSubString(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            find(s, i, i);
            find(s, i, i + 1);
        }
        return res;
    }

    private void find(String s, int i, int j) {
        while (i >= 0 && i < s.length() && j >= 0 && j < s.length() && s.charAt(i--) == s.charAt(j++)) {
            res++;
        }
    }
}
