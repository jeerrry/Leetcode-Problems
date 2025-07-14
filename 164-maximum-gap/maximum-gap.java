class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int val : nums) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        int bucketSize = Math.max(1, (max - min) / nums.length - 1);
        int bucketCount = (max - min)/bucketSize + 1;

        var minBuckets = new int[bucketCount];
        var maxBuckets = new int[bucketCount];

        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);

        for(int num : nums) {
            int idx = (num - min) / bucketSize;
            minBuckets[idx] = Math.min(minBuckets[idx], num);
            maxBuckets[idx] = Math.max(maxBuckets[idx], num);
        }

        int maxGap = 0, prev = min;
        for(int i=0; i<bucketCount; i++) {
            if(minBuckets[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, minBuckets[i] - prev);
            prev = maxBuckets[i];
        }

        return maxGap;
    }
}