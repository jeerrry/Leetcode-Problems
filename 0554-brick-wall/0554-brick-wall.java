class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int maxWidth = 0;
        for(int val : wall.get(0)) {
            maxWidth+=val;
        }
        
        for(List<Integer> row : wall) {
            int width = 0;
            for(int val : row) {
                width += val;
                if(width >= maxWidth){
                    break;
                }
                
                if(map.containsKey(width)) {
                    int current = map.get(width);
                    map.put(width, current + 1);
                }else {
                    map.put(width, 1);
                }
            }
        }
        
        int totalRows = wall.size();
        int maxGaps = 0;
        for(int val : map.values()){
            maxGaps = Math.max(maxGaps, val);
        }
        
        return totalRows - maxGaps;
    }
}