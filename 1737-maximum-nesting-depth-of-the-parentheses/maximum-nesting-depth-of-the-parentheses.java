class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        for(char c : s.toCharArray()) {
            switch(c) {
                case '(':
                    currentDepth+=1;
                    break;
                case ')':
                    maxDepth = Math.max(maxDepth, currentDepth);
                    currentDepth-=1;
                    break;
                default:
                    continue;
            }
        }

        return maxDepth;
    }
}