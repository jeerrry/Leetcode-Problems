class Solution {
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        
        for(int i=0; i<nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strArr, new Comparator<String>() {
            public int compare(String a, String b) {
                String n1 = a + b, n2 = b + a;
                return n2.compareTo(n1);
            }
        });
        
        if(strArr[0].equals("0")) return "0";
        
        StringBuilder builder = new StringBuilder();
        for(String val : strArr) {
            builder.append(val);
        }
        
        return builder.toString();
    }
}