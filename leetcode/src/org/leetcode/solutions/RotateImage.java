package org.leetcode.solutions;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * <p>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @Author: Zuo Yichen
 * @Date: 2018/12/25 17:46
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int half = matrix.length / 2;
        for(int i=0; i < half; i++) {
            rotateColumn(matrix, i);
        }
    }

    private void rotateColumn(int[][] matrix, int i) {
        int size = matrix.length;
        int[] left = new int[size];
        int[] right = new int[size];
        int[] up = new int[size];
        int[] down = new int[size];
        int[] temp = new int[size];
        int[] temp2 = new int[size];
        for(int j = 0; j < size; j++) {
            left[j] = matrix[size - j - 1][i];
            right[j] = matrix[size - j - 1][size - i - 1];
            up[j] = matrix[i][j];
            down[j] = matrix[size - i - 1][j];
        }
        temp = up;
        up = left;
        left = temp;
        temp = down;
        down = right;
        right = left;
        left = temp;
        for(int j = 0; j < size; j++) {
            matrix[j][i] = left[j];
            matrix[j][size - i - 1] = right[j];
            matrix[i][j] = up[j];
            matrix[size - i - 1][j] = down[j];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int[] one = {1,2,3};
        int[] two = {4,5,6};
        int[] three = {7,8,9};
        matrix[0] = one;
        matrix[1] = two;
        matrix[2] = three;
        new RotateImage().rotate(matrix);
    }
}
