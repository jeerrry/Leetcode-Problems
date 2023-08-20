class Pair {
    int value;
    int index;
    int span;
    
    public Pair(int value, int index, int span) {
        this.value = value;
        this.index = index;
        this.span = span;
    }
}
class StockSpanner {
    private final Stack<Pair> stack;
    private int span = 0;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        if(stack.size() == 0) {
            stack.push(new Pair(price, span++, 1));
            return 1;
        }
        
        var newStockSpan = new Pair(price, span++, 1);
        
        while(stack.size() > 0) {
            Pair lastPair = stack.peek();
            if(lastPair.value > price){
                stack.push(newStockSpan);
                return newStockSpan.span;
            }else{
                newStockSpan.span += lastPair.span;
                stack.pop();
                
                if(stack.size() == 0){
                    stack.push(newStockSpan);
                    return newStockSpan.span;
                }
            }
        }
        
        return -1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */