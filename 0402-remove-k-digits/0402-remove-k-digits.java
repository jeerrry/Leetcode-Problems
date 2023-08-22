class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k) return "0";
        Stack<Integer> stack = new Stack<>();
        
        int removed = 0;
        for(int i=0; i<num.length(); i++) {
            int val = num.charAt(i) - '0';
            if(stack.size() == 0) {
                if(val == 0) continue;
                stack.push(val);
            }else{
                while(stack.size() > 0 && stack.peek() > val){
                    if(removed >= k) break;
                    
                    stack.pop();
                    removed++;
                }
                
                if(stack.size() == 0 && val == 0){
                    continue;
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
        
     

        return result.length() == 0 ? "0" : result.toString();
    }
}