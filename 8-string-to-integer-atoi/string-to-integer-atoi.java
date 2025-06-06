class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;

        int MAX = Integer.MAX_VALUE;
        int result = 0;
        int i = 0;
        int sign = 1;
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign *= s.charAt(0) == '-' ? -1 : 1;
            i += 1;
        }

        for(;i<s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))) break;
            int val = s.charAt(i) - '0';
            if(result > (MAX - val) / 10) {
                return sign < 0 ? Integer.MIN_VALUE : MAX;
            }

            result *= 10;
            result += val;
        }

        return sign * result;
    }
}