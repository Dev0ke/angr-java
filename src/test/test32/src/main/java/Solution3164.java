import java.util.HashMap;
import java.util.Map;

public class Solution3164 {
    // O(n * sqrt(U/k) + m)
    // 521ms
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> factorCntMap = new HashMap<>();
        for (int v : nums1) {
            if (v % k != 0) continue;
            int n = v / k;
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    factorCntMap.merge(i, 1, Integer::sum);
                    if (i != n / i) {
                        factorCntMap.merge(n / i, 1, Integer::sum);
                    }
                }
            }
        }
        long ans = 0;
        for (int v : nums2) {
            if (factorCntMap.containsKey(v)) {
                ans += factorCntMap.get(v);
            }
        }
        return ans;
    }

    // O（n + m + Ulogm）
    // 86ms
    public long numberOfPairs2(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> cnt1 = new HashMap<>();
        for (int v : nums1) {
            if (v % k != 0) continue;
            cnt1.merge(v / k, 1, Integer::sum);
        }
        if (cnt1.isEmpty()) return 0;

        long ans = 0;
        Map<Integer, Integer> cnt2 = new HashMap<>();
        for (int v : nums2) {
            cnt2.merge(v, 1, Integer::sum);
        }
        int u = cnt1.keySet().stream().max(Integer::compare).orElseThrow();
        for (Map.Entry<Integer, Integer> entry : cnt2.entrySet()) {
            int i = entry.getKey(), c = entry.getValue();
            long s = 0; // num1 中有多少个数 /k 是 i 的倍数
            for (int j = i; j < u + 1; j += i) {
                s += cnt1.getOrDefault(j, 0);
            }
            ans += s * c;
        }
        return ans;
    }
}
/*
3164. 优质数对的总数 II
https://leetcode.cn/problems/find-the-number-of-good-pairs-ii/description/

第 399 场周赛 T3。

给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
返回 优质数对 的总数。
提示：
1 <= n, m <= 10^5
1 <= nums1[i], nums2[j] <= 10^6
1 <= k <= 10^3

统计 nums1 的因子出现次数（注意去重），再看这些因子在 nums2 中是否出现。
时间复杂度 O(n * sqrt(U/k) + m)。
 */