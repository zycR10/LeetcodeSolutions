# PascalTriangleII

## 题目
Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
给一个正整数n，输出杨辉三角的第n行
 
## 思路 
这道题和上一题的区别是这次只需要输出一行，当然我们可以使用上一题的方法求出所有行，然后取对应的那一行即可，但是这样做明显要消耗更多的内存空间，
这里我们可以只用一个数组，因为只要最后一行，但是下一行是由上一行计算得到的，所以前面几行只能算暂存，作用就是计算下一行就可以了

## 实现 
```
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }
        int[] nums = new int[rowIndex + 1];
        nums[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                nums[j] = nums[j] + nums[j - 1];
            }
        }
        for (int i : nums) {
            res.add(i);
        }
        return res;
    }
```