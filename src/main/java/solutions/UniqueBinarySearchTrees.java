package solutions;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @Author: Zuo Yichen
 * @Date: 2019/4/22 12:13
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        // core idea is which element is root
        // smallest element is root, left subtree is null
        // biggest element is root, right subtree is null
        // others assume root is a, left subtree is f(a - 1), right subtree is f(n - a)
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                array[i] += array[j - 1] * array[i - j];
            }
        }
        return array[n];
    }
}
