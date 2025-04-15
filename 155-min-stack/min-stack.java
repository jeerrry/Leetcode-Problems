class MinStack {
    private int min;
    private Stack<Node> stack;
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack();
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        stack.push(new Node(min, val));
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        stack.pop();
        min = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek().min;
    } 
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }

    private class Node {
        public int min;
        public int val;

        public Node(int min, int val) {
            this.min = min;
            this.val = val;
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