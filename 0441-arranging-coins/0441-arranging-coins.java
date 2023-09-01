class Solution {
    public int arrangeCoins(int n) {
        long low = 0;
        long high = n;
        
        while(low <= high) {
            long mid = low + (high - low) / 2;
            long count = (mid * (mid + 1))/2;
            if(count == n) {
                return (int)mid; 
            }else if(count < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return (int)high;
    }
}