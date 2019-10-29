package solutions;

public class SearchinRotatedSortedArray {
    private int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // such as nums = {4,5,6,7,8,0,1,2,3}, you can think first array is {4,5,6,7,8}
            // and second array is {0,1,2,3}
            // check if nums[mid] and target split into different arrays
            boolean split = (nums[mid] >= nums[0]) != (target >= nums[0]);
            if (split) {
                if (target >= nums[0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low] == target ? low : -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2, 3};
        System.out.println(new SearchinRotatedSortedArray().search(nums, 0));
    }
}
