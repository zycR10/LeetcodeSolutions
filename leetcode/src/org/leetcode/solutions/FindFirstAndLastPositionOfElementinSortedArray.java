package org.leetcode.solutions;

public class FindFirstAndLastPositionOfElementinSortedArray {
    // the algorithm requires O(logn)
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (high - low)/2 + low;
        int[] res = {-1, -1};
        // use binary research to find mid
        // nums[mid] = target
        while (low <= high && nums[mid] != target) {
            if(nums[mid] < target) {
                low = mid + 1;
            }
            if(nums[mid] > target) {
                high = mid - 1;
            }
            // don't forget this
            // for myself, I always forget this line, cause dead loop
            mid = (high - low)/2 + low;
        }
        if (mid < nums.length && nums[mid] == target) {
            res[0] = findFirstPosition(nums, low, mid, target);
            res[1] = findLastPosition(nums, mid, high, target);
        }
        return res;
    }

    private int findLastPosition(int[] nums, int low, int high, int target) {
        int mid = (high - low)/2 + low;
        int right = low;
        while(low <= high) {
            if (nums[mid] == target) {
                right = mid;
                // maybe this is not the last one, continue find next
                low = mid + 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if(nums[mid] > target) {
                high = mid - 1;
            }
            mid = (high - low)/2 + low;
        }
        return right;
    }

    private int findFirstPosition(int[] nums, int low, int high, int target) {
        int mid = (high - low)/2 + low;
        int left = high;
        while(low <= high) {
            if (nums[mid] == target) {
                left = mid;
                // maybe this is not the first, continue find previous one
                high = mid - 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
            mid = (high - low)/2 + low;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        new FindFirstAndLastPositionOfElementinSortedArray().searchRange(nums, 2);
    }
}
