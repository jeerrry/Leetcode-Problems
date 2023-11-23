class Solution {
    int[] parent;
    private int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        for(int[] swaps : allowedSwaps) {
            int a = swaps[0];
            int b = swaps[1];
            
            int p1 = find(a);
            int p2 = find(b);
            
            if(p1 != p2) {
                parent[p2] = p1;
            }
        }
        
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            int num = source[i];
            int root = find(i);
            
            map.putIfAbsent(root, new HashMap<>());
            HashMap<Integer, Integer> component = map.get(root);
            int freq = component.getOrDefault(num, 0);
            component.put(num, freq + 1);
        }
        
        int ans = 0;
        for(int i=0; i<n; i++) {
            int num = target[i];
            int root = find(i);
            
            HashMap<Integer, Integer> component = map.get(root);
            int freq = component.getOrDefault(num, 0);
            if(freq == 0) {
                ans++;
                continue;
            }
            
            component.put(num, freq - 1);
        }
        
        return ans;
    }
}