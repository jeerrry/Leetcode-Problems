class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer>[] countArray = new ArrayList[nums.length+1];
        
        for(int val : nums) {
            int current = map.getOrDefault(val, 0);
            current+=1;
            map.put(val, current);
        }
        
        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(countArray[frequency] == null) {
                countArray[frequency] = new ArrayList<Integer>();
            }
            countArray[frequency].add(key);
        }
        
        int[] result = new int[k];
        int selected = 0;
        for(int i=countArray.length-1; i>=0 && selected < k; i--) {
            var values = countArray[i];
            if(values == null) continue;
            
            for(int v : values) {
                result[selected++] = v;
                if(selected >= k) break;
            }
        }
        
        return result;
    }
}