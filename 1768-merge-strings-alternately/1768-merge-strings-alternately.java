class Solution {
    public String mergeAlternately(String word1, String word2) {
        int pointer1 = 0;
        int pointer2 = 0;
        StringBuilder result = new StringBuilder();
        
        while(
        pointer1 < word1.length()
        && pointer2 < word2.length()) {
            char a = word1.charAt(pointer1++);
            char b = word2.charAt(pointer2++);
            
            result.append(a);
            result.append(b);
        }
        
        while(pointer1 < word1.length()) {
            result.append(word1.charAt(pointer1++));
        }
        
        while(pointer2 < word2.length()) {
            result.append(word2.charAt(pointer2++));
        }
        
        return result.toString();
    }
}