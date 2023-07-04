class Solution {
    public int[] replaceElements(int[] arr) {
        if(arr.length == 0){
            return new int[0];
        }
        
        int[] result = new int[arr.length];
        for(int i=1; i<arr.length; i++){
            int maxNum = arr[i];
            for(int j=i+1; j<arr.length; j++){
                maxNum = Math.max(maxNum, arr[j]);
            }
            result[i-1] = maxNum;
        }
        
        result[result.length - 1] = -1;
        
        return result;
    }
}