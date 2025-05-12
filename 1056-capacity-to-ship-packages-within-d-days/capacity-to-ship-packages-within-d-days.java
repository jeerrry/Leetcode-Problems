class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = -1;
        int high = 0;
        for(int val : weights) {
            low = Math.max(low, val);
            high += val;
        }

        int result = high;
        while(low <= high) {
            int mid = (low + high) / 2;
            int tDays = getDaysToShip(weights, mid);

            if(tDays <= days) {
                result = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return result;
    }

    private int getDaysToShip(int[] weights, int capacity) {
        int totalWeight = 0;
        int days = 1;

        for(int val : weights) {
            if(totalWeight + val > capacity) {
                totalWeight = val;
                days++;
                continue;
            }

            totalWeight += val;
        }

        return days;
    }
}