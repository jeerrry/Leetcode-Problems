class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            int eatHours = calTime(piles, h, mid);
            
            if(eatHours <= h) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        
        return right;
    }
    
    private int calTime(int[] piles, int h, int eat) {
        int hours = 0;
        
        for(int i=0; i<piles.length; i++) {
            int pile = piles[i];
            
            hours += Math.ceil((double)pile/eat);
        }
        
        return hours;
    }
}