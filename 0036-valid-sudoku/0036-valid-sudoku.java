class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++) {
            HashSet<Character> rowHash = new HashSet<>();
            HashSet<Character> colHash = new HashSet<>();
            
            // Validate Row
            for(int j=0; j<board.length;j++) {
                Character rowVal = board[i][j];
                Character colVal = board[j][i];
                
                if(rowVal != '.' && rowHash.contains(rowVal)) return false;
                rowHash.add(rowVal);
                
                if(colVal != '.' && colHash.contains(colVal)) return false;
                colHash.add(colVal);
            }
        }
        
        for (int i=0; i<9; i+=3) {
            for(int j=0; j<9; j+=3) {
                HashSet<Character> blockHash = new HashSet<>();
                for(int k=i; k<i+3;k++) {
                    for (int z=j; z<j+3; z++) {
                        if(board[k][z] == '.') continue;
                        
                        if(blockHash.contains(board[k][z])) return false;
                        
                        blockHash.add(board[k][z]);
                    }
                }
                
            }
        }
        
        return true;
    }
}