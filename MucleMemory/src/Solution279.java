import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 */
public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
}
