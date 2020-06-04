/**
 * @Auther: songyunfeng
 * @Date: 2020/5/20 15:34
 * @Description:LongestPalindrome 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class Solution5 {
    private int left;
    private int len;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            //TODO
        }
        return s;
    }
    private void find(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > len) {
                len = right -  left + 1;
                this.left = left;
            }
            right++;
        }
    }

}
