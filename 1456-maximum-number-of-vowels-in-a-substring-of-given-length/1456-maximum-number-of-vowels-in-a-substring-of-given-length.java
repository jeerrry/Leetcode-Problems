class Solution {
    public int maxVowels(String s, int k) {
        var vowels = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
        int maxSize = 0;
        int currentVowelCount = 0;
        
        for(int i=0, j=0; i<s.length();) {
            char c = s.charAt(i);
            int currentSize = i - j + 1;
            
            if(currentSize <= k) {
                boolean isVowel = vowels.contains(c);
                if(isVowel) {
                    currentVowelCount += 1;
                    maxSize = Math.max(maxSize, currentVowelCount);
                }
                
                i++;
            }else{
                char removedChar = s.charAt(j);
                boolean isVowel = vowels.contains(removedChar);
                if(isVowel) {
                    currentVowelCount -= 1;
                }
                j++;
            }
        }
        
        return maxSize;
    }
}