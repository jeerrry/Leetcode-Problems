class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int val : piles) {
            high = Math.max(high, val);
        }

        int result = -1;
        while(low <= high) {
            int mid = (low + high) >> 1;
            int hours = getHoursToEatAllBananas(piles, mid);
            if(hours <= h) {
                result = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return result;
    }

    private int getHoursToEatAllBananas(int[] piles, int cap) {
        int hours = 0;
        for(int pile : piles) {
            hours += Math.ceil((double)pile / cap);
        }
        return hours;
    }
}