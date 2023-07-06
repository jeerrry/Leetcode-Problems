class Solution {
    public int numUniqueEmails(String[] emails) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        int uniqueEmail = 0;
        
        for(String email : emails) {
            String[] address = email.split("@");
            String user = address[0];
            String domain = address[1];
            
            if(user.contains("+")){
                user = user.split("\\+")[0];
            }
            
            if(user.contains(".")){
                user = user.replace(".", "");
            }
            
            map.computeIfAbsent(domain, k -> new HashSet<>());
            var temp = map.get(domain);
            
            if(!temp.contains(user)){
                temp.add(user);
                uniqueEmail += 1;
            }
        }
        
        return uniqueEmail;
    }
}