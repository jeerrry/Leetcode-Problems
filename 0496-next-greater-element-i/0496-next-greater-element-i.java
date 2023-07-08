class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        
        for(int i=0; i<nums1.length; i++){
            int currentNumber = nums1[i];
            boolean found = false;
            
            for(int j=0; j<nums2.length; j++){
                if(!found && nums2[j] == currentNumber) {
                    found = true;
                }
                
                if(found && nums2[j] > currentNumber) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        
        return result;
    }
}