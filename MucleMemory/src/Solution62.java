/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/1
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 */
public class Solution62 {
    public int uniquepaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][m - 1];
    }
}
