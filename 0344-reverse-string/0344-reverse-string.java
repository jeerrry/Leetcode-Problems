class Solution {
    public void reverseString(char[] s) {
        for(int i=0, j=s.length-1; i<j; i++,j--) {
            swap(s, i, j);
        }
    }
    
    public void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }
}