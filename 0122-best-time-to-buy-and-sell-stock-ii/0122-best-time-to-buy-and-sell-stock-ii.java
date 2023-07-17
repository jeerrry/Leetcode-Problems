class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        boolean purchased = false;
        int purchaseVal = -1;
        int saleVal = -1;
        
        
        for(int i=0; i<prices.length; i++) {
            int val = prices[i];
            
            if(!purchased) {
                if(purchaseVal == -1 || val < purchaseVal) {
                    purchaseVal = val;
                }else {
                    purchased = true;
                    saleVal = val;
                }
            }else {
                if(saleVal == -1 || val > saleVal) {
                    saleVal = val;
                }else {
                    profit += (saleVal - purchaseVal);
                    purchased = false;
                    saleVal = -1;
                    purchaseVal = val;
                }
            }
        }
        
        if(purchased) {
            profit += (saleVal - purchaseVal);
        }
        
        return profit;
    }
}