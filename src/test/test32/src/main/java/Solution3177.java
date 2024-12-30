import java.util.HashMap;
import java.util.Map;

public class Solution3177 {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, int[]> fs = new HashMap<>();
        int[][] records = new int[k + 1][3];
        for (int x : nums) {
            int[] f = fs.computeIfAbsent(x, i -> new int[k + 1]);
            for (int j = k; j >= 0; j--) {
                f[j]++;
                if (j > 0) {
                    int mx = records[j - 1][0], mx2 = records[j - 1][1], num = records[j - 1][2];
                    f[j] = Math.max(f[j], (x != num ? mx : mx2) + 1);
                }

                // records[j] 维护 fs[.][j] 的 mx, mx2, num
                int v = f[j];
                int[] p = records[j];
                if (v > p[0]) {
                    if (x != p[2]) {
                        p[2] = x;
                        p[1] = p[0];
                    }
                    p[0] = v;
                } else if (x != p[2] && v > p[1]) {
                    p[1] = v;
                }
            }
        }
        return records[k][0];
    }
}
/*
3177. 求出最长好子序列 II
https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-ii/description/

第 132 场双周赛 T4。

给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在范围下标范围 [0, seq.length - 2] 中存在 不超过 k 个下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。
请你返回 nums 中 好 子序列 的最长长度
提示：
1 <= nums.length <= 5 * 10^3
1 <= nums[i] <= 10^9
0 <= k <= min(50, nums.length)

LIS
dfs(i) 表示以 nums[i] 结尾的 LIS 长度
转移：枚举 j < i，如果 nums[j] <  nums[i]，就从 dfs(j)+1 转移过来
---
dfs(i,j) 表示 以 nums[i] 结尾的、有至多 j 对 相邻元素不同 最长子序列的长度
转移：枚举 p < i
如果 nums[p] != nums[i]，就从 dfs(p,j-1)+1 转移过来
如果 nums[p] == nums[i]，就从 dfs(p,j)+1 转移过来
---
O(n^2 * k)
---
优化：
f[x][j] 表示以数值 x 结尾的，有至多 j 对相邻元素不同的最长子序列的长度
设 x = nums[i]
1、不选：f[x][j] 不变（不需要考虑）
2、选，把 x 加到以 x 结尾的子序列的末尾：f[x][j] = f[x][j] + 1
2、选，把 x 加到以 y 结尾的子序列的末尾：f[x][j] = f[x][j-1] + 1, if y != x
---
f[x][j] = max(f[x][j]+1, max(f[y][j-1] for y in set) + 1)
mx[j] 表示 max(f[y][j] for y in set)
---
f[x][j] = max(f[x][j]+1, mx[j-1] + 1)
---
相似题目: CF264C. Choosing Balls
 */