题意：
    输入一串数字（int[] candidates），求等于target（int target）的所有可能结果。
    39. Combination Sum 的变形，和39不一样的，每个数字出现一遍，不能重复出现

思路：
    典型的backtracking题。
    1，因为需要去重，所以排序数组
    2，进行helper函数backtracking调用
    3，helper考虑边界条件 -> 何时返回结果 -> for循环递归
    4，for循环中注意去重

复杂度：
     time : O(2^n)
     space : O(n)


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    // 函数与函数之间空行，没有空的空一下，这里注意
    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
