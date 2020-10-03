# PascalTriangle

## 题目
给一个行数n，输出n行杨辉三角

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 
## 思路 
这道题感觉严格意义上来说都不算一道算法题，因为感觉写出来也不需要什么算法知识，只要理解了杨辉三角怎么算，把计算过程翻译成代码就可以了，
杨辉三角的计算就是每一行首尾是1，然后其余第i行第j个元素由第i-1行的第j-1和j个元素做加法得到，翻译成代码就行了

## 实现 
```
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        while (count < numRows) {
            List<Integer> curr = new ArrayList<>();
            int index = 0;
            while (index < count) {
                if (index == 0) {
                    curr.add(1);
                    index++;
                    continue;
                }
                curr.add(res.get(count - 1).get(index - 1) + res.get(count - 1).get(index));
                index++;
            }
            curr.add(1);
            res.add(curr);
            count++;
        }
        return res;
    }
```