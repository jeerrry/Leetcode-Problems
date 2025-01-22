class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = 0, element2 = 0;
        int count1 = 0, count2 = 0;
        var result = new ArrayList<Integer>();

        for(int val : nums) {
            if(count1 == 0 && val != element2) {
                element1 = val;
                count1=1;
            }else if(count2 == 0 && val != element1) {
                element2 = val;
                count2=1;
            }else if(val == element1) {
                count1++;
            }else if(val == element2) {
                count2++;
            }else {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int val : nums) {
            if(val == element1) {
                count1++;
                continue;
            }

            if(val == element2) {
                count2++;
            }
        }

        if(count1 > nums.length/3) result.add(element1);
        if(count2 > nums.length/3) result.add(element2);

        return result;
    }
}