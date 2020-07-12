/**
 * @Auther: songyunfeng
 * @Date: 2020/6/4 14:03
 * @Description: 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String str, String pattern, int s, int p) {
        if (p == pattern.length()) {
            return str.length() == s;
        }

        if (p + 1 < pattern.length() && pattern.charAt(p + 1) == '*') {
            if (s < str.length() && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '.')) {
                return isMatch(str, pattern, s, p + 2) || isMatch(str, pattern, s + 1, p);
            }
            return isMatch(str, pattern, s, p + 2);
        }

        if (s < str.length() && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '.')) {
            return isMatch(str, pattern, s + 1, p + 1);
        }
        return false;
    }
}
