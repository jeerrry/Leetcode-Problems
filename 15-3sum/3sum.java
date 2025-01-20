class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int i=0; i<n - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int num1 = nums[i];
            int p1 = i + 1, p2 = n - 1;
            while(p1 < p2) {
                int num2 = nums[p1];
                int num3 = nums[p2];
                int sum = num1 + num2 + num3;
                if(sum == 0) {
                    var temp = new ArrayList<Integer>();
                    temp.add(num1);
                    temp.add(num2);
                    temp.add(num3);
                    result.add(temp);

                    while(p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                    while(p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;
                    p1++;
                    p2--;
                }else if(sum > 0) {
                    p2--;
                }else {
                    p1++;
                }
            }
        }

        return result;
    }
}