class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        helper(0, new ArrayList<String>(), s, result);
        return result;
    }
    
    private void helper(int index, ArrayList<String> rsf, String input, List<List<String>> result) {
        if(index == input.length()) {
            result.add(new ArrayList<String>(rsf));
            return;
        }
        
        for(int i=index; i<input.length(); i++) {
            if(isPalindrome(input, index, i)) {
                rsf.add(input.substring(index, i + 1));
                helper(i + 1, rsf, input, result);    
                rsf.remove(rsf.size() - 1);
            }
            
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        int p1 = start;
        int p2 = end;
        
        while(p1 < p2) {
            char c1 = s.charAt(p1++);
            char c2 = s.charAt(p2--);
            
            if(c1 != c2) return false;
        }
        
        return true;
    }
}