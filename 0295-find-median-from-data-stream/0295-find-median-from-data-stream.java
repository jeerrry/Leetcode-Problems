class MedianFinder {
    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        min.add(num);
        max.add(min.poll());
        
        if(min.size() < max.size()) {
            min.add(max.poll());
        }
    }
    
    public double findMedian() {
        if(min.size() == max.size()) {
            return (min.peek() + max.peek()) * 0.5; 
        }
        
        return min.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */