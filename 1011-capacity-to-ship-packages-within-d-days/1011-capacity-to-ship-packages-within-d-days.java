class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        
        while(low < high) {
            int capacity = low + (high - low) / 2;
            int maxDays = getDayCount(weights, capacity);
            if(maxDays > days) {
                low = capacity + 1;
            }else {
                high = capacity;
            }
        }
        
        return low;
    }
    
    private int getDayCount(int[] weights, int capacity) {
        int days = 1;
        int sum = 0;
        for(int weight : weights) {
            if(sum + weight > capacity){
                days++;
                sum = 0;
            }
            sum += weight;
        }
        return days;
    }
}