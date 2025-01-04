class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit = 0;
        int purchase = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int nprofit = prices[i] - purchase;
            if(nprofit > profit) {
                profit = nprofit;
            } else {
                maxProfit += profit;
                profit = 0;
                purchase = prices[i];
            }
            purchase = Math.min(purchase, prices[i]);
        }

        return maxProfit + profit;
    }
}