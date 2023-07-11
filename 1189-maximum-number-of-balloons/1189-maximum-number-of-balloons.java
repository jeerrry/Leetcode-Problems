class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] target = new int[26];
        for(char c : "balloon".toCharArray()) {
            target[c - 'a']++;
        }
        
        int[] frequency = new int[26];
        for(char c : text.toCharArray()) {
            frequency[c - 'a']++;
        }
        
        int count = 0;
        while(frequency['b' - 'a'] > 0) {
            for(char c : "balloon".toCharArray()) {
                int index = c - 'a';
                if(frequency[index] > 0) {
                    frequency[index]--;
                }else{
                    return count;
                }
            }
            
            count++;
        }
        
        return count;
        
    }
}