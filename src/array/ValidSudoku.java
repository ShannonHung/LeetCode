package array;

import java.util.HashSet;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet();

        for(int i=0; i<board.length; i++){
            for(int j=0; j< board.length; j++){
                char current_val = board[i][j];
                if(current_val!='.') {
                    if(!seen.add(current_val + " found in row " + i) ||
                    !seen.add(current_val + " found in column " + j) ||
                    !seen.add(current_val + " found in sub box " + i/3 + "-" + j/3)) return false;
                }
            }
        }
        return true;
    }
    public static boolean bestSpeedSolution(char[][] board) {
        int n = board.length ,m = board[0].length;
        for(int i =0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(board[i][j]!='.') {
                    if(callfun(i,j,board)) return false;
                }
            }
        }
        return true;
    }
    public static boolean callfun(int row , int col,char board[][]) {
        int count =0;
        for(int i =0;i<9;i++) {
            if(board[row][i] ==board[row][col]) count++;
            if(board[i][col] ==board[row][col]) count++;
        }
        for(int i =(row/3)*3;i<(row/3)*3+3;i++ ) {
            for(int j =(col/3)*3;j<(col/3)*3+3;j++ ) {
                if(board[i][j]==board[row][col]) count++;
            }
        }
        return count!=3;
    }
    public static void main(String args[]){
        char[][] board =
        {{'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};
        isValidSudoku(board);
        System.out.println(bestSpeedSolution(board));
        
    }
}
