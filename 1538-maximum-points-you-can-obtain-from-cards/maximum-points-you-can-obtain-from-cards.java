class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int result = 0;
        for(int i=0; i<k; i++) result += cardPoints[i];

        int start = k - 1;
        int n = cardPoints.length - 1;
        int tresult = result;
        for(int i=0; i<k; i++) {
            tresult -= cardPoints[start--];
            tresult += cardPoints[n - i];

            result = Math.max(result, tresult);
        }

        return result;
    }
}