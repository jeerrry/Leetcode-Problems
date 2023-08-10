class Solution {
    public int trap(int[] height) {
        int pointer1 = 0;
        int pointer2 = height.length-1;
        
        int maxL = 0;
        int maxR = 0;
        int result = 0;
        while(pointer1 <= pointer2) {
            if(maxL <= maxR) {
                int res = Math.max(0, maxL - height[pointer1]);
                result += res;
                maxL = Math.max(maxL, height[pointer1++]);
            }else {
                int res = Math.max(0, maxR - height[pointer2]);
                result += res;
                maxR = Math.max(maxR, height[pointer2--]);
            }
        }
        
        return result;
    }
}