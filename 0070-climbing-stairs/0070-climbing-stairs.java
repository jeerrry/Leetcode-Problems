class Solution {
    public int climbStairs(int n) {
        // Write your code here.
		int fir = 1;
		int sec = 1;

		for(int i=2; i<=n; i++) {
			int cur = fir + sec;
			sec = fir;
			fir = cur;
		}

		return fir;
    }
}