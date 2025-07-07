class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            var rowHashSet = new HashSet<Character>();
            var colHashSet = new HashSet<Character>();
            for(int j=0; j<9; j++) {
                Character rowVal = board[i][j];
                Character colVal = board[j][i];

                if(rowVal != '.' && rowHashSet.contains(rowVal)) return false;
                if(colVal != '.' && colHashSet.contains(colVal)) return false;
                
                rowHashSet.add(rowVal);
                colHashSet.add(colVal);
            }
        }

        for(int i=0; i<9; i+=3) {
            for(int j=0; j<9; j+=3) {
                var set = new HashSet<Character>();
                for(int k=i; k<i+3; k++) {
                    for(int z=j; z<j+3; z++) {
                        if(board[k][z] == '.') continue;
                        if(set.contains(board[k][z])) return false;
                        set.add(board[k][z]);
                    }
                }
            }
        }

        return true;
    }
}