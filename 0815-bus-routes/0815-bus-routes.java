class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0; i<routes.length; i++) {
            for(int j=0; j<routes[i].length; j++) {
                int route = routes[i][j];
                
                if(map.containsKey(route)) {
                    map.get(route).add(i);
                    continue;
                }
                
                var list = new ArrayList<Integer>();
                list.add(i);
                map.put(route, list);
            }
        }
        
        HashSet<Integer> vbus = new HashSet<>();
        HashSet<Integer> vstop = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int busCount = 0;
        
        queue.add(source);
        vstop.add(source);
        
        while(queue.size() > 0) {
            int size = queue.size();
            
            while(size-->0) {
                int stop = queue.remove();
                
                if(stop == target) return busCount;
                
                ArrayList<Integer> busses = map.get(stop);
                for(int bus : busses) {
                    if(vbus.contains(bus)) continue;
                    int[] stops= routes[bus];
                    
                    for(int cstop : stops) {
                        if(vstop.contains(cstop)) continue;
                        
                        vstop.add(cstop);
                        queue.add(cstop);
                    }
                    vbus.add(bus);
                }
            }
            
            busCount++;
        }
        
        return -1;
    }
}