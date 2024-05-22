class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int[] minMax = getMinMax(bloomDay);
        int low = minMax[0];
        int high = minMax[1];
        int result = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int maxBoq = maxBouquets(bloomDay, mid, k);
            if(maxBoq >= m) {
                result = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return result;
    }
    
    public int[] getMinMax(int[] bloomDay) {
        int[] minMax = {Integer.MAX_VALUE, 0};
        for(int val : bloomDay) {
            minMax[0] = Math.min(minMax[0], val);
            minMax[1] = Math.max(minMax[1], val);
        }
        
        return minMax;
    }
    
    public int maxBouquets(int[] bloomDay, int day, int size) {
        int total = 0;
        int count = 0;
        for(int val : bloomDay) {
            if(val <= day) {
                count+=1;
            }else {
                total += count/size;
                count = 0;
            }
        }
        
        total += count/size;
        
        return total;
    }
}