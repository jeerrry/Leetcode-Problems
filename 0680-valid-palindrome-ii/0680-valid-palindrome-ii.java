class Solution {
    public boolean validPalindrome(String s) {
        int pointer1 = 0;
        int pointer2 = s.length() - 1;
        
        while(pointer1 <= pointer2) {
            char a = s.charAt(pointer1);
            char b = s.charAt(pointer2);
            
            if(a == b) {
                pointer1++;
                pointer2--;
            }else {
                return isPalindrome(s, pointer1 + 1, pointer2)
                    || isPalindrome(s, pointer1, pointer2 - 1);
            }
        }
        
        return true;
    }
    
    private boolean isPalindrome(String s, int leftP, int rightP) {
        while(leftP <= rightP) {
            char a = s.charAt(leftP);
            char b = s.charAt(rightP);
            
            if(a != b) return false;
            leftP++;
            rightP--;
        }
        
        return true;
    }
}