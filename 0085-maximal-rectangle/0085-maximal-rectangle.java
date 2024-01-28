class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] temp = new int[matrix[0].length];
        int ans = 0;
        for(char[] val : matrix) {
            for(int i=0; i<val.length; i++) {
                if(val[i] == '1') temp[i]++;
                else temp[i] = 0;
            }
            
            ans = Math.max(ans, largestRectangleArea(temp));
        }
        
        return ans;
    }
    
    public int largestRectangleArea(int[] heights) {
      int area = 0, n = heights.length;
      int start;
      Stack<Pair<Integer,Integer>> stack = new Stack<>();
      for(int i=0;i<heights.length;i++){
         int curHt =heights[i];
         start = i;
        while(!stack.isEmpty() && stack.peek().getValue() > curHt){
          Pair<Integer,Integer> pair = stack.pop();
          int index = pair.getKey();
          int h = pair.getValue();
          area = Math.max(area, h * (i - index));
          start = index;
        }
        stack.push(new Pair(start,curHt));
      }
      
       while(!stack.isEmpty()){
          Pair<Integer,Integer> pair = stack.pop();
          int index = pair.getKey();
          int h = pair.getValue();
          area = Math.max(area, h * (n - index));
       }
        return area;
    }
}