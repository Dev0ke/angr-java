import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2791 {
    private Map<Integer, List<Integer>> adj;
    private String s;
    private Map<Integer, Integer> cntMap;
    private long ans;

    public long countPalindromePaths(List<Integer> parent, String s) {
        adj = new HashMap<>();
        for (int i = 1; i < parent.size(); i++) {
            adj.computeIfAbsent(parent.get(i), key -> new ArrayList<>()).add(i);
        }
        this.s = s;

        cntMap = new HashMap<>();
        ans = 0;
        dfs(0, -1, 0);
        return ans;
    }

    private void dfs(int x, int fa, int mask) {
        cntMap.put(mask, cntMap.getOrDefault(mask, 0) + 1);
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            int nextMask = mask ^ (1 << (s.charAt(y) - 'a'));
            // 奇数个数为 0
            ans += cntMap.getOrDefault(nextMask, 0);
            // 奇数个数为 1
            for (int i = 0; i < 26; i++) {
                ans += cntMap.getOrDefault(nextMask ^ (1 << i), 0);
            }
            dfs(y, x, nextMask);
        }
    }
}
/*
2791. 树中可以形成回文的路径数
https://leetcode.cn/problems/count-paths-that-can-form-a-palindrome-in-a-tree/

第 355 场周赛 T4。

给你一棵 树（即，一个连通、无向且无环的图），根 节点为 0 ，由编号从 0 到 n - 1 的 n 个节点组成。这棵树用一个长度为 n 、下标从 0 开始的数组 parent 表示，其中 parent[i] 为节点 i 的父节点，由于节点 0 为根节点，所以 parent[0] == -1 。
另给你一个长度为 n 的字符串 s ，其中 s[i] 是分配给 i 和 parent[i] 之间的边的字符。s[0] 可以忽略。
找出满足 u < v ，且从 u 到 v 的路径上分配的字符可以 重新排列 形成 回文 的所有节点对 (u, v) ，并返回节点对的数目。
如果一个字符串正着读和反着读都相同，那么这个字符串就是一个 回文 。
提示：
n == parent.length == s.length
1 <= n <= 10^5
对于所有 i >= 1 ，0 <= parent[i] <= n - 1 均成立
parent[0] == -1
parent 表示一棵有效的树
s 仅由小写英文字母组成

DFS + 前缀和 + 按位异或性质
相似题目: 2246. 相邻字符不同的最长路径
https://leetcode.cn/problems/longest-path-with-different-adjacent-characters/
1457. 二叉树中的伪回文路径
https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/description/
 */