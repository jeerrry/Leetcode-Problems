class Pair {
    public char val;
    public int count;
    
    public Pair(char val, int count) {
        this.val = val;
        this.count = count;
    }
}
class Solution {    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(stack.size() == 0) {
                stack.push(new Pair(c, 1));
            }else {
                Pair top = stack.peek();
                Pair newVal = new Pair(c, 1);
                if(top.val == c) {
                    newVal.count = top.count + 1;
                }
                
                stack.push(newVal);
                
                if(stack.size() > 0 && stack.peek().count >= k){
                    for(int i=0; i<k && stack.size() > 0; i++){
                        stack.pop();
                    }
                }
            }
        }
        
        StringBuilder builder = new StringBuilder();
        while(stack.size() > 0) {
            builder.insert(0, stack.pop().val + "");
        }
        
        return builder.toString();
    }
}