class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        partitionHelper(s, "", result);
        
        return result;
    }
    
    private void partitionHelper(String input, String ssf, List<List<String>> result) {
        if(input.length() == 0) {
            if(ssf.length() > 0) {
                result.add(Arrays.asList(ssf.split(",")));
            }
            
            return;
        }
        
        for(int i=0; i<input.length(); i++) {
            String s1 = input.substring(0, i + 1);
            if(isPalindrome(s1)) {
                String temp = ssf.length() == 0 ? s1 : ssf + "," + s1;
                partitionHelper(input.substring(i + 1), temp, result);
            }
        }
    }
    
    private boolean isPalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;
        
        while(start < end) {
            char a = input.charAt(start++);
            char b = input.charAt(end--);
            
            if(a != b) {
                return false;
            }
        }
        
        return true;
    }
}