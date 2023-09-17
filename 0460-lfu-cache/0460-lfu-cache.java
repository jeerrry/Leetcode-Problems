class LFUCache {
    class Node{
        int k,v,f;
        public Node(int k,int v){
            this.k=k;
            this.v=v;
            this.f=1;
        }
    }
    
    int capacity,minFrequency;
    //key,Node
    Map<Integer,Node> map;
    //frequency, key
    Map<Integer,Set<Integer>> lruMap;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minFrequency=1;
        map=new HashMap<>();
        lruMap=new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        Node n=map.get(key);        
        update(n);        
        return n.v;                        
    }
    
    private void update(Node n){        
        
        //update frequency lru map
        int frequency=n.f;      
        lruMap.get(frequency).remove(n.k);                
        
        //update frequency
        if(lruMap.get(frequency).isEmpty()){
            lruMap.remove(frequency);
            //update min frequency
            if(frequency==minFrequency)
                minFrequency++;
        }                
        lruMap.putIfAbsent(frequency+1,new LinkedHashSet<>());
        lruMap.get(frequency+1).add(n.k);                  
        
        n.f++;        
    }
    
    public void put(int key, int value) {
        if(capacity==0)
            return;
        
        if(map.containsKey(key)){
            Node n=map.get(key); 
            n.v=value;
            update(n);            
        }else{        
            //remove min frequency/lru when capacity full
            if(map.size()==capacity){                
                
                int k=lruMap.get(minFrequency).iterator().next();
                map.remove(k);
                
                lruMap.get(minFrequency).remove(k);                
                if(lruMap.get(minFrequency).isEmpty()){
                    lruMap.remove(minFrequency);
                }                                
            }
            
            Node n=new Node(key,value);
            map.put(key,n);
            
            minFrequency=1;
            lruMap.putIfAbsent(minFrequency,new LinkedHashSet<>());
            lruMap.get(minFrequency).add(key);                
        }            
                    
    }
}