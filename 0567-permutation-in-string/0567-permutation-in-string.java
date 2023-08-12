class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] frequency = new int[26];
        
        for(char c : s1.toCharArray()) {
            frequency[c-'a']++;
        }
        
        int[] localFrequency = new int[26];
        for(int i=0, j=0; i<s2.length(); i++){
            int index = s2.charAt(i) - 'a';
            
            if(frequency[index] == 0) {
                Arrays.fill(localFrequency, 0);
                j = i + 1;
            }else{
                localFrequency[index]++;
                int currentLength = i - j + 1;
                if(currentLength == s1.length()){
                    if(Arrays.equals(localFrequency, frequency)){
                        return true;
                    }else{
                        localFrequency[s2.charAt(j) - 'a']--;
                        j++;
                    }
                }
            }
        }
        
        return false;
    }
}