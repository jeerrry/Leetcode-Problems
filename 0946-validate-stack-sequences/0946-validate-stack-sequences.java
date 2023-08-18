class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pointer1 = 0;
        for(int num : popped) {
            if(stack.size() > 0 && stack.peek() == num) {
                stack.pop();
            }else{
                if(stack.size() == 0 || (stack.size() > 0 && stack.peek() != num)) {
                    if(pointer1 < pushed.length) {
                        while(pointer1 < pushed.length) {
                            int currentVal = pushed[pointer1++];
                            stack.push(currentVal);
                            if(currentVal == num) break;
                        }
                    }
                }
                
                if(stack.size() > 0 && stack.peek() == num) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        
        return stack.size() == 0 ? true : false;
    }
}