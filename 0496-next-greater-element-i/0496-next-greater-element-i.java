class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var map = new HashMap<Integer, Integer>();
        var result = new int[nums1.length];
        var stack = new Stack<Integer>();
        
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], i);
        }
        
        for(int num : nums2) {
            if(map.containsKey(num)){
                // Process Stack
                while(stack.size() > 0 && stack.peek() < num){
                    int stackValue = stack.pop();
                    int index = map.get(stackValue);
                    result[index] = num;
                }
                
                stack.push(num);
                
            }else {
                // Process Stack
                
                while(stack.size() > 0 && stack.peek() < num){
                    int stackValue = stack.pop();
                    int index = map.get(stackValue);
                    result[index] = num;
                }
            }
        }
        
        while(stack.size() > 0){
            int stackValue = stack.pop();
            int index = map.get(stackValue);
            result[index] = -1;
        }
        
        return result;
    }
}