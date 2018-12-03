package org.leetcode.solutions;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0) {
                if (!validateGird(board, i)) {
                    return false;
                }
            }
            if (!validateRowAndColumn(board, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateRowAndColumn(char[][] board, int n) {
        char[] row = board[n];
        char[] valid = new char[9];
        int index = 0;
        for (int i = 0; i < row.length; i++) {
            index = row[i] - '1';
            if (Character.isDigit(valid[index])) {
                return false;
            } else {
                valid[index] = row[i];
            }
        }
        return true;
    }

    private boolean validateGird(char[][] board, int n) {
        int index = 0;
        char[] gird = new char[9];
        for (int i = 0; i < 3; i++, n++) {
            for (int j = 0; j < 3; j++) {
                index = board[n][n] - '1';
                if (Character.isDigit(gird[index])) {
                    return false;
                } else {
                    gird[index] = board[n][n + j];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] c = new char[10];
        c[3] = '8';
        System.out.println(Character.isDigit(c[3]));
    }
}
