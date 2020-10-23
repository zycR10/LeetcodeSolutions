# SingleNumberII

## 题目
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. 
Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
给一个非空正整数数组，除了一个特定元素外，其他每个元素出现三次，找出这个特定元素
算法要求线性时间，且不适用额外存储空间

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
 
## 思路 
说实话这题要做到O(n)和不适用额外空间我真不会，我的做法是把三个重复降级成两个重复，做法就是先排序，然后遍历数组，每到第三个的时候就跳过，
另外给大家推荐一篇文章吧，对于正确的解法进行了详细的解析，虽然我还是没看懂。。。https://blog.csdn.net/yutianzuijin/article/details/50597413

## 实现 
```
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i % 3 == 0) {
                continue;
            }
            res ^= nums[i - 1];
        }
        return res;
    }
```