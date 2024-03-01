class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] hash = new int[26];
        for(int i=0; i<sentence.length(); i++) {
            char current = sentence.charAt(i);
            current = Character.toLowerCase(current);
            if(current == ' ') continue;
            if(current - 'a' < 0 || current - 'a' >= 26) continue;
            hash[current - 'a']++;
        }
        
        for(int val : hash) if(val == 0) return false;
        return true;
    }
}