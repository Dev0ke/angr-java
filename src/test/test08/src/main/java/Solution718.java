import java.util.HashSet;
import java.util.Set;

public class Solution718 {
    private static final int BASE = 101;
    private static final long MOD1 = 1000000007;
    private static final long MOD2 = 1000000009;

    // 时间复杂度 O((m+n)logmin(m,n))
    public int findLength(int[] nums1, int[] nums2) {
        int left = 1;
        int right = Math.min(nums1.length, nums2.length) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(nums1, nums2, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // 长度为 mid TTTFFF
    private boolean checkMid(int[] nums1, int[] nums2, int mid) {
        // 预处理 nums1
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

        // 再处理 B
        long hash2mod1 = 0;
        long hash2mod2 = 0;
        for (int i = 0; i < mid; i++) {
            hash2mod1 = (hash2mod1 * BASE + nums2[i]) % MOD1;
            hash2mod2 = (hash2mod2 * BASE + nums2[i]) % MOD2;
        }
        long hash2 = hash2mod1 * MOD2 + hash2mod2;
        if (hashSet.contains(hash2)) {
            return true;
        }
        for (int i = 1; i < nums2.length - mid + 1; i++) {
            hash2mod1 = (hash2mod1 * BASE - nums2[i - 1] * aL1 % MOD1 + MOD1) % MOD1;
            hash2mod1 = (hash2mod1 + nums2[i + mid - 1]) % MOD1;

            hash2mod2 = (hash2mod2 * BASE - nums2[i - 1] * aL2 % MOD2 + MOD2) % MOD2;
            hash2mod2 = (hash2mod2 + nums2[i + mid - 1]) % MOD2;

            hash2 = hash2mod1 * MOD2 + hash2mod2;
            if (hashSet.contains(hash2)) {
                return true;
            }
        }

        return false;
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

    // 时间复杂度 O(nm)
    public int findLength2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // f[i][j] 表示 nums1 前 i 个元素且以 i 结尾与 nums2 前 j 个元素且以 j 结尾的最长重复子数组
        int[][] f = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= m; j++) {
                int num2 = nums2[j - 1];
                if (num1 == num2) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = 0;
                }
                max = Math.max(max, f[i][j]);
            }
        }
        return max;
    }
}
/*
718. 最长重复子数组
https://leetcode.cn/problems/maximum-length-of-repeated-subarray/

给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
提示：
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100

Rabin-Karp 字符串哈希算法
相似题目: 1044. 最长重复子串
https://leetcode.cn/problems/longest-duplicate-substring/
$1062. 最长重复子串
https://leetcode.cn/problems/longest-repeating-substring/
1923. 最长公共子路径
https://leetcode.cn/problems/longest-common-subpath/
 */