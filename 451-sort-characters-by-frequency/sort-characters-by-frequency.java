class Solution {
    public String frequencySort(String s) {
        var map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            int current = map.getOrDefault(c, 0) + 1;
            map.put(c, current);
        }

        int maxFreq = s.length();
        List<Character>[] buckets = new ArrayList[maxFreq + 1];
        for(char key : map.keySet()) {
            int freq = map.get(key);
            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<Character>();
            }

            buckets[freq].add(key);
        }

        var builder = new StringBuilder();
        for(int i=maxFreq; i > 0; i--) {
            if(buckets[i] == null) continue;
            for(char c : buckets[i]) {
                for(int j=0; j<i;j++){
                    builder.append(c);
                }
            }
        }

        return builder.toString();
    }
}