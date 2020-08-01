/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/1
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        String res = "";
        int[] sFlag = new int[256];
        int[] tFlag = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tFlag[t.charAt(i)]++;
        }
        int count = t.length();
        int l = 0;
        int r = 0;

        return "";
        }
    }

