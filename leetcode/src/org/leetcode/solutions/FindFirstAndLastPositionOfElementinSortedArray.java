package org.leetcode.solutions;

public class FindFirstAndLastPositionOfElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (high - low)/2 + low;
        int[] res = {-1, -1};
        while (low <= high && nums[mid] != target) {
            if(nums[mid] < target) {
                low = mid + 1;
            }
            if(nums[mid] > target) {
                high = mid - 1;
            }
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
