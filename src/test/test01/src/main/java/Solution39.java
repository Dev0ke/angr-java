import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    static class V1 {
        private int[] candidates;
        private List<Integer> res;
        private List<List<Integer>> ans;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            res = new ArrayList<>();
            ans = new ArrayList<>();
            dfs(0, target);
            return ans;
        }

        private void dfs(int i, int target) {
            if (target == 0) {
                ans.add(new ArrayList<>(res));
                return;
            }
            if (i == candidates.length) {
                return;
            }
            dfs(i + 1, target);
            if (candidates[i] <= target) {
                res.add(candidates[i]);
                dfs(i, target - candidates[i]);
                res.remove(res.size() - 1);
            }
        }
    }

    static class V2 {
        private int[] candidates;
        private boolean[][] can;
        private List<Integer> res;
        private List<List<Integer>> ans;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            Arrays.sort(candidates);

            // 背包预处理 提前排除无解的情况
            int n = candidates.length;
            can = new boolean[n][target + 1];
            boolean[] now = new boolean[target + 1];
            now[0] = true;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j + candidates[i] <= target; j++) {
                    if (now[j]) now[j + candidates[i]] = true;
                }
                can[i] = now;
            }

            res = new ArrayList<>();
            ans = new ArrayList<>();
            dfs(0, target);
            return ans;
        }

        private void dfs(int i, int target) {
            if (target == 0) {
                ans.add(new ArrayList<>(res));
                return;
            }
            if (i == candidates.length || !can[i][target]) {
                return;
            }
            dfs(i + 1, target);
            if (candidates[i] <= target) {
                res.add(candidates[i]);
                dfs(i, target - candidates[i]);
                res.remove(res.size() - 1);
            }
        }
    }
}
/*
39. 组合总和
https://leetcode.cn/problems/combination-sum/

给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
对于给定的输入，保证和为 target 的不同组合数少于 150 个。
提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都 互不相同
1 <= target <= 500

背包预处理排除无解情形 https://leetcode.cn/problems/combination-sum/solutions/1816717/by-lucifer1004-0oeb/
 */