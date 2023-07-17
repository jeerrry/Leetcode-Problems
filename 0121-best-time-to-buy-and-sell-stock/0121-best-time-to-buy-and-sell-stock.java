class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int smallest = Integer.MAX_VALUE;
        
        for(int i=0; i<prices.length; i++) {
            if(prices[i] < smallest) {
                smallest = prices[i];
            }
            
            profit = Math.max(profit, prices[i] - smallest);
        }
        
        return profit;
        
    }
}