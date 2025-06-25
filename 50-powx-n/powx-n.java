class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0) {
            N = -N;
            x = 1/x;
        }

        return helper(x, N);
    }

    private double helper(double x, long n) {
        if(n == 0) return 1;

        double result = helper(x, n/2);

        result *= result;
        if(n % 2 == 1) result *= x;

        return result;
    }
}