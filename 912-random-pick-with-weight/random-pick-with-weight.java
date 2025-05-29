class Solution {
    private int totalSum = 0;
    private int[] array;
    private Random random;
    public Solution(int[] w) {
        for(int val : w) totalSum += val;
        array = w;
        random = new Random();
    }
    
    public int pickIndex() {
        int target = random.nextInt(totalSum) + 1;
        int csum = 0;
        for(int i=0; i<array.length; i++) {
            csum += array[i];
            if(csum >= target) return i;
        }

        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */