class Solution {
    public int partitionString(String s) {
        int count = 0;
        int[] frequency = new int[26];
        
        for(char c : s.toCharArray()) {
            int index = c - 'a';
            
            if(frequency[index] == 0){
                frequency[index]+=1;
            }else{
                count++;
                frequency = new int[26];
                frequency[index]+=1;
            }
        }
        
        for(int num : frequency) {
            if(num > 0) {
                return count + 1;
            }
        }
        
        return count;
        
    }
}