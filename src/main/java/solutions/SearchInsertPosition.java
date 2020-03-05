package solutions;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // make sure not overflow
        int middle = (high - low) / 2 + low;
        while (low < high) {
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
            middle = (high - low) / 2 + low;
        }
        if (nums[low] >= target) {
            return low;
        } else {
            return low + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new SearchInsertPosition().searchInsert(nums, 2));
    }
}
