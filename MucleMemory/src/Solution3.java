/**
 * @Auther: songyunfeng
 * @Date: 2020/5/19 11:06
 * @Description:lengthOfLongestSubstring 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int[] map = new int[256];
        //互动窗口【l，r]】
        int l = 0;
        int r = 0;
        int res = 0;
        while (l < s.length()) {
            if (r < s.length() && map[s.charAt(r)] == 0) {
                map[s.charAt(r)]++;
                r++;
                res = Math.max(res, r - l);
            } else {
                map[s.charAt(l)]--;
                l++;
            }
        }
        return res;
    }
}
