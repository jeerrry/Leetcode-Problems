class Solution {
    public int maxNumberOfBalloons(String text) {
        var targetString = "balloon";
        if(text.length() < targetString.length()) return 0;
        var pFreq = new int[26];
        for(int i=0; i<text.length(); i++) {
            int index = text.charAt(i) - 'a';
            pFreq[index]++;
        }

        int result = 0;
        while(true) {
            for(int i=0; i<targetString.length(); i++) {
                int index = targetString.charAt(i) -  'a';
                if(pFreq[index] == 0) {
                    return result;
                }

                pFreq[index]--;
            }

            result++;
        }
    }
}