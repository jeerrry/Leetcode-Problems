class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node pointer = root;
        for(char c : word.toCharArray()) {
            if(pointer.nodes.containsKey(c)) {
                pointer = pointer.nodes.get(c);
                continue;
            }
            
            Node temp = new Node();
            pointer.nodes.put(c, temp);
            pointer = temp;
        }
        
        pointer.isWord = true;
    }
    
    public boolean search(String word) {
        Node pointer = root;
        for(char c : word.toCharArray()) {
            if(!pointer.nodes.containsKey(c)) return false;
            pointer = pointer.nodes.get(c);
        }
        
        return pointer.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node pointer = root;
        for(char c : prefix.toCharArray()) {
            if(!pointer.nodes.containsKey(c)) return false;
            pointer = pointer.nodes.get(c);
        }
        
        return true;
    }
    
    private static class Node {
        public boolean isWord = false;
        public Map<Character, Node> nodes = new HashMap<>();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */