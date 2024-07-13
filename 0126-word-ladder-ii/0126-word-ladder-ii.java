class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        var set = new HashSet<String>(wordList);
        if(!set.contains(endWord)) return new ArrayList<>();
        if(set.contains(beginWord)) set.remove(beginWord);
        var map = new HashMap<String, Integer>();
        
        Queue<String> queue = new LinkedList<>();
        int level = 0;
        queue.add(beginWord);
        map.put(beginWord, level);
        
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                var currentVal = queue.remove();
                if(currentVal.equals(endWord)) continue;
                
                for(int j=0; j<currentVal.length(); j++) {
                    var charValue = currentVal.toCharArray();
                    for(int k='a'; k<='z'; k++) {
                        charValue[j] = (char)k;
                        var str = new String(charValue);
                        if(set.contains(str) && !map.containsKey(str)) {
                            map.put(str, level);
                            set.remove(str);
                            queue.add(str);
                        }
                    }
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        if(map.containsKey(endWord)) {
            dfs(endWord, beginWord, new ArrayList<String>(Arrays.asList(endWord)), map, result);
        }
        
        return result;
    }
    
    private void dfs(String endWord, String beginWord, List<String> seq, Map<String,Integer> map, List<List<String>> result) {
        if(endWord.equals(beginWord)) {
            var temp = new ArrayList<>(seq);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }
        
        int value = map.get(endWord);
        for(int i=0; i<endWord.length(); i++) {
            for(int j='a'; j<='z'; j++) {
                char[] alpha = endWord.toCharArray();
                alpha[i] = (char)j;
                
                var resString = new String(alpha);
                if(map.containsKey(resString) && map.get(resString) + 1 == value) {
                    seq.add(resString);
                    dfs(resString, beginWord, seq, map, result);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    
}














