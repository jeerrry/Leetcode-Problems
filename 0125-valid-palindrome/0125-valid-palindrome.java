class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sbuild = new StringBuilder();
        
        for(char chr : s.trim().toLowerCase().toCharArray()){
            int res = chr - 'a';
            int res2 = chr - '0';
            if((res >=0 && res < 26) || (res2 >= 0 && res2 < 10)) sbuild.append(chr+"");
        }
        
        for(int i=0, j=sbuild.length()-1; i<j;) {
            char a = sbuild.charAt(i);
            char b = sbuild.charAt(j);
            
            if(a != b) return false;
            i++;
            j--;
        }
        
        return true;
    }
}