import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yunfeng
 * @create: 2020-07-16
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 **/
public class Solution17 {
    private List<String> res = new ArrayList<>();
    private String[] map = {"", "", "abc", "def", "ghi", "jkl" ,"mno", "pqrs", "yuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1){
            return res;
        }
         dfs(digits, 0, "");
        return res;
    }

    private void dfs(String digits, int index, String str) {
        if (index == digits.length()) {
            res.add(str);
            return;
        }
        String dict = map[digits.charAt(index) - '0'];
        for (int i = 0; i < dict.length(); i++) {
            dfs(digits, index + 1, str + digits.charAt(i));
        }
    }
}
