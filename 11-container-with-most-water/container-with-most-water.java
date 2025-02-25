class Solution {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;

        int result = 0;

        while(p1 < p2) {
            int left = height[p1];
            int right = height[p2];

            int nresult = Math.min(left, right) * (p2 - p1);
            result = Math.max(result, nresult);

            if(left < right) {
                p1++;
            }else if(left > right) {
                p2--;
            }else {
                p1++;
                p2--;
            }
        }

        return result;
    }
}