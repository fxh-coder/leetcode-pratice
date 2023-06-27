public class LC_bestTimeToBuyAndSellStock {
    public int maxProfit(int prices[]) {
        int n = prices.length;
        // 记录到当前为止，哪一个股票的价钱最低
        int[] minN = new int[n];
        minN[0] = prices[0];
        for (int i = 1; i < n; i++) {
            minN[i] = Math.min(prices[i], minN[i - 1]);
        }

        int res = 0;
        // 使用当前价钱减去到当前为止最低的价钱，并比较是否为最大值
        for (int i = 1; i < n; i++) {
            res = Math.max(prices[i] - minN[i], res);
        }
        return res;
    }
}
