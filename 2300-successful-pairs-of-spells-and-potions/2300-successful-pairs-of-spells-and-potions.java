class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(potions);
        
        for(int spell : spells) {
            int count = getPotionCount(potions, spell,success);
            
            result.add(count);
        }
        
        int[] res = result.stream().mapToInt(i -> i).toArray();
        
        return res;
    }
    
    private int getPotionCount(int[] potions, int spell, long success) {        
        int low = 0;
        int high = potions.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            long res = (long)spell * potions[mid];
            
             if(res < success) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        
        return low >= potions.length ? 0 : potions.length - low;
    }
}