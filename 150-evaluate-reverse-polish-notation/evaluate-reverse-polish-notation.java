class Solution {
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();
        for(var token : tokens) {
            switch(token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int val2 = stack.pop();
                    stack.push(stack.pop() - val2);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    val2 = stack.pop();
                    stack.push(stack.pop() / val2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }
}