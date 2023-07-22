class Solution {
    public int strStr(String haystack, String needle) {
        int index = 0;
        while(index < haystack.length()) {
            char cc = haystack.charAt(index);
            if(cc == needle.charAt(0)) {
                int pointer1 = index;
                int pointer2 = 0;
                while(pointer2 < needle.length()) {
                    if(pointer1 >= haystack.length()) return -1;
                    int char1 = haystack.charAt(pointer1);
                    int char2 = needle.charAt(pointer2);
                    
                    if(char1 == char2) {
                        pointer1++;
                        pointer2++;
                        continue;
                    }
                    
                    break;
                }
                
                if(pointer2 == needle.length()) return index;
                
            }
            index++;
        }
        
        return -1;
    }
}