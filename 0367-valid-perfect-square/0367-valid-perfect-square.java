class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = (long)num;
        
        while(low<=high) {
            long mid = low + (high - low) / 2;
            long res = mid * mid;
            if(res == num) {
                return true;
            }else if(res > num) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return false;
    }
}