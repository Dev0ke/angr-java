import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {
    private int[] candidates;
    private int target;
    private LinkedList<Integer> combination;
    private List<List<Integer>> combinationList;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        combination = new LinkedList<>();
        combinationList = new ArrayList<>();

        dfs(0, 0);
        return combinationList;
    }

    private void dfs(int i, int sum) {
        if (sum == target) {
            combinationList.add(new ArrayList<>(combination));
            return;
        }
        if (i == candidates.length || sum > target) {
            return;
        }
        // 不选
        dfs(getNext(i), sum);
        // 选
        combination.add(candidates[i]);
        dfs(i + 1, sum + candidates[i]);
        combination.removeLast();
    }

    private int getNext(int i) {
        int next = i;
        while (next < candidates.length && candidates[next] == candidates[i]) {
            next++;
        }
        return next;
    }
}
/*
40. 组合总和 II
https://leetcode.cn/problems/combination-sum-ii/

给定一个数组 candidates 和一个目标数 target，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
注意：解集不能包含重复的组合。
提示:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

第 39 题升级版。可包含重复数字。
回溯法。
避免重复的组合的方法是当在某一步决定跳过某个值为 m 的数字时，跳过所有值为 m 的数字。
 */