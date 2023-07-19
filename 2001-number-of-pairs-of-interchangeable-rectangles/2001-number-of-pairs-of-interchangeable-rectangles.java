class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();
        
        long count = 0;
        
        for(int[] rect : rectangles) {
            double ratio = (Double.valueOf(rect[0]) / Double.valueOf(rect[1]));
            
            if(map.containsKey(ratio)) {
                int cVal = map.get(ratio);
                count += cVal;
                map.put(ratio, cVal + 1);
            }else {
                map.put(ratio, 1);
            }
        }
        
        return count;
    }
}