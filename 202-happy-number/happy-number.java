class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getDigit(slow);

        while(fast != 1 && slow != fast) {
            slow = getDigit(slow);
            fast = getDigit(getDigit(fast));
        }

        return fast == 1;    
    }

    private int getDigit(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}