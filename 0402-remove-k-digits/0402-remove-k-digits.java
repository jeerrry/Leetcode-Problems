class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k) return "0";
        Stack<Integer> stack = new Stack<>();
        
        int removed = 0;
        for(int i=0; i<num.length(); i++) {
            int val = num.charAt(i) - '0';
            if(stack.size() == 0) {
                stack.push(val);
            }else{
                while(stack.size() > 0 && stack.peek() > val){
                    if(removed >= k) break;
                    
                    stack.pop();
                    removed++;
                }
                
                stack.push(val);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while(stack.size() > 0) {
            if(removed < k) {
                stack.pop();
                removed++;
                continue;
            }
            
            result.insert(0, stack.pop() + "");
        }
        
        while(true && result.length() > 0){
            int val = result.charAt(0) - '0';
            if(val > 0) break;
            result.replace(0, 1, "");
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}