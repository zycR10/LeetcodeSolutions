# LongestConsecutiveSequence

## 题目
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
Your algorithm should run in O(n) complexity.
给一个未排序的整数数组，找到其中最长的连续元素个数，要求算法时间复杂度为O(n)

Example:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 
## 思路 
这道题方法其实还是很多的，暴力搜索就不说了，效率很低。另外一种比较简单的是先给数组排序，然后遍历排序后的数组，但是题目中要求时间复杂度为O(n)，
首先排序算法中都没有时间复杂度能到达O(n)的算法，所以先排序这条路也被pass了。其实从时间复杂度的要求上我们应该想到，如果想通过一次遍历就获取
到结果，那么肯定是要借助其他数据结构。这里我们选择了map，在遍历的过程中我们把数组中的元素放入map，但是放入之前我们先判断一下该元素的左右值，
比如元素i，那么我们去map中寻找i - 1和i + 1对应的value，记为left和right，假设某个元素i的左值和右值还没有被记录到map中，那么left和right就
都是空，然后我们计算当前的最大长度为sum = left + right + 1，既然此时左右都没有，那么这个长度值就是1，也就是说这个元素目前是一个很孤独的状态，
左右相邻的元素都没有被加进来，那么key = i，value = 1。假设后面遇到了右侧的相邻元素i + 1，那么针对i + 1去查找左右值的时候，左值就应该是
我们刚才放入的1，右值还是没有，所以此时sum值为 left + right + 1 = 1 + 0 + 1 = 2, 所以记录下key = i + 1, value = 2，也就是此时我们找
到了最大长度为2。当然了，这里计算出最大长度之后千万不要忘记扩展，比如某个元素left = 3， right = 2，说明它左侧已经连了3个值了，右侧连了两个
值，由于一段数字被连上之后，我们在扩大长度肯定是找到与左右边界相邻的数字，所以此时要把最大长度扩展到最大边界对应的位置去，即resMap.put(i - left, sum)，
后续只要我们还能找到相邻的元素，那么通过累加相邻元素的value值，我们就可以计算出当前相邻长度，每次计算长度的时候与max做比较取
较大值，那么当遍历完数组之后，我们得到的max值就是最长连续元素长度。不是很复杂的思想，但是有一点儿绕，核心就是我们每次放入map的时候都通过
累加左右连续长度获得当前数字的连续长度。

## 实现 
```
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> resMap = new HashMap<>();
        int res = 0;
        for (Integer i : nums) {
            if (!resMap.containsKey(i)) {
                int left = resMap.get(i - 1) == null ? 0 : resMap.get(i - 1);
                int right = resMap.get(i + 1) == null ? 0 : resMap.get(i + 1);
                int sum = left + right + 1;
                res = Math.max(res, sum);
                resMap.put(i, sum);
                resMap.put(i - left, sum);
                resMap.put(i + right, sum);
            } else {
                continue;
            }
        }
        return res;
    }
```

