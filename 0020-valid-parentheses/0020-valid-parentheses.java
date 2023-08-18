class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else{
                
                if(stack.size() == 0) return false;
                
                if(c == ')') {
                    if(stack.peek() != '(') return false;
                    stack.pop();
                }
                
                if(c == ']') {
                    if(stack.peek() != '[') return false;
                    stack.pop();
                }
                
                if(c == '}') {
                    if(stack.peek() != '{') return false;
                    stack.pop();
                }
            }
        }
        
        return stack.size() > 0 ? false : true;
    }
}