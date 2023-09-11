class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeArrays(nums1, nums2);
        
        if(mergedArray.length % 2 == 1) {
            return mergedArray[mergedArray.length/2];
        }else {
            int val1 = mergedArray[(mergedArray.length/2) - 1];
            int val2 = mergedArray[(mergedArray.length/2)];

            return (val1 + val2)/(double)2;
        }
    }
    
    private int[] mergeArrays(int[] nums1, int[] nums2){
        int p1 = 0;
        int p2 = 0;
        int cIndex = 0;
        
        int[] merged = new int[nums1.length + nums2.length];
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] <= nums2[p2]){
                merged[cIndex++] = nums1[p1++];
            }else {
                merged[cIndex++] = nums2[p2++];
            }
        }
        
        while(p1 < nums1.length) {
            merged[cIndex++] = nums1[p1++];
        }
        
        while(p2 < nums2.length) {
            merged[cIndex++] = nums2[p2++];
        }
        
        return merged;
    }
}