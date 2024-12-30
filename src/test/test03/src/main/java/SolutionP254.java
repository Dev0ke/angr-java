import java.util.ArrayList;
import java.util.List;

public class SolutionP254 {
    public List<List<Integer>> getFactors(int n) {
        // 因子必须大于 1 并且小于 n。
        int factorLen = n - 2;
        List<List<Integer>> resList = new ArrayList<>();
        if (factorLen <= 0) {
            return resList;
        }
        int[] nums = new int[factorLen];
        for (int i = 0; i < factorLen; i++) {
            nums[i] = i + 2;
        }
        // 回溯
        helper(n, nums, 0, resList, new ArrayList<>());
        return resList;
    }

    private void helper(int n, int[] nums, int idx, List<List<Integer>> resList, List<Integer> path) {
        if (n == 1) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < nums.length && nums[i] <= n; i++) {
            if (n % nums[i] == 0) {
                path.add(nums[i]);
                helper(n / nums[i], nums, i, resList, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
/*
$254. 因子的组合
https://leetcode.cn/problems/factor-combinations/

整数可以被看作是其因子的乘积。
例如：
8 = 2 x 2 x 2;
  = 2 x 4.
请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
注意：
你可以假定 n 为永远为正数。
因子必须大于 1 并且小于 n。

回溯。
 */