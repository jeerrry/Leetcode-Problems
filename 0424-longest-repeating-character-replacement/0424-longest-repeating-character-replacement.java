class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxFrequency = 0;
        int[] frequency = new int[26];
        
        for(int i=0, j=0; i<s.length(); i++) {
            int index = s.charAt(i) - 'A';
            frequency[index]++;
            maxFrequency = Math.max(maxFrequency, frequency[index]);
            
            int charToReplace = (i - j + 1) - maxFrequency;
            if(charToReplace > k) {
                // Move window.
                frequency[s.charAt(j) - 'A']--;
                j++;
            }
            
            maxLength = Math.max(maxLength, i - j + 1);
        }
        
        return maxLength;
    }
}