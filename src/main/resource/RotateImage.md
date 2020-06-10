# Rotate Image

## 题目
You are given an n x n 2D matrix representing an image.
给定一个n阶2维数组，你可以把它想象成一个图片
Rotate the image by 90 degrees (clockwise).
要求顺时针旋转九十度
Note:
注意：
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
类似于原地排序，本题要求原地旋转，即不能使用额外的存储空间，通过另一个二维数组来进行辅助操作

## 思路
题目中真正有用的信息只有两点，1.要求按顺时针旋转数组；2.原地旋转，即不能使用额外存储空间。由于是n*n数组，所以其实非常简单，每次旋转后的横纵坐标都是前后有关联的，例如一个4*4的数组，我们以（0，1）这个位置作为参考点，右旋90度的新坐标为（1，3），即原纵坐标变为新横坐标，用（数组长度 - 1）减去原横坐标得到新纵坐标，以此类推（1，3）再次右旋90度坐标为（3，2），再次旋转为（2，0），不难发现，每次新坐标都是由前一次的横纵坐标互换或者相减获得，推导出了这个规律，那我们只需要转化为代码即可

## 实现
方法一：
```
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i <= n / 2; i++) {
            for (int j = i; j < (n - i); j++) {
                // 依次顺时针旋转，每次使用tmp做临时存储原数据
                int tmp = matrix[j][n - i];
                matrix[j][n - i] = matrix[i][j];
                matrix[i][j] = tmp;

                tmp = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[i][j];
                matrix[i][j] = tmp;

                tmp = matrix[n - j][i];
                matrix[n - j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
```

方法二：
```
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // 方法二的代码更加简洁，是用逆时针的方式反向旋转，这样避免了每次都要利用tmp存储
                // 只需要利用tmp保存第一个位置的值，在其他三边全部完成后将tmp再填入就可以了
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }
```