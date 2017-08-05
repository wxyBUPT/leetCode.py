package bupt.wxy.backtracking.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 2/28/17.
 * 77. Combinations
 * Difficulty: Medium
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {

    // 6.58% 但是不在第一个正太区间, 递归的方法在第一个正太区间, 真的不是很想写递归的方法了......
    public List<List<Integer>> combineBack(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        backtracking(0, n, new LinkedList<>(), k, res);
        return res;
    }

    void backtracking(int index, int n, List<Integer> curr, int k, List<List<Integer>> res) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // 添加到最优一个数, 但是没有选慢
        if (index == n) return;

        for (int i = index; i < n; i++) {
            curr.add(i + 1);
            backtracking(i + 1, n, curr, k, res);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new ArrayList<>(k);
            for (int i = 1; i <= k; i++) row.add(i);
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(combine(n - 1, k));
        return result;
    }
}
