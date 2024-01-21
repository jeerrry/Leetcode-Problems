class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int x = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[x];
        int[] hash = new int[x];
        Arrays.fill(dp, 1);

        int lastIndex = 0;
        int max = 0;
        for(int i=0; i<x; i++) {
            hash[i] = i;
            for(int j=0; j<i; j++) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }

            if(dp[i] > max) {
                lastIndex = i;
                max = dp[i];
            }
        }

        List<Integer> result = new ArrayList<>();
        while(true) {
            int val = nums[lastIndex];
            result.add(val);

            if(lastIndex == hash[lastIndex]) break;
            lastIndex = hash[lastIndex];
        }

        Collections.reverse(result);

        return result;
    }
}