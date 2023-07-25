class Solution {
    public String pushDominoes(String dominoes) {
        int right = -1;
        char[] dom = dominoes.toCharArray();
        
        for(int i=0; i<dominoes.length(); i++) {
            if(dom[i] == 'L') {
                if(right == -1) {
                    for(int j=i-1; j >=0 && dom[j] == '.'; j--) {
                        dom[j] = 'L';
                    }
                }else {
                    for(int j=right+1, k=i-1; j < k; j++, k--) {
                        dom[j] = 'R';
                        dom[k] = 'L';
                    }
                    
                    right = -1;
                }
            }else if(dom[i] == 'R') {
                if(right != -1) {
                    for(int j = right + 1; j<i; j++) {
                        dom[j] = 'R';
                    }
                }
                right = i;
            }
        }
        
        for(int i = right + 1; right != -1 && i<dom.length; i++) {
            dom[i] = 'R';
        }
        
        StringBuilder builder = new StringBuilder();
        for(char c : dom) {
            builder.append(c +"");
        }
        
        return builder.toString();
    }
}