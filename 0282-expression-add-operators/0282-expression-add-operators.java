class Solution {
    public List<String> addOperators(String num, int target) {
        var result = new ArrayList<String>();
        
        helper(0, 0, 0, num, target, "", result);
        
        return result;
    }
    
    private void helper(int index, long lastVal, long totalVal, String num, long target, String eq, List<String> result) {
        // Write Base Case
        if(index == num.length()) {
            if(lastVal + totalVal == target) {
                result.add(eq);
            }
            return;
        }
        
        int end = num.length();
        if(num.charAt(index) == '0') {
            end = index + 1;
        }
        
        for(int i=index + 1; i <= end; i++) {
            long currentNumber = Long.valueOf(num.substring(index, i));
            if(index == 0) {
                helper(i, currentNumber, 0, num, target, String.valueOf(currentNumber), result);
                continue;
            }
            
            // +
            helper(i, currentNumber, totalVal + lastVal, num, target, eq + "+" + currentNumber, result);
            
            // -
            helper(i, -currentNumber, totalVal + lastVal, num, target, eq + "-" + currentNumber, result);
            
            // *
            helper(i, currentNumber * lastVal, totalVal, num, target, eq + "*" + currentNumber, result);
        }
    }
}