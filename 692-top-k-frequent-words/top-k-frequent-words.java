class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Arrays.sort(words);
        var map = new HashMap<String, Integer>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int maxFreq = words.length;
        Set<String>[] freqs = new HashSet[maxFreq + 1];
        for(String word : words) {
            int freq = map.get(word);
            if(freqs[freq] == null) {
                freqs[freq] = new LinkedHashSet<String>();
            }

            freqs[freq].add(word);
        }

        List<String> result = new ArrayList<>();
        for(int i=maxFreq; i>0 && k > 0; i--) {
            if(freqs[i] == null) continue;
            result.addAll(freqs[i]);
            k-=freqs[i].size();
        }

        while(k++<0 && result.size() > 0) result.remove(result.size() - 1);

        return result;
    }
}