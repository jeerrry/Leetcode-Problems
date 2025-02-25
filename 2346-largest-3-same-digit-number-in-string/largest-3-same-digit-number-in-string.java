class Solution {
    public String largestGoodInteger(String num) {
        int result = -1;
        for(int i=0; i<num.length() - 2; i++) {
            char current = num.charAt(i);
            char next = num.charAt(i + 1);
            char next2 = num.charAt(i + 2);
            if(current == next && current == next2) {
                result = Math.max(result, current - '0');
            }
        }

        return result == -1 ? "" : result + "" + result + "" + result;
    }
}