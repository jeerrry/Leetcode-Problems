class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == '*') {
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while(stack.size() > 0) {
            result.append(stack.pop()) ;
        }
        
        return result.reverse().toString();
    }
}