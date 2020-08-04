# GroupAnagrams

## 题目
Given an array of strings, group anagrams together.
给一个字符串数组，将将所有易位构词按组分到一起

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
All inputs will be in lowercase.
The order of your output does not matter.
所给的数组中所有字符均为小写
答案的输出顺序无所谓
 
## 思路  
思路比较简单，最后的答案其实就是类似于hashmap中的value值，所以我们只需要想办法将输入转换为一个hashmap即可，key值为按a-z顺序排列的单词即可

## 实现 
```
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> ans = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (ans.containsKey(key)) {
                ans.get(key).add(str);
            } else {
                ans.put(key, new ArrayList<>());
            }
        }
        return new ArrayList<>(ans.values());
    }
```
