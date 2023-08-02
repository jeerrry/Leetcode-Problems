class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        
        if(n < 0) {
           n = -n;
            x = 1/x;
        }
        
        double result = myPow(x, Math.abs(n)/2);
        result = result * result;
        if(Math.abs(n)%2 == 1) {
            result *= x;
        }
        
        if(n < 0) return 1/result;
        
        return result;
    }
}