/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/1
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int res = 0 ;
        int curMin = prices[0];
        for (int price : prices) {
            res = Math.max(res, price - curMin);
            curMin = Math.min(price, curMin);
        }
        return res;
    }
}
