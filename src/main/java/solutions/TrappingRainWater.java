package solutions;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * @Author: Zuo Yichen
 * @Date: 2018/12/13 10:02
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int a = 0;
        int b = height.length - 1;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (a <= b) {
            // keep looking max by left side
            leftmax = Math.max(leftmax, height[a]);
            rightmax = Math.max(rightmax, height[b]);
            if (leftmax < rightmax) {
                // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                // if a is the index of max left, leftmax - height[a] = 0
                max += (leftmax - height[a]);
                a++;
            } else {
                max += (rightmax - height[b]);
                b--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        new TrappingRainWater().trap(height);
    }
}
