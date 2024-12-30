import java.util.HashMap;
import java.util.Map;

public class Solution2025 {
    public int waysToPartition(int[] nums, int k) {
        int len = nums.length;
        // 前缀和
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        // 不改变 数组
        int cnt = 0;
        if (preSum[len] % 2 == 0) {
            for (int i = 0; i < len - 1; i++) {
                if (preSum[i + 1] == preSum[len] / 2) {
                    cnt++;
                }
            }
        }
        // 如果已经达到最大值，直接返回
        if (cnt == len - 1) {
            return cnt;
        }

        // 改变 数组
        Map<Integer, Integer> leftPreSumMap = new HashMap<>();
        Map<Integer, Integer> rightPreSumMap = new HashMap<>();
        for (int i = 1; i < len; i++) {
            rightPreSumMap.put(preSum[i], rightPreSumMap.getOrDefault(preSum[i], 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            int diff = k - nums[i];
            int newSum = preSum[len] + diff;
            if (newSum % 2 == 0) {
                int cnt2 = 0;
                cnt2 += leftPreSumMap.getOrDefault(newSum / 2, 0);
                cnt2 += rightPreSumMap.getOrDefault(newSum / 2 - diff, 0);

                cnt = Math.max(cnt, cnt2);
                // 如果已经达到最大值，直接返回
                if (cnt == len - 1) {
                    return cnt;
                }
            }
            leftPreSumMap.put(preSum[i + 1], leftPreSumMap.getOrDefault(preSum[i + 1], 0) + 1);
            rightPreSumMap.put(preSum[i + 1], rightPreSumMap.getOrDefault(preSum[i + 1], 0) - 1);
        }
        return cnt;
    }

    public int waysToPartition2(int[] nums, int k) {
        int len = nums.length;
        // 树状数组
        BIT bit = new BIT(len);
        for (int i = 0; i < len; i++) {
            bit.update(i + 1, nums[i]);
        }
        int sum = bit.query(len);
        int max = 0;
        // 不改变 数组
        if (sum % 2 == 0) {
            int halfSum = sum / 2;
            for (int i = 1; i < len; i++) {
                if (bit.query(1, i) == halfSum) {
                    max++;
                }
            }
        }
        if (max == len - 1) {
            return max;
        }
        // 将 nums 中 一个 元素变为 k
        for (int idx = 0; idx < len; idx++) {
            int res = 0;
            int change = k - nums[idx];
            int sum1 = bit.query(len) + change;
            if (sum1 % 2 == 0) {
                bit.update(idx + 1, change);
                int halfSum = sum1 / 2;
                for (int i = 1; i < len; i++) {
                    if (bit.query(1, i) == halfSum) {
                        res++;
                    }
                }
                max = Math.max(max, res);
                bit.update(idx + 1, -change);
            }
        }
        return max;
    }

    private static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public static int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }

        public void update(int idx, int num) {
            while (idx <= n) {
                tree[idx] += num;
                idx += lowbit(idx);
            }
        }

        public int query(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }

        public int query(int x, int y) {
            return query(y) - query(x - 1);
        }
    }
}
/*
2025. 分割数组的最多方案数
https://leetcode.cn/problems/maximum-number-of-ways-to-partition-an-array/

第 62 场双周赛 T4。

给你一个下标从 0 开始且长度为 n 的整数数组 nums 。分割 数组 nums 的方案数定义为符合以下两个条件的 pivot 数目：
1 <= pivot < n
nums[0] + nums[1] + ... + nums[pivot - 1] == nums[pivot] + nums[pivot + 1] + ... + nums[n - 1]
同时给你一个整数 k 。你可以将 nums 中 一个 元素变为 k 或 不改变 数组。
请你返回在 至多 改变一个元素的前提下，最多 有多少种方法 分割 nums 使得上述两个条件都满足。

前缀和 + 双哈希表。
树状数组居然会 TLE...
 */