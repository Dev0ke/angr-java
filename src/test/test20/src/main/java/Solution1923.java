import java.util.HashSet;
import java.util.Set;

public class Solution1923 {
    private static final int BASE = 100001;
    private static final long MOD1 = 1000000007;
    private static final long MOD2 = 1000000009;

    public int longestCommonSubpath(int n, int[][] paths) {
        int minLen = Integer.MAX_VALUE;
        for (int[] path : paths) {
            minLen = Math.min(minLen, path.length);
        }

        int left = 1;
        int right = minLen + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(paths, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(int[][] paths, int mid) {
        Set<Long> hashSet0 = getHashSet(paths[0], mid);
        for (int i = 1; i < paths.length; i++) {
            Set<Long> hashSet = getHashSet(paths[i], mid);
            // 求所有 hashSet 交集
            hashSet0.retainAll(hashSet);
        }
        return !hashSet0.isEmpty();
    }

    private Set<Long> getHashSet(int[] nums1, int mid) {
        long hash1mod1 = 0;
        long hash1mod2 = 0;
        for (int i = 0; i < mid; i++) {
            hash1mod1 = (hash1mod1 * BASE + nums1[i]) % MOD1;
            hash1mod2 = (hash1mod2 * BASE + nums1[i]) % MOD2;
        }
        Set<Long> hashSet = new HashSet<>();
        long hash = hash1mod1 * MOD2 + hash1mod2;
        hashSet.add(hash);

        // 26^mid % mod
        long aL1 = quickPow(BASE, mid, MOD1);
        long aL2 = quickPow(BASE, mid, MOD2);
        for (int i = 1; i < nums1.length - mid + 1; i++) {
            hash1mod1 = (hash1mod1 * BASE - nums1[i - 1] * aL1 % MOD1 + MOD1) % MOD1;
            hash1mod1 = (hash1mod1 + nums1[i + mid - 1]) % MOD1;

            hash1mod2 = (hash1mod2 * BASE - nums1[i - 1] * aL2 % MOD2 + MOD2) % MOD2;
            hash1mod2 = (hash1mod2 + nums1[i + mid - 1]) % MOD2;

            hash = hash1mod1 * MOD2 + hash1mod2;
            hashSet.add(hash);
        }
        return hashSet;
    }

    // res = a^b % mod
    private long quickPow(long a, long b, long mod) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
/*
1923. 最长公共子路径
https://leetcode.cn/problems/longest-common-subpath/

第 248 场周赛 T4。

一个国家由 n 个编号为 0 到 n - 1 的城市组成。在这个国家里，每两个 城市之间都有一条道路连接。
总共有 m 个编号为 0 到 m - 1 的朋友想在这个国家旅游。他们每一个人的路径都会包含一些城市。每条路径都由一个整数数组表示，
每个整数数组表示一个朋友按顺序访问过的城市序列。同一个城市在一条路径中可能 重复 出现，但同一个城市在一条路径中不会连续出现。
给你一个整数 n 和二维数组 paths ，其中 paths[i] 是一个整数数组，表示第 i 个朋友走过的路径，请你返回 每一个 朋友都走过的 最长公共子路径 的长度，如果不存在公共子路径，请你返回 0 。
一个 子路径 指的是一条路径中连续的城市序列。
提示：
1 <= n <= 10^5
m == paths.length
2 <= m <= 10^5
sum(paths[i].length) <= 10^5
0 <= paths[i][j] < n
paths[i] 中同一个城市不会连续重复出现。

Rabin-Karp 字符串哈希算法 + 二分
将求解问题转换成验证问题
相似题目: 718. 最长重复子数组
https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
 */