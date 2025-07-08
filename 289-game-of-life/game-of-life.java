class Solution {
    public void gameOfLife(int[][] board) {
        var dict = new HashMap<String, Integer>();
        dict.put("00", 0);
        dict.put("10", 1);
        dict.put("01", 2);
        dict.put("11", 3);

        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int val = board[i][j];
                int oneCount = 0;
                int zeroCount = 0;

                for(int[] nbr : dirs) {
                    int nrow = nbr[0] + i;
                    int ncol = nbr[1] + j;

                    if(nrow < 0 || nrow >= board.length) continue;
                    if(ncol < 0 || ncol >= board[0].length) continue;
                    
                    int cval = board[nrow][ncol];
                    if(cval == 1 || cval == 3) {
                        oneCount++;
                    }else {
                        zeroCount++;
                    }
                }

                if(val == 0 && oneCount == 3) {
                    board[i][j] = 2;
                }
                else if(val == 1 && (oneCount == 2 || oneCount == 3)) {
                    board[i][j] = 3;
                } else if(val == 1 && (oneCount < 2 || oneCount > 3)) {
                    board[i][j] = 1;
                }
                else {
                    board[i][j] = 0;
                }
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int val = board[i][j];

                if(val == 2 || val == 3) {
                    board[i][j] = 1;
                }else {
                    board[i][j] = 0;
                }
            }
        }
    }
}