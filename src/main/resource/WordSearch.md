# WordSearch

## 题目
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
给一个二维数组和一个单词，判断该单词是否在数组中
单词由数组中相邻的元素组成，相邻可以理解为上下左右的所有相邻元素，同一个字母只能使用一次

Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 
## 思路 
一看这题什么二维数组，拼接字符，寻找是否存在，是不是脑中闪过了各种算法？动态规划行不行？怎么高效操作字符？有没有什么特殊的技巧？
没有，谢谢。最直接高效的就是你第一个所想到的暴力搜索。。
有一个要注意的点，因为已使用过的位置不能再使用了，所以在遍历的过程中我们要记录哪些元素正在使用，有一个优化的点就是可以用元素与256做异或运算，
这是什么道理呢？因为java中一个字符是两个字节(byte)也就是八位(bit)，所以转成二进制表示的范围是00000000-11111111，而256转二进制是100000000，
由于是做异或处理，所以处理后的范围是100000000-111111111，也就是说肯定不会是char所表示的字符了，那么后面我们再判断也不会为相等，相当于原地算法，
节省了额外的存储空间

## 实现 
```
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, y, x, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) {
            return true;
        }
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
            return false;
        }
        if (board[y][x] != word[i]) {
            return false;
        }
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x + 1, word, i + 1)
                || exist(board, y, x - 1, word, i + 1)
                || exist(board, y + 1, x, word, i + 1)
                || exist(board, y - 1, x, word, i + 1);
        board[y][x] ^= 256;
        return exist;
    }
```