package solutions;

public class ContainerWithMostWater {
	// my first thought
	// only beat about 14%
	// public int maxArea(int[] height) {
	// int left = 0;
	// int right = 0;
	// int bound = -1;
	// int max = 0;
	// int res = 0;
	// for (int i = 0; i < height.length; i++) {
	// left = i - 1;
	// right = i + 1;
	// while (left >= 0) {
	// if (height[left] >= height[i]) {
	// bound = left;
	// }
	// left--;
	// }
	// if (bound != -1) {
	// max = i - bound;
	// bound = -1;
	// }
	// while (right <= height.length - 1) {
	// if (height[right] >= height[i]) {
	// bound = right;
	// }
	// right++;
	// }
	// if (bound != -1) {
	// max = max > (bound - i) ? max : (bound - i);
	// bound = -1;
	// }
	// res = res > (max * height[i]) ? res : (max * height[i]);
	// max = 0;
	// }
	// return res;
	// }

	
	// use two pointer
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int max = 0;
		while (left < right) {
			int tall = height[left] > height[right] ? height[right] : height[left];
			int area = (right - left) * tall;
			max = max > area ? max : area;
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(new ContainerWithMostWater().maxArea(height));
	}
}
