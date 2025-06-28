class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int currentMax = values[0];
        int result = 0;

        for(int i=1; i<values.length; i++) {
            result = Math.max(result, currentMax + values[i] - i);
            currentMax = Math.max(currentMax, values[i] + i);
        }

        return result;
    }
}