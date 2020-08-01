/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/1
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < word2.length(); i++) {
            dp[0][i]  = i;
        }

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
