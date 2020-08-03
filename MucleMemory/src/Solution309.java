/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }


        int buy = Integer.MAX_VALUE;
        int sale = 0;
        int rest = 0;
        for (int price : prices) {
            int salaPre = sale;
            int buyPre = buy;
            sale = Math.max(buy + price, sale);
            buy = Math.max(buy, rest - price);
            rest = Math.max(rest, Math.max(salaPre, buy));
        }
        return sale;
    }
}
