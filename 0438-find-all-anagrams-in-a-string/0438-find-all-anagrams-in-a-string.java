class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] target = new int[26];
        for(char c : p.toCharArray()) {
            target[c - 'a']+=1;
        }
        
        String targetStr = "";
        for(int val : target) {
            targetStr += val;
        }
        
        int pointer1 = 0;
        int pointer2 = 0;
        int[] currentVal = new int[26];
        List<Integer> result = new ArrayList<>();
        while(pointer2 < s.length()) {
            while(pointer2 - pointer1 + 1 <= p.length()) {
                if(pointer2 >= s.length()) break;
                char c = s.charAt(pointer2++);
                currentVal[c - 'a']++;
            }
            
            String concatString = "";
            for(int c : currentVal) {
                concatString += c;
            }
            
            if(concatString.equals(targetStr)) {
                result.add(pointer1);
            }
            
            char c = s.charAt(pointer1++);
            currentVal[c - 'a']--;
        }
        return result;
    }
}