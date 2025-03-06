class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, ArrayList<String>>();

        for(String str : strs) {
            var hash = getHash(str);
            var list = map.getOrDefault(hash, new ArrayList<String>());

            list.add(str);
            map.put(hash, list);
        }

        List<List<String>> result = new ArrayList<>();

        for(var val : map.keySet()) {
            result.add(map.get(val));
        }

        return result;
    }

    private String getHash(String key) {
        var freq = new int[26];
        for(int i=0; i<key.length(); i++) {
            freq[key.charAt(i) - 'a']++;
        }

        return Arrays.toString(freq);
    }
}