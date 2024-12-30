import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1916 {
    private static final int MOD = (int) (1e9 + 7);
    private Map<Integer, List<Integer>> adj;
    private long[] fac, inv, f;
    private int[] cnt;

    // 时间复杂度 O(nlogn)
    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        // fac[i] 表示 i!
        // inv[i] 表示 i! 的乘法逆元
        fac = new long[n];
        inv = new long[n];
        fac[0] = 1;
        inv[0] = 1;
        for (int i = 1; i < n; ++i) {
            fac[i] = fac[i - 1] * i % MOD;
            // 使用费马小定理计算乘法逆元
            inv[i] = quickPow(fac[i], MOD - 2);
        }

        // 构造树
        adj = new HashMap<>();
        for (int i = 1; i < n; i++) {
            adj.computeIfAbsent(prevRoom[i], key -> new ArrayList<>()).add(i);
        }

        f = new long[n];
        cnt = new int[n];
        dfs(0);
        return (int) f[0];
    }

    private void dfs(int u) {
        f[u] = 1;
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            dfs(v);
            // 乘以左侧的 f[ch] 以及右侧分母中 cnt[ch] 的乘法逆元
            f[u] = f[u] * f[v] % MOD * inv[cnt[v]] % MOD;
            cnt[u] += cnt[v];
        }
        // 乘以右侧分子中的 (cnt[i] - 1)!
        f[u] = f[u] * fac[cnt[u]] % MOD;
        cnt[u]++;
    }

    // 模下的 a^b
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    // 线性求逆元 https://oi-wiki.org/math/number-theory/inverse/#%E7%BA%BF%E6%80%A7%E6%B1%82%E9%80%86%E5%85%83
    // 时间复杂度 O(n + logp)
    public int waysToBuildRooms2(int[] prevRoom) {
        int n = prevRoom.length;
        // fac[i] 表示 i!
        // inv[i] 表示 i! 的乘法逆元
        fac = new long[n];
        inv = new long[n];
        fac[0] = 1;
        for (int i = 1; i < n; ++i) {
            fac[i] = fac[i - 1] * i % MOD;
        }
        // 线性求逆元 时间复杂度 O(n + logp)
        long[] s = new long[n + 1], sv = new long[n + 1];
        s[0] = 1;
        for (int i = 1; i <= n; ++i) s[i] = s[i - 1] * fac[i - 1] % MOD;
        sv[n] = quickPow(s[n], MOD - 2);
        for (int i = n; i >= 1; --i) sv[i - 1] = sv[i] * fac[i - 1] % MOD;
        for (int i = 1; i <= n; ++i) inv[i - 1] = sv[i] * s[i - 1] % MOD;

        // 构造树
        adj = new HashMap<>();
        for (int i = 1; i < n; i++) {
            adj.computeIfAbsent(prevRoom[i], key -> new ArrayList<>()).add(i);
        }

        f = new long[n];
        cnt = new int[n];
        dfs(0);
        return (int) f[0];
    }
}
/*
1916. 统计为蚁群构筑房间的不同顺序
https://leetcode.cn/problems/count-ways-to-build-rooms-in-an-ant-colony/

第 247 场周赛 T4。

你是一只蚂蚁，负责为蚁群构筑 n 间编号从 0 到 n-1 的新房间。给你一个 下标从 0 开始 且长度为 n 的整数数组 prevRoom 作为扩建计划。
其中，prevRoom[i] 表示在构筑房间 i 之前，你必须先构筑房间 prevRoom[i] ，并且这两个房间必须 直接 相连。
房间 0 已经构筑完成，所以 prevRoom[0] = -1 。扩建计划中还有一条硬性要求，在完成所有房间的构筑之后，从房间 0 可以访问到每个房间。
你一次只能构筑 一个 房间。你可以在 已经构筑好的 房间之间自由穿行，只要这些房间是 相连的 。如果房间 prevRoom[i] 已经构筑完成，那么你就可以构筑房间 i。
返回你构筑所有房间的 不同顺序的数目 。由于答案可能很大，请返回对 10^9 + 7 取余 的结果。
提示：
n == prevRoom.length
2 <= n <= 10^5
prevRoom[0] == -1
对于所有的 1 <= i < n ，都有 0 <= prevRoom[i] < n
题目保证所有房间都构筑完成后，从房间 0 可以访问到每个房间

动态规划
前置知识：排列数计算 + 乘法逆元
构筑所有房间的不同顺序的数目，等于我们构造的树的不同拓扑排序的方案数。
 */