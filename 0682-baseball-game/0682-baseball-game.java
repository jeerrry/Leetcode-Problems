class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        
        for(String op : operations){
            switch(op){
                case "+":
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    int res = val1 + val2;
                    stack.push(val2);
                    stack.push(val1);
                    stack.push(res);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        
        int result = 0;
        for(;stack.size() > 0;) result += stack.pop();
        
        return result;
    }
}