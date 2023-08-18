class MinStack {
    private final Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.size() == 0) {
            stack.push(new Node(val, val));
            return;
        }
        
        int currentMin = stack.peek().minValue;
        int min = currentMin < val ? currentMin : val;
        var node = new Node(val, min);
        stack.push(node);
    }
    
    public void pop() {
        if(stack.size() == 0) return;
        stack.pop();
    }
    
    public int top() {
        if(stack.size() == 0) return -1;
        
        return stack.peek().value;
    }
    
    public int getMin() {
        if(stack.size() == 0) return -1;
        
        return stack.peek().minValue;
    }
    
    private class Node {
        int value;
        int minValue;
        
        public Node(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */