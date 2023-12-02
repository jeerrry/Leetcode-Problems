class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        
        queue.add(new Pair<>("0000", 0));
        while(queue.size() > 0) {
            Pair<String, Integer> pair = queue.remove();
            String key = pair.getKey();
            int moves = pair.getValue();
            
            if(key.equals(target)) return moves;
            if(set.contains(key)) continue;
            set.add(key);
            
            for(String comb : generateKeys(key)) {
                if(set.contains(comb)) continue;
                
                queue.add(new Pair<>(comb, moves + 1));
            }
        }
        
        return -1;
    }
    
    private List<String> generateKeys(String current) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<4; i++) {
            int cval = Integer.parseInt(current.charAt(i) +"");
            int nval1 = (cval + 1) % 10;
            int nval2 = (cval - 1 + 10) % 10;
            
            String sub1 = current.substring(0, i);
            String sub2 = current.substring(i + 1, 4);
            
            result.add(sub1+nval1+sub2);
            result.add(sub1+nval2+sub2);
        }
        
        return result;
    }
}