class Solution {
    private Map<String, Boolean> dict = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        if(dict.containsKey(s) && ! dict.get(s)) return false;

        for(String word : wordDict) {
            if(s.indexOf(word) == 0) {
                int length = word.length();
                if(wordBreak(s.substring(length, s.length()), wordDict)) {
                    return true;
                }
            }
        }

        dict.put(s, false);

        return false;
    }
}