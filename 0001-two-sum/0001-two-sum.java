class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 || nums.length == 1){
            return new int[0];
        }

        
        HashMap<Integer, Integer> values = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            if(values.containsKey(target-val)){
                int[] result = new int[2];
                result[1] = i;
                result[0] = values.get(target-val);

                return result;
            }else{
                values.put(val, i);
            }
        }

        return new int[0];
    }
}