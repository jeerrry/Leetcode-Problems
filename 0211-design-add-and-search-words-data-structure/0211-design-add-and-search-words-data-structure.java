class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node pointer = root;
        for(char c : word.toCharArray()) {
            Node current = pointer.nodes[c - 'a'];
            if(current == null) {
                current = new Node();
                pointer.nodes[c-'a'] = current;
            }
            pointer = current;
        }
        
        pointer.isWord = true;
    }
    
    public boolean search(String word) {
        
        return searchHelper(word, root, 0);
    }
    
    public boolean searchHelper(String word, Node node, int index) {
        if(node == null) return false;
        if(index == word.length() && node.isWord) return true;
        if(index == word.length() && !node.isWord) return false;
        
        char c = word.charAt(index);
        
        if(c == '.') {
            for(Node cnode : node.nodes){
                if(cnode != null && searchHelper(word, cnode, index + 1)) {
                    return true;
                }
            }
            
            return false;
        }
        
        return searchHelper(word, node.nodes[c - 'a'], index + 1);
    }
    
    private static class Node {
        public boolean isWord = false;
        public Node[] nodes = new Node[26];        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */