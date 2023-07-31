class Solution {
    public long distinctNames(String[] ideas) {
        int result = 0;
        HashSet<Integer>[] set = new HashSet[26];
        for(int i=0; i<26; i++) {
            set[i] = new HashSet<Integer>();
        }
        
        for(String s : ideas) {
            int index = s.charAt(0) - 'a';
            set[index].add(s.substring(1).hashCode());
        }
        
        long res = 0;
        for(int i=0; i<26; i++) {
            for(int j=i+1; j<26; j++) {
                long c1 = 0, c2 = 0;
                for(int val : set[i]) if(!set[j].contains(val)) c1++;
                for(int val : set[j]) if(!set[i].contains(val)) c2++;
                
                res += c1 * c2;
            }
        }
        
        return res * 2;
    }
}