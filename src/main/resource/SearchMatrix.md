# SearchMatrix

## 题目
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
在一个 m * n 的二维数组中搜索是否存在某个元素
数组中的数字从左至右已排列好
每行的第一个数字都大于上一行的最后一个数字

Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 
## 思路 
奇怪的题。。。真的好简单啊，简单到我都不忍心写思路了，最直接的搜索也能beat 100%，当然了，可能是因为测试用例的数据量不足，实际上在每一行
搜索的时候可以用二分查找
还有一种稍微优化了一些的办法，可以从二维数组的左下角开始找，由于数组递增排列，所以从左下角开始，如果大于target，那么往上移动一行，如果小于
target，那么开始往右移动寻找，这样比较次数可以稍微少一些

## 实现
```
solution I:
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ) {
                    return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][column - 1]) {
                for (int j = 0; j < column; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
    
solution II:

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] > target) {
                row--;
            } else if (matrix[row][column] < target && column < matrix[row].length) {
                column++;
            } else {
                return true;
            }
        }
        return false;
    }
``` 
