package org.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	//first test in leetcode.
	//it's easy to use map to store key-value.
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> res = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(res.containsKey(target - nums[i])){
                result[0] = res.get(target - nums[i]);
                result[1] = i;
                break;
            }
            res.put(nums[i],i);
        }
        return result;
    }
}
