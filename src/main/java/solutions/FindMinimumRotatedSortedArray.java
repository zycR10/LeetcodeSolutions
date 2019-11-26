package solutions;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/11/26 12:56
 */
public class FindMinimumRotatedSortedArray {
    // O(n)
//    public int findMin(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] < nums[i - 1]) {
//                nums[0] = nums[i];
//                break;
//            }
//        }
//        return nums[0];
//    }

    // O(logN)
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                left++;
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(new FindMinimumRotatedSortedArray().findMin(nums));
    }
}
