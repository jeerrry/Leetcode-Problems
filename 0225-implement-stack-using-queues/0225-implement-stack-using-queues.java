class MyStack {
    Queue<Integer> queue;
    Queue<Integer> temp;
    
    public MyStack() {
        queue = new LinkedList<>();
        temp = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        if(queue.size() == 0) return -1;
        
        while(queue.size() > 1) {
            temp.add(queue.remove());
        }
        
        int res = queue.remove();
        
        queue = temp;
        temp = new LinkedList<>();
        
        return res;
    }
    
    public int top() {
        if(queue.size() == 0) return -1;
        
        while(queue.size() > 1){
            temp.add(queue.remove());
        }
        
        int res = queue.remove();
        
        temp.add(res);
        queue = temp;
        temp = new LinkedList<>();
        
        return res;
    }
    
    public boolean empty() {
        return queue.size() > 0 ? false : true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */