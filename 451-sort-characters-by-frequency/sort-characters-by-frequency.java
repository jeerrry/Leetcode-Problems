class Solution {
    public String frequencySort(String s) {
        var map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        var pq = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        var result = new StringBuilder();
        while(!pq.isEmpty()) {
            var val = pq.remove();
            for(int i=0; i<val.getValue(); i++) {
                result.append(val.getKey());
            }
        }

        return result.toString();
    }
}