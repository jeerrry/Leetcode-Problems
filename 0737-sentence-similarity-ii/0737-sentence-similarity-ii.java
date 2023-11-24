class Solution {
    private HashMap<String, String> parent;
    private HashMap<String, Integer> rank;
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        rank = new HashMap<>();
        parent = new HashMap<>();
        if (sentence1.length != sentence2.length) {
          return false;
        }
        parent = new HashMap<>();
        for (List<String> p : similarPairs) {
          union(p.get(0), p.get(1));
        }

        for (int i = 0; i < sentence1.length; i++) {
          if (!sentence1[i].equals(sentence2[i]) && !find(sentence1[i]).equals(find(sentence2[i]))) {
            return false;
          }
        }
        return true;
    }
    
      public String find(String s) {
    if (!parent.containsKey(s)) {
      parent.put(s, s);
      rank.put(s, 1);
    }

    if (s.equals(parent.get(s))) {
      return s;
    }
    String temp = find(parent.get(s));
    parent.put(s, temp);
    return temp;
  }

  public void union(String x, String y) {
    String lx = find(x);
    String ly = find(y);

    if (lx.equals(ly) == false) {
      if (rank.get(lx) > rank.get(ly)) {
        parent.put(ly, lx);
      } else if (rank.get(lx) < rank.get(ly)) {
        parent.put(lx, ly);
      } else {
        parent.put(lx, ly);
        rank.put(ly, rank.get(ly) + 1);
      }
    }
  }
}