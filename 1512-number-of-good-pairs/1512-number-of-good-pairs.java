class Solution {
    public int numIdenticalPairs(int[] nums) {
        int pairCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : nums) {
          int current = map.getOrDefault(val, 0) + 1;
          pairCount += current - 1;
          map.put(val, current);
        }

        return pairCount;
    }
}