class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int length = 1;
        
        while(queue.size() > 0) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                String word = queue.remove();
                if(word.equals(endWord)) return length;
                visited.add(word);
                
                for(int j=0; j<word.length(); j++) {
                    for(int k='a'; k<='z'; k++) {
                        char[] chars = word.toCharArray();
                        chars[j] = (char)k;
                        
                        String target = new String(chars);
                        if(set.contains(target) && !visited.contains(target)) {
                            queue.add(target);
                        }
                    }
                }
            }
            
            length++;
        }
        
        return 0;
    }
}