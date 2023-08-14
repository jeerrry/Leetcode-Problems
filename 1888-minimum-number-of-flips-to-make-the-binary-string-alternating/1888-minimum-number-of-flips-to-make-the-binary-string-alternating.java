class Solution {
    public int minFlips(String s) {
        if(s.length() == 1) return 0;
        
        StringBuilder str = new StringBuilder(s);
        if(s.length()%2 == 1) str.append(str.toString());
        
        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();
        
        for(int i=1; i<=str.length(); i++) {
            if(i%2 == 0) {
                alt1.append("1");
                alt2.append("0");
            }else{
                alt1.append("0");
                alt2.append("1");
            }
        }
        
        int result = Integer.MAX_VALUE;
        int res1 = 0;
        int res2 = 0;
        int windowSize = s.length();
        
        for(int i=0, j=0; i < str.length();) {
            int currentSize = i - j + 1;
            boolean diff1 = str.charAt(i) != alt1.charAt(i);
            boolean diff2 = str.charAt(i) != alt2.charAt(i);
            
            
            if(currentSize > windowSize) {
                int j1 = str.charAt(j) != alt1.charAt(j) ? 1 : 0;
                int j2 = str.charAt(j) != alt2.charAt(j) ? 1 : 0;
                
                res1 -= j1;
                res2 -= j2;
                j++;
            }
            
            res1 += diff1 ? 1 : 0;
            res2 += diff2 ? 1 : 0;
            
            if(currentSize >= windowSize){
                result = Math.min(result, Math.min(res1, res2));
            }
            
            i++;

        }
        
        return result;
        
    }
}