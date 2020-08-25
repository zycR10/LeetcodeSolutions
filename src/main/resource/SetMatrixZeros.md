# SetMatrixZeros

## 题目
Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
给以 m*n 的矩阵，如果某个元素是0的话，就把元素所在的列和行都置0，使用原地算法解决。

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
简单粗暴的算法使用O(mn)的额外空间，这个方法不太好
A simple improvement uses O(m + n) space, but still not the best solution.
稍加改进后使用O(m + n)也不太好
Could you devise a constant space solution?
请你设计一个使用常量空间的解决方案
 
## 思路 
注意题目要求，是要原地排序算法，所以不使用额外空间完成这道题，其实这反而是个突破点，不使用额外空间说明也没什么好办法了，只能想办法在遍历的
过程中搞定置零，一拍脑袋就开始写代码，发现好像不难？对二维数组遍历，碰到0的时候就把所在行都变成0，所在列也都变成0，写完一跑不对，有些位置本来不是0，
被我们置零了之后，等遍历到这一位的时候又按照碰到0处理了，但其实本来不是0。解决简不简单？太简单了，说明我们一边遍历一遍置零不行，为什么不行？
因为影响后面遍历的结果了，那怎么能不影响后面的结果呢？很简单，从后往前来，前面碰到0先不要操作，继续往下走，一直走到最后，然后慢慢的一层一层
往回置零不就可以了吗？这算法熟悉不？其实就是深度优先，代码很简单，直接上实现了。

## 实现 
```
    public void setZeroes(int[][] matrix) {
        setZeroes(matrix, 0, 0);
    }

    private void setZeroes(int[][] matrix, int row, int column) {
        for (row = row; row < matrix.length; row++) {
            for (column = column; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    setZeroes(matrix, row, column + 1);
                    Arrays.fill(matrix[row], 0);

                    for (int index = 0; index < matrix.length; index++) {
                        matrix[index][column] = 0;
                    }
                    return;
                }
            }
            column = 0;
        }
    }
```