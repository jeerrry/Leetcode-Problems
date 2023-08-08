class Solution {
    public int maxArea(int[] height) {
        int result = Integer.MIN_VALUE;
        
        int pointer1 = 0;
        int pointer2 = height.length-1;
        
        while(pointer1 < pointer2) {
            int left = height[pointer1];
            int right = height[pointer2];
            int low = Math.min(left, right);
            int maxWater = low * (pointer2 - pointer1);    
            result = Math.max(result, maxWater);
            
            if(left < right) {
                pointer1++;
            }else if(left > right){
                pointer2--;
            }else{
                pointer1++;
                pointer2--;
            }
        }
        
        return result;
    }
}