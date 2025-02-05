class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;

        int MAX = Integer.MAX_VALUE;
        int i = 0;
        int sign = 1;
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = s.charAt(0) == '-' ? -1 : 1;
            i+=1;
        }
        int result = 0;
        for(;i<s.length(); i++) {
            char current = s.charAt(i);
            if(!Character.isDigit(current)) break;
            int val = current - '0';

            if(result > (MAX - val) / 10) {
                return sign == -1 ? Integer.MIN_VALUE : MAX;
            }

            result *= 10;
            result += val;
        }

        return sign * result;
    }
}