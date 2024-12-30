import java.util.Arrays;

public class Solution1681 {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;

        int[] val = new int[1 << n];
        Arrays.fill(val, -1);
        int[] freq = new int[n + 1];
        for (int sub = 0; sub < (1 << n); sub++) {
            // 判断 sub 是否有 n/k 个 1
            if (Integer.bitCount(sub) == n / k) {
                for (int j = 0; j < n; j++) {
                    if (((sub >> j) & 1) == 1) {
                        freq[nums[j]]++;
                    }
                }
                // 任意一个数不能出现超过 1 次
                boolean flag = true;
                for (int j = 1; j <= n; j++) {
                    if (freq[j] > 1) {
                        flag = false;
                        break;
                    }
                }
                // 如果满足要求，那么计算 sub 的不兼容性
                if (flag) {
                    int lb = Integer.MAX_VALUE;
                    int rb = Integer.MIN_VALUE;
                    for (int j = 1; j <= n; j++) {
                        if (freq[j] > 0) {
                            lb = Math.min(lb, j);
                            rb = Math.max(rb, j);
                        }
                    }
                    val[sub] = rb - lb;
                }
                // 由于我们使用数组进行计数，因此要将数组恢复原状
                for (int j = 0; j < n; j++) {
                    if (((sub >> j) & 1) == 1) {
                        freq[nums[j]]--;
                    }
                }
            }
        }

        int[] f = new int[1 << n];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            // 判断 mask 是否有 n/k 倍数个 1
            if (Integer.bitCount(mask) % (n / k) == 0) {
                // 枚举子集
                for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
                    if (val[sub] != -1 && f[mask ^ sub] != -1) {
                        if (f[mask] == -1) {
                            f[mask] = f[mask ^ sub] + val[sub];
                        } else {
                            f[mask] = Math.min(f[mask], f[mask ^ sub] + val[sub]);
                        }
                    }
                }
            }
        }
        return f[(1 << n) - 1];
    }
}
/*
1681. 最小不兼容性
https://leetcode.cn/problems/minimum-incompatibility/

给你一个整数数组 nums 和一个整数 k 。你需要将这个数组划分到 k 个相同大小的子集中，使得同一个子集里面没有两个相同的元素。
一个子集的 不兼容性 是该子集里面最大值和最小值的差。
请你返回将数组分成 k 个子集后，各子集 不兼容性 的 和 的 最小值 ，如果无法分成分成 k 个子集，返回 -1 。
子集的定义是数组中一些数字的集合，对数字顺序没有要求。
提示：
1 <= k <= nums.length <= 16
nums.length 能被 k 整除。
1 <= nums[i] <= nums.length

状态压缩动态规划
时间复杂度 O(3^n)
空间复杂度 O(2^n)
 */