class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        
        StringBuilder contextString = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char current = s.charAt(i);
            
            if(Character.isDigit(current) || current == '[' || current == ']'){
                if(contextString.length() > 0) {
                    stack.push(contextString.toString());
                    contextString = new StringBuilder();
                }
            }
            
            if(Character.isDigit(current)) {
                String pushedNum = "";
                if(stack.size() > 0){
                    boolean isNumeric = stack.peek().chars().allMatch( Character::isDigit );
                    if(isNumeric){
                        pushedNum = stack.pop() + current;
                        stack.push(pushedNum);
                    }else {
                        stack.push(current+"");
                    }
                }else {
                    stack.push(current+"");
                }
            }else if(Character.isLetter(current)){
                contextString.append(current);
                
                if(i == s.length() - 1){
                    stack.push(contextString.toString());
                }
            }else {
                if(current == '[') {
                    stack.push(current+"");
                }else {
                    contextString = new StringBuilder();
                    var temp = new StringBuilder();
                    while(!stack.peek().equals("[")) {
                        temp.insert(0, stack.pop());
                    }
                    
                    stack.pop();
                    int count = Integer.parseInt(stack.pop());
                    for(int j=1; j<=count; j++){
                        contextString.append(temp.toString());
                    }
                    stack.push(contextString.toString());
                    contextString = new StringBuilder();
                }
            }
        }
        
        contextString = new StringBuilder();
        while(stack.size() > 0) {
            contextString.insert(0, stack.pop());
        }
        
        return contextString.toString();
    }
}