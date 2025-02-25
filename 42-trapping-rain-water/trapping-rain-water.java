class Solution {
    public int trap(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;

        int mL = 0;
        int mR = 0;
        int result = 0;
        while(p1 <= p2) {
            if(mL <= mR) {
                result += Math.max(0, mL - height[p1]);
                mL = Math.max(mL, height[p1++]);
            }else {
                result += Math.max(0, mR - height[p2]);
                mR = Math.max(mR, height[p2--]);
            }
        }

        return result;
    }
}