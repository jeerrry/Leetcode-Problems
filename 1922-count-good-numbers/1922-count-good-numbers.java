class Solution {
    public int countGoodNumbers(long n) {
        int mod = (int)1e9 + 7;
        
        long odd = n >> 1;
        long evn = (n + 1) >> 1;
        
        long one = power(4, odd) % mod;
        long two = power(5, evn) % mod;
        
        return (int)((one * two) % mod);
    }
    
    public long power(long x, long n) {
        int mod = (int)1e9 + 7;
        if(n == 0) return 1;
        
        long result = power(x, n / 2);
        if(n % 2 == 0) {
            return (result * result) % mod;
        }
        
        return (result * result * x) % mod;
    }
}