class RandomizedSet {
    private final HashMap<Integer, Integer> map;
    private final List<Integer> arrayList;
    private final Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        arrayList = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        arrayList.add(arrayList.size(), val);
        map.put(val, arrayList.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int currentIndex = map.get(val);
        if(arrayList.size() > 1) {
            int temp = arrayList.get(arrayList.size()-1);
            arrayList.set(arrayList.size() - 1, val);
            arrayList.set(currentIndex, temp);
            map.put(temp, currentIndex);
        }
        
        arrayList.remove(arrayList.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(arrayList.size());
        
        return arrayList.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */