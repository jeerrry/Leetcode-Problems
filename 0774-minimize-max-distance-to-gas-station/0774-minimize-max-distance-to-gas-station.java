class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double low = 0;
        double high = 0;
        for(int i = 1; i < stations.length; i++) {
            high = Math.max(high, stations[i] - stations[i - 1]);
        }
        
        while(high - low > 1e-6) {
            double mid = (low + high) / 2;
            int count = gasStationCount(stations, mid);
            if(count > k) {
                low = mid;
            }else {
                high = mid;
            }
        }
        
        return low;
    }
    
    private int gasStationCount(int[] stations, double dist) {
        int count = 0;
        for(int i=1; i<stations.length; i++) {
            int st = (int)((stations[i] - stations[i - 1]) / dist);
            if((stations[i] - stations[i - 1]) == (st * dist)) {
                st--;
            }
            count+=st;
        }
        
        return count;
    }
}