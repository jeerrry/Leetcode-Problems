class FreqStack {
    private final HashMap<Integer, Integer> frequency;
    private final HashMap<Integer, List<Integer>> countMap;
    private int maxCount = 0; 

    public FreqStack() {
        frequency = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    public void push(int val) {
        if(!frequency.containsKey(val)){
            frequency.put(val, 1);
            maxCount = Math.max(maxCount, 1);
            recordValue(val, 1);
            return;
        }
        
        int currentFreq = frequency.get(val) + 1;
        frequency.put(val, currentFreq);
        recordValue(val, currentFreq);
        
        maxCount = Math.max(maxCount, currentFreq);
    }
    
    public int pop() {
        if(maxCount == 0) return -1;
        
        List<Integer> vals = countMap.get(maxCount);
        int lastIndex = vals.size() - 1;
        int topVal = vals.get(lastIndex);
        vals.remove(lastIndex);
        
        if(vals.size() == 0) {
            countMap.remove(maxCount--);
        }else {
            countMap.put(maxCount, vals);
        }
        
        int currentValFreq = frequency.get(topVal);
        currentValFreq-=1;
        if(currentValFreq <= 0) {
            frequency.remove(topVal);
        }else{
            frequency.put(topVal, currentValFreq);
        }
        
        return topVal;
    }
    
    private void recordValue(int val, int freq) {
        List<Integer> vals = new ArrayList<>();
        
        if(!countMap.containsKey(freq)){
            vals.add(val);
            countMap.put(freq, vals);
            return;
        }
        
        vals = countMap.get(freq);
        vals.add(val);
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */