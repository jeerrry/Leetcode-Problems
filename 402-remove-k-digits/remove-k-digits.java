class Solution {
    public String removeKdigits(String num, int k) {
        var stack = new Stack<Integer>();
        int removed = 0;
        for(char c : num.toCharArray()) {
            int val = c - '0';

            if(stack.isEmpty() && val == 0) continue;
            while(removed < k && !stack.isEmpty() && stack.peek() > val) {
                stack.pop();
                removed++;
            }

            stack.push(val);
        }

        while(removed < k && !stack.isEmpty()){
            stack.pop();
            removed++;
        }

        var result = new StringBuilder();
        while(!stack.isEmpty()) result.append(stack.pop());
        result.reverse();
        
        while(result.length() > 0 && result.charAt(0) == '0') result.deleteCharAt(0);
        return result.length() == 0 ? "0" : result.toString();
    }
}