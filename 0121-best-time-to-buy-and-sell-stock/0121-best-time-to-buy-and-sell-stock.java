class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        int min_price = prices[0];
        for (int price : prices) {
            if (min_price > price) {
                min_price = price;
                continue;
            }
            if (price - min_price > profit) {
                profit = price - min_price;
            }
        }
        return profit;

    }
}