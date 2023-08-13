class Solution {
    public int totalFruit(int[] fruits) {
        int totalFruits = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0, j=0; i<fruits.length;) {
            
            if(map.size()<2 || map.containsKey(fruits[i])) {
                int currentVal = map.getOrDefault(fruits[i], 0);
                map.put(fruits[i], currentVal + 1);
                totalFruits = Math.max(i - j + 1, totalFruits);
                i++;
                continue;
            }else{
                int oldFruit = fruits[j];
                int currentVal = map.get(oldFruit);
                if(currentVal - 1 <= 0) {
                    map.remove(oldFruit);
                }else{
                    map.put(oldFruit, currentVal - 1);
                }
                
                j++;
            }
        }
        
        return totalFruits;
    }
}