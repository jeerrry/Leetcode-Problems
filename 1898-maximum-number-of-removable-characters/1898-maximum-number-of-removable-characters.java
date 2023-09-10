class Solution {
    public int maximumRemovals(String s, String p, int[] rem) {
        int low = 0;
        int high = rem.length;
        int [] map = new int[s.length()];
        Arrays.fill(map, rem.length);
        for(int i=0; i<rem.length; i++) {
            map[rem[i]] = i;
        }
        
        while(low < high) {
            int mid = low + (high - low + 1) / 2;
            int j = 0;
            for(int i=0; i<s.length() && j<p.length(); i++) {
                if(map[i] >= mid && s.charAt(i) == p.charAt(j)){
                    j++;
                }
            }
            
            if(j == p.length()){
                low = mid;
            }else{
                high = mid - 1;
            }
        }
        
        return low;
    }
}