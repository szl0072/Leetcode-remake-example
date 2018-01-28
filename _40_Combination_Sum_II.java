package leetcode;  //这里package import都保留

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project Name : Leetcode // 这里注意，保留我之前写的这些Name Creator，去掉Date
 * Package Name : leetcode
 * File Name : CombinationSumII
 * Creator : Edward
 * Date : Aug, 2017   // 每一个文件都有Date，这里删除
 * Description : 40. Combination Sum II //这里注意，有的题早期录的，把题目编号放在下面了，拿上来。
 */
public class CombinationSumII {

    /**
     * Given  //这里注意，这样的情况不能出现，要把之前的星号去掉
     Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in where the candidate numbers sums to T.

     Each number in C may only be used once in the combination.

     Note:
     All numbers (including target) will be positive integers.
     The solution set must not contain duplicate combinations.
     For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
     A solution set is:
     [
     [1, 7],
     [1, 2, 5],
     [2, 6],
     [1, 1, 6]
     ]

     [1,1,2,5,6,7,10]
     [[1,1,6],[1,2,5],[1,7],[2,6]]
     
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
     
     （视频错误：）（如果有加上）

     * @param candidates
     * @param target
     * @return
     */

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
