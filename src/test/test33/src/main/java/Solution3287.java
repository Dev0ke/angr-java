public class Solution3287 {
    public int maxValue(int[] nums, int k) {
        final int MX = 1 << 7;
        int n = nums.length;
        boolean[][] suf = new boolean[n][];
        boolean[][] f = new boolean[k + 1][MX];
        f[0][0] = true;
        for (int i = n - 1; i >= k; i--) {
            int v = nums[i];
            for (int j = k - 1; j >= 0; j--) {
                for (int x = 0; x < MX; x++) {
                    if (f[j][x]) {
                        f[j + 1][x | v] = true;
                    }
                }
            }
            suf[i] = f[k].clone();
        }

        int ans = 0;
        boolean[][] pre = new boolean[k + 1][MX];
        pre[0][0] = true;
        for (int i = 0; i < n - k; i++) {
            int v = nums[i];
            for (int j = k - 1; j >= 0; j--) {
                for (int x = 0; x < MX; x++) {
                    if (pre[j][x]) {
                        pre[j + 1][x | v] = true;
                    }
                }
            }
            if (i < k - 1) {
                continue;
            }
            for (int x = 0; x < MX; x++) {
                if (pre[k][x]) {
                    for (int y = 0; y < MX; y++) {
                        if (suf[i + 1][y]) {
                            ans = Math.max(ans, x ^ y);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
/*
3287. 求出数组中最大序列值
https://leetcode.cn/problems/find-the-maximum-sequence-value-of-array/description/

第 139 场双周赛 T3。

给你一个整数数组 nums 和一个 正 整数 k 。
定义长度为 2 * x 的序列 seq 的 值 为：
- (seq[0] OR seq[1] OR ... OR seq[x - 1]) XOR (seq[x] OR seq[x + 1] OR ... OR seq[2 * x - 1]).
请你求出 nums 中所有长度为 2 * k 的 子序列 的 最大值 。
提示：
2 <= nums.length <= 400
1 <= nums[i] < 2^7
1 <= k <= nums.length / 2

前后缀分解 + 二维 0-1 背包
https://leetcode.cn/problems/find-the-maximum-sequence-value-of-array/solutions/2917604/qian-hou-zhui-fen-jie-er-wei-0-1-bei-bao-8icz/
时间复杂度 O(nkU)。其中 U = 2^7。
rating 2574 (clist.by)
 */