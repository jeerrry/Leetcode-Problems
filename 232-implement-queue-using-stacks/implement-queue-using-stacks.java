class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> temp;
    public MyQueue() {
        stack = new Stack();
        temp = new Stack();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if(empty()) return -1;

        while(stack.size() > 1) temp.push(stack.pop());

        int result = stack.pop();

        while(!temp.isEmpty()) stack.push(temp.pop());

        return result;
    }
    
    public int peek() {
        if(empty()) return -1;

        while(stack.size() > 1) temp.push(stack.pop());

        int result = stack.pop();

        temp.push(result);
        while(!temp.isEmpty()) stack.push(temp.pop());

        return result;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */