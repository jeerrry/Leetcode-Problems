class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int val : nums) {
            prefixSum += val;
            if(map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            
            int current = map.getOrDefault(prefixSum, 0);
            map.put(prefixSum, current + 1);
        }
        
        return count;
    }
}