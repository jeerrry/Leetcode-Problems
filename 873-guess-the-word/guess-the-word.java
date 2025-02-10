/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        var set = new HashSet<>(Arrays.asList(words));

        for(int count=0; count < 30 && !set.isEmpty(); count++) {
            String first = set.stream().findFirst().orElse(null);
            int matches = master.guess(first);
            if(matches == 6) break;
            var iter = set.iterator();
            while(iter.hasNext()) {
                var val = iter.next();
                if(countMatches(first, val) != matches) {
                    iter.remove();
                }
            }
        }
    }

    private int countMatches(String one, String two) {
        int count = 0;
        for(int i=0; i<one.length(); i++) {
            if(one.charAt(i) == two.charAt(i)) count++;
        }

        return count;
    }
}