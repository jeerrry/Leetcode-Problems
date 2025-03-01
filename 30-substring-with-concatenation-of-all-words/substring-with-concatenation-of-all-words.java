class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return result;

        int wordSize = words[0].length();
        int wordCount = words.length;
        int windowSize = wordSize * wordCount;

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordSize; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();

            while (right + wordSize <= s.length()) {
                String word = s.substring(right, right + wordSize);
                right += wordSize;

                if (wordFreq.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordSize);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordSize;
                        count--;
                    }

                    if (count == wordCount) result.add(left);
                } else {
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}
