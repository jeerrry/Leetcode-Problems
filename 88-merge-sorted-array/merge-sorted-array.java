class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int index = 0;
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                result[index++] = nums1[i++];
            }else {
                result[index++] = nums2[j++];
            }
        }

        while(i < m) {
            result[index++] = nums1[i++];
        }

        while(j < n) {
            result[index++] = nums2[j++];
        }

        for(i = 0; i<result.length; i++) nums1[i] = result[i];
    }
}