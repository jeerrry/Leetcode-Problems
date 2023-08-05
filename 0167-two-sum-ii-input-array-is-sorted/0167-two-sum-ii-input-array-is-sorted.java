class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pointer1 = 0;
        int pointer2 = numbers.length - 1;
        
        while(pointer1 < pointer2) {
            int val1 = numbers[pointer1];
            int val2 = numbers[pointer2];
            
            if(val1 + val2 == target) {
                return new int[] {pointer1 + 1, pointer2 + 1};
            }else if(val1 + val2 > target) {
                pointer2--;
            }else {
                pointer1++;
            }
        }
        
        return new int[2];
    }
}