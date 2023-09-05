class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        
        for(int i=0; i<spells.length; i++) {
            int spell = spells[i];
            int count = getPotionCount(potions, spell,success);
            
            result[i] = count;
        }
        
        return result;
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