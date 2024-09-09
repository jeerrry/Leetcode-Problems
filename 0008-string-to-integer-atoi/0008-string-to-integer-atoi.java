class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        int isPositive = s.charAt(0) == '-' ? -1 : 1;
        
        return helper(s, 0, 0, isPositive);
    }
    
    public int helper(String s, int index, int rsf, int sign) {
        if(index == s.length()) return sign * rsf;
        char cChar = s.charAt(index);
        int current = s.charAt(index) - '0';
        
        if(cChar == '+' || cChar == '-' || cChar == ' '){
            if(index > 0) return sign * rsf;
            return helper(s, index + 1, rsf, sign);
        }
        if(rsf == 0 && current == 0) return helper(s, index + 1, rsf, sign);
        if(current < 0 || current > 9) return sign * rsf;

        if(rsf > (Integer.MAX_VALUE / 10)) 
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        if(rsf == (Integer.MAX_VALUE / 10) && current > 7) 
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        rsf *= 10;
        rsf += current;
        
        return helper(s, index + 1, rsf, sign);
    }
}