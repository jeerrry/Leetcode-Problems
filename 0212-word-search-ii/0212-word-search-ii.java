class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = buildTrie(words);
        List<String> result = new ArrayList<>();
        
        // Apply DFS on matrix
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(i, j, board, trie, result);
            }
        }
        
        return result;
    }
    
    private void dfs(int i, int j, char[][]board, TrieNode root, List<String> result) {
        char c = board[i][j];
        if(c == '#' || root.nodes[c - 'a'] == null) return;
        
        TrieNode p = root.nodes[c - 'a'];
        
        if(p.word != null) {
            result.add(p.word);
            p.word = null;
        }
        
        board[i][j] = '#';
        
        if(i - 1 >= 0) dfs(i - 1, j, board, p, result);
        if(i + 1 < board.length) dfs(i + 1, j, board, p, result);
        if(j - 1 >= 0) dfs(i, j - 1, board, p, result);
        if(j + 1 < board[0].length) dfs(i, j + 1, board, p, result);
        
        board[i][j] = c;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode tempPointer = root;
            for(char c : word.toCharArray()) {
                if(tempPointer.nodes[c - 'a'] == null) {
                    tempPointer.nodes[c - 'a'] = new TrieNode();
                }
                
                tempPointer = tempPointer.nodes[c - 'a'];
            }
            tempPointer.word = word;
        }
        
        return root;
    }
    
    public static class TrieNode {
        public TrieNode[] nodes = new TrieNode[26];
        public String word = null;
    }
}