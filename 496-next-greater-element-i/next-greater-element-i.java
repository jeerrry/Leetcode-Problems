class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var stack = new Stack<Integer>();
        var map = new HashMap<Integer, Integer>();
        for(int val : nums1) map.put(val, -1);

        for(int i=nums2.length - 1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            int nge = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);

            if(map.containsKey(nums2[i])) map.put(nums2[i], nge);
        }

        var result = new int[nums1.length];
        for(int i=0; i<result.length; i++) result[i] = map.get(nums1[i]);

        return result; 
    }
}