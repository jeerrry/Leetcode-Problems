class Solution {
    public int lengthOfLastWord(String s) {
        int lastValidIndex = s.length()-1;
        while(lastValidIndex>-1 && s.charAt(lastValidIndex) == ' ') {
            lastValidIndex--;
        }
        
        if(lastValidIndex == -1) return 0;
        int startIndex = lastValidIndex - 1;
        while(startIndex>=0 && s.charAt(startIndex) != ' '){
            startIndex--;
        }
        
        return lastValidIndex - startIndex;
    }
    
    
}