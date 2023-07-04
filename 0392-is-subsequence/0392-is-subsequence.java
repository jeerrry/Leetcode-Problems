class Solution {
    public boolean isSubsequence(String s, String t) {
        int pointerA = 0;
        int pointerB = 0;
        
        while(pointerA < s.length() && pointerB < t.length()) {
            char first = s.charAt(pointerA);
            char second = t.charAt(pointerB);
            
            if(first == second) {
                pointerA++;
            }
            pointerB++;
        }
        
        return pointerA == s.length();
    }
}