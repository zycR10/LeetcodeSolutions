# PathSumII

## 题目
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
给一棵二叉树和一个sum值，找到所有从根到叶子的路径，使得其路径上的节点和等于所给的sum值，返回所有可能的路径结果
 
## 思路 
和上一道类似，也是需要找出来路径和等于sum值，那么首先大体框架不变，包括一些终止条件，但是由于需要将结果输出，所以入参中我们加入保存当前
路径的list和最后的返回结果res即可，具体list的添加和删除有点儿类似于回溯算法的逻辑，进入左子树或者右子树那么就在list中加入当前节点的值，
如果该节点判断完成那么就删除list中的最后一个节点

## 实现 
```
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        return recursive(root, res, sum, 0, new ArrayList<>());
    }

    private List<List<Integer>> recursive(TreeNode root, List<List<Integer>> res, int sum, int currSum, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        currSum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == currSum) {
            res.add(new ArrayList<>(list));
        }

        if (recursive(root.left, res, sum, currSum, list) != null) {
           list.remove(list.size() - 1);
        }
        if (recursive(root.right, res, sum, currSum, list) != null) {
            list.remove(list.size() - 1);
        }
        return res;
    }
```
