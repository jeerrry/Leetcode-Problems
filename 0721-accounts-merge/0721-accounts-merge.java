class Solution {
    int[] parent;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new int[10001];
        for(int i=0; i<10001; i++) {
            parent[i] = i;
        }
        
        HashMap<String, Integer> euid = new HashMap<>();
        HashMap<String, String> etn = new HashMap<>();
        int id = 0;
        for(List<String> account : accounts) {
            String name = "";
            
            for(String email : account) {
                if(name == "") {
                    name = email;
                    continue;
                }
                
                if(!euid.containsKey(email)){
                    euid.put(email, id++);
                }
                
                if(!etn.containsKey(email)) {
                    etn.put(email, name);
                }
                
                int e1uid = euid.get(account.get(1));
                int cuid = euid.get(email);
                
                int p1 = findPar(e1uid);
                int p2 = findPar(cuid);
                
                if(p1 != p2) {
                    parent[p2] = p1;
                }
            }
        }
        
        HashMap<Integer, List<String>> pte = new HashMap<>();
        for(String email : etn.keySet()) {
            int uid = euid.get(email);
            int par = findPar(uid);
            
            if(pte.containsKey(par)) {
                pte.get(par).add(email);
            }else {
                pte.put(par, new ArrayList<>());
                pte.get(par).add(email);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(List<String> emails : pte.values()) {
            Collections.sort(emails);
            
            List<String> tp = new ArrayList<>();
            String email = emails.get(0);
            String name = etn.get(email);
            
            tp.add(name);
            for(String ee : emails) {
                tp.add(ee);
            }
            
            ans.add(tp);
        }
        
        return ans;
    }
    
    private int findPar(int x) {
        if(parent[x] == x) return x;
        
        return parent[x] = findPar(parent[x]);
    }
}