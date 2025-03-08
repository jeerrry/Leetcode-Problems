class Solution {
    public boolean isPossible(int[] nums) {
        var freq = new HashMap<Integer, Integer>();
        var needed = new HashMap<Integer, Integer>();

        for(int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        for(int num : nums) {
            if(freq.get(num) == 0) continue;

            if(needed.getOrDefault(num, 0) > 0) {
                needed.put(num, needed.get(num) - 1);
                needed.put(num + 1, needed.getOrDefault(num + 1, 0) + 1);
            }
            else if(freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);

                needed.put(num + 3, needed.getOrDefault(num + 3, 0) + 1);
            }else {
                return false;
            }

            freq.put(num, freq.get(num) - 1);
        }

        return true;
    }
}