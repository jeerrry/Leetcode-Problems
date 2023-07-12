class Pair{
    public int key;
    public int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private final LinkedList<Pair>[] data;
    private final int size;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        size = 1000;
        data = new LinkedList[size];
    }

    public void put(int key, int value) {
        int index = getIndex(key);

        if(data[index] == null) {
            data[index] = new LinkedList<>();
        }

        var node = data[index].stream().filter(x -> x.key == key).findFirst();
        if(node.isPresent()) {
            node.get().value = value;
            return;
        }

        data[index].add(new Pair(key, value));
    }

    public int get(int key) {
        int index = getIndex(key);

        if(data[index] == null) {
            return -1;
        }else {
            LinkedList<Pair> list = data[index];
            var res = list.stream().filter(x -> x.key == key).findFirst();
            if(res.isPresent()) {
                return res.get().value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);

        if(data[index] == null)  {
            return;
        }

        LinkedList<Pair> list = data[index];
        list.removeIf(x -> x.key == key);
    }

    private int getIndex(int key) {
        return key % size;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */