package org.leetcode.solutions;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0, j = 0; i < board.length && j < board[0].length; i++, j++) {
            if (i % 3 == 0) {
                if (!validateGird(board)) {
                    return false;
                }
            }
            if (!validateRowAndColumn(board)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateRowAndColumn(char[][] board) {
        return true;
    }

    private boolean validateGird(char[][] board) {
        return true;
    }
}
