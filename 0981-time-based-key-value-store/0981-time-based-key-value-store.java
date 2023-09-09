class TimeMap {
    private final HashMap<String, List<Value>> store;
    
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Value> values = new ArrayList<>();
        
        if(store.containsKey(key)){
            values = store.get(key);
        }
        
        values.add(new Value(key, value, timestamp));
        store.put(key, values);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)) {
            return "";
        }
        
        List<Value> values = store.get(key);
        int low = 0;
        int high = values.size() - 1;
        
        while(low < high) {
            int mid = low + (high - low + 1) / 2;
            Value val = values.get(mid);
            
            if(val.timestamp > timestamp) {
                high = mid - 1;
            }else {
                low = mid;
            }
        }
        
        Value result = values.get(low);
        
        return result.timestamp > timestamp ? "" : result.value;
    }
    
    class Value {
        public String key;
        public String value;
        public int timestamp;
        
        public Value(String key, String value, int timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */