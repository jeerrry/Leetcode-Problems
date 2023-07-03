class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        
        // Populate hashmap with character frequency
        for(char c : s.toCharArray()){
            if(charFrequency.containsKey(c)){
                int currentValue = charFrequency.get(c);
                charFrequency.put(c, currentValue + 1);
            }else{
                charFrequency.put(c, 1);
            }
        }
        
        for(char c : t.toCharArray()){
            if(charFrequency.containsKey(c)){
                int currentFrequency = charFrequency.get(c) - 1;
                if(currentFrequency > 0){
                    charFrequency.put(c, currentFrequency);
                }else {
                    charFrequency.remove(c);
                }
            } else {
                return false;
            }
        }
        
        return charFrequency.isEmpty();
    }
}