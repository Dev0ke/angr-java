import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    // 二进制枚举
    static class V1 {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int mask = 0; mask < 1 << n; mask++) {
                if (Integer.bitCount(mask) == k) {
                    List<Integer> res = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        if ((mask >> i & 1) == 1) {
                            res.add(i + 1);
                        }
                    }
                    ans.add(res);
                }
            }
            return ans;
        }
    }

    // 回溯
    static class V2 {
        private int n, k;
        private List<Integer> res;
        private List<List<Integer>> ans;

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            res = new ArrayList<>();
            ans = new ArrayList<>();
            dfs(1);
            return ans;
        }

        private void dfs(int i) {
            if (res.size() == k) {
                ans.add(new ArrayList<>(res));
            } else if (i <= n) {
                dfs(i + 1);
                res.add(i);
                dfs(i + 1);
                res.remove(res.size() - 1);
            }
        }
    }
}
/*
77. 组合
https://leetcode.cn/problems/combinations/

给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。
提示：
1 <= n <= 20
1 <= k <= n

组合也是子集。在第 78 题增加一个限制条件即可，即只找出包含 k 个数字的组合。
回溯法。
 */