import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 */
public class Solution771 {
    public int numJewlsInStones(String J, String S) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                res++;
            }
        }
        return res;
    }
}
