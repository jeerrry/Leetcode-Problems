class Solution {
    public String removeOuterParentheses(String s) {
        var builder = new StringBuilder();
        int openCount = 0;

        for(char val : s.toCharArray()) {
            if(val == '(') {
                if(openCount > 0) {
                    builder.append("(");
                }
                openCount++;
            }else {
                openCount--;
                if(openCount > 0) {
                    builder.append(")");
                }
            }
        }

        return builder.toString();
    }
}