package solutions;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 * @Author: Zuo Yichen
 * @Date: 2019/1/27 10:42
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int row = matrix.length;
        int width = matrix[0].length;
        if (row == 0 || width == 0) {
            return false;
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] > target) {
                return false;
            }
            if (matrix[i][0] < target && matrix[i][width - 1] > target) {
                return binarySearch(matrix[i], target);
            }
            if (matrix[i][0] == target || matrix[i][width - 1] == target) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            // in case high + low is overflow
            int mid = (high - low) / 2 + low;
            if (array[mid] == target) {
                return true;
            }
            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        new Search2DMatrix().searchMatrix(matrix, target);
    }
}

