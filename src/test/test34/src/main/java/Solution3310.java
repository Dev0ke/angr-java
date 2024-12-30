import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3310 {
    private List<Integer>[] g;
    private boolean[] isSuspicious;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : invocations) {
            g[p[0]].add(p[1]);
        }
        isSuspicious = new boolean[n];
        dfs(k);

        // 检查是否有【非可疑方法】->【可疑方法】的边
        for (int[] p : invocations) {
            if (!isSuspicious[p[0]] && isSuspicious[p[1]]) {
                // 无法移除可疑方法
                List<Integer> ans = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        // 移除所有可疑方法
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isSuspicious[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    private void dfs(int x) {
        isSuspicious[x] = true;
        for (int y : g[x]) {
            if (!isSuspicious[y]) { // 避免无限递归
                dfs(y);
            }
        }
    }
}
/*
3310. 移除可疑的方法
https://leetcode.cn/problems/remove-methods-from-project/description/

第 418 场周赛 T2。

你正在维护一个项目，该项目有 n 个方法，编号从 0 到 n - 1。
给你两个整数 n 和 k，以及一个二维整数数组 invocations，其中 invocations[i] = [ai, bi] 表示方法 ai 调用了方法 bi。
已知如果方法 k 存在一个已知的 bug。那么方法 k 以及它直接或间接调用的任何方法都被视为 可疑方法 ，我们需要从项目中移除这些方法。
只有当一组方法没有被这组之外的任何方法调用时，这组方法才能被移除。
返回一个数组，包含移除所有 可疑方法 后剩下的所有方法。你可以以任意顺序返回答案。如果无法移除 所有 可疑方法，则 不 移除任何方法。
提示:
1 <= n <= 10^5
0 <= k <= n - 1
0 <= invocations.length <= 2 * 10^5
invocations[i] == [ai, bi]
0 <= ai, bi <= n - 1
ai != bi
invocations[i] != invocations[j]

DFS 标记可疑方法。
时间复杂度 O(n+m)。
 */