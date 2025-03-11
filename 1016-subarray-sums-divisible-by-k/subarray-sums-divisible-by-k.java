class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        for(int val : nums) {
            sum += val;
            int rem = sum % k;

            if(rem < 0) {
                rem += k;
            }

            if(map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}