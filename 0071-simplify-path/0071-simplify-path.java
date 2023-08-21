class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        stack.push("/");
        
        for(int i=0; i<path.length();) {
            String input = "" + path.charAt(i);
            
            
            switch(input) {
                case "/":
                    if(!stack.peek().equals("/")){
                        if(i != path.length()-1){
                            stack.push("/");
                        }
                    }
                    i++;
                    break;
                case ".":
                    i++;
                    while(i < path.length()){
                        char current = path.charAt(i);
                        if(current == '/') break;
                        else {
                            input = current + input;
                            i++;
                        }
                    }
                    
                    if(input.equals(".")) {
                        continue;
                    }else if(input.equals("..")){
                        if(stack.size() > 1){
                            stack.pop();
                            stack.pop();
                        }
                    }else{
                        stack.push(input);
                    }
                    break;
                default:
                    i++;
                    while(i < path.length()){
                        char current = path.charAt(i);
                        if(current == '/') break;
                        else {
                            input = current + input;
                            i++;
                        }
                    }
                    
                    stack.push(input);
                    break;
            }            
        }
        
        StringBuilder result = new StringBuilder();
        
        if(stack.size() > 1 && stack.peek().equals("/"))stack.pop();
        while(stack.size() > 0) {
            result.append(stack.pop());
        }
        
        return result.reverse().toString();
    }
}