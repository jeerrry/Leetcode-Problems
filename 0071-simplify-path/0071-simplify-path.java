class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        stack.push("/");
        
        for(int i=0; i<path.length();) {
            StringBuilder input = new StringBuilder();
            input.append(""+path.charAt(i));
            
            
            switch(input.toString()) {
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
                            input = new StringBuilder(current + input.toString());
                            i++;
                        }
                    }
                    
                    if(input.toString().equals(".")) {
                        continue;
                    }else if(input.toString().equals("..")){
                        if(stack.size() > 1){
                            stack.pop();
                            stack.pop();
                        }
                    }else{
                        stack.push(input.toString());
                    }
                    break;
                default:
                    i++;
                    while(i < path.length()){
                        char current = path.charAt(i);
                        if(current == '/') break;
                        else {
                            input = new StringBuilder(current + input.toString());
                            i++;
                        }
                    }
                    
                    stack.push(input.toString());
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