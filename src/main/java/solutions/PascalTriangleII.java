package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 * <p>
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @Author: Zuo Yichen
 * @Date: 2019/11/6 12:04
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return null;
        }
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int i = 0; i < rowIndex; i++) {
            row.add(0,1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }

    public static void main(String[] args) {
        new PascalTriangleII().getRow(3);
    }
}
