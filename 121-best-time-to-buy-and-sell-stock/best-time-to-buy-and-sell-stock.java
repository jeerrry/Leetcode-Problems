class Solution {
    public int maxProfit(int[] prices) {
        int boughtPrice = prices[0];
        int profit = 0;

        for(int i=1; i<prices.length; i++) {
            profit = Math.max(profit, Math.max(0, prices[i] - boughtPrice));
            boughtPrice = Math.min(boughtPrice, prices[i]);
        }

        return profit;
    }
}