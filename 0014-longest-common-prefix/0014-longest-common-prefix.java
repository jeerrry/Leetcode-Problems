class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        
        String result = "";
        
        for(int i=0; i<strs[0].length(); i++){
            char target = strs[0].charAt(i);
            
            for(int j=1; j<strs.length; j++){
                if(i > strs[j].length()-1){
                    return result;
                }
                
                char current = strs[j].charAt(i);
                if(current != target){
                    return result;
                }
            }
            
            result += target;
        }
        
        
        return result;
    }
}