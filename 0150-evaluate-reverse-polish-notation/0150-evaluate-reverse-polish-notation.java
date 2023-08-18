class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens) {
            switch(token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    
                    stack.push(val2 - val1);
                    break;
                case "/":
                    int val3 = stack.pop();
                    int val4 = stack.pop();
                    
                    stack.push(val4 / val3);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}