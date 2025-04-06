class StockSpanner {
    private Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack();
    }
    
    public int next(int price) {
        if(stack.isEmpty()) {
            stack.push(new int[]{price, 1});

            return 1;
        }

        if(stack.peek()[0] <= price) {
            int span = 1;
            while(!stack.isEmpty() && stack.peek()[0] <= price) {
                var val = stack.pop();
                span += val[1];
            }

            stack.push(new int[]{price, span});
        } else {
            stack.push(new int[]{price, 1});
        }

        return stack.peek()[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */