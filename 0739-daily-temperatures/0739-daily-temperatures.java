class Solution {
    private class Pair{
        int index;
        int val;
        
        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        
        for(int i=0; i<temperatures.length; i++) {
            int currentVal = temperatures[i];
            if(stack.size() == 0) {
                stack.push(new Pair(i, currentVal));
                continue;
            }
            
            while(stack.size() > 0) {
                Pair node = stack.peek();
                if(currentVal > node.val) {
                    result[node.index] = i - node.index;
                    stack.pop();
                    if(stack.size() == 0) stack.push(new Pair(i, currentVal));
                }else {
                    stack.push(new Pair(i, currentVal));
                    break;
                }
            }
        }
        
        while(stack.size() > 0) {
            Pair val = stack.pop();
            result[val.index] = 0;
        }
        
        return result;
    }
}