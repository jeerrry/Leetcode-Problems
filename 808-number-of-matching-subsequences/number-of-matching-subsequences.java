class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        var map = new HashMap<String, Boolean>();
        for(var word : words) {
            if(!map.containsKey(word)) {
                // Check if its a subsequence
                if(isSubseq(s, word)) {
                    count++;
                    map.put(word, true);
                }else {
                    map.put(word, false);
                }
            }else {
                if(map.get(word)) count++;
            }
        }

        return count;
    }

    private boolean isSubseq(String s, String target) {
        int j=0;
        for(int i=0; i<s.length() && j<target.length(); i++) {
            if(s.charAt(i) == target.charAt(j)) {
                j++;
            }
        }

        return j == target.length();
    }
}