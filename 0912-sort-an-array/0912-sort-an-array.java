class Solution {
    public int[] sortArray(int[] nums) {
        var result = mergeSort(nums, 0, nums.length-1);
        
        return result;
    }
    
    private int[] mergeSort(int[] nums, int low, int high) {
        if (low == high) {
            int[] result = new int[1];
            result[0] = nums[low];
            return result;
        }
        
        int mid = (low + high) / 2;
        int[] arr1 = mergeSort(nums, low, mid);
        int[] arr2 = mergeSort(nums, mid+1, high);
        
        int[] mergedArray = mergeArrays(arr1, arr2);
        
        return mergedArray;
    }
    
    private int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        
        int rIndex = 0, i=0, j=0;
        for(;i<arr1.length && j < arr2.length;) {
            int val1 = arr1[i];
            int val2 = arr2[j];
            
            if(val1 == val2) {
                result[rIndex++] = val1;
                result[rIndex++] = val2;
                i++;
                j++;
            }else if(val1 < val2) {
                result[rIndex++] = val1;
                i++;
            }else {
                result[rIndex++] = val2;
                j++;
            }
        }
        
        for(;i<arr1.length; i++) {
            result[rIndex++] = arr1[i];
        }
        
        for(;j<arr2.length; j++) {
            result[rIndex++] = arr2[j];
        }
        
        return result;
    }
}