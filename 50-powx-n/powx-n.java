class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        
        // Avoid overflow case in case power is negative.
        long N = n;
        if(N < 0) {
            x = 1/x;
            N = -N;
        }

        return helper(x, N);
    }

    private double helper(double x, long n) {
        if(n == 0) return 1;
        double res = helper(x, n / 2);
        res *= res;

        if(n % 2 == 1) {
            res *= x;
        }

        return res;
    }
}