class Solution {
    public int countGoodNumbers(long n) {
        int mod = (int)1e9 + 7;

        long odd = n >> 1;
        long even = (n + 1) >> 1;

        long primeSet = power(4, odd);
        long evenSet = power(5, even);

        return (int)((evenSet * primeSet) % mod);
    }

    private long power(long digit, long power) {
        if(power == 0) return 1;
        int mod = (int)1e9 + 7;

        long result = power(digit, power/2);
        result *= result;
        if(power % 2 == 1) {
            return (result * digit) % mod;
        }

        return result % mod;
    }
}