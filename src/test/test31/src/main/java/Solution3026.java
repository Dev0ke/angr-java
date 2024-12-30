import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3026 {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        // 元素出现的下标
        Map<Integer, List<Node>> idsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idsMap.computeIfAbsent(nums[i], e -> new ArrayList<>()).add(new Node(i, 0));
        }
        for (List<Node> ids : idsMap.values()) {
            long mx = Long.MIN_VALUE;
            for (int i = ids.size() - 1; i >= 0; i--) {
                int j = ids.get(i).id;
                mx = Math.max(mx, ps[j + 1]);
                ids.get(i).sum = mx;
            }
        }

        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = nums[i];

            List<Node> ids = idsMap.getOrDefault(x - k, new ArrayList<>());
            int j = lowerBound(ids, i);
            if (j < ids.size()) {
                ans = Math.max(ans, ids.get(j).sum - ps[i]);
            }

            ids = idsMap.getOrDefault(x + k, new ArrayList<>());
            j = lowerBound(ids, i);
            if (j < ids.size()) {
                ans = Math.max(ans, ids.get(j).sum - ps[i]);
            }
        }
        return ans == Long.MIN_VALUE ? 0 : ans;
    }

    private int lowerBound(List<Node> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m).id >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

    private static class Node {
        int id;
        long sum;

        public Node(int id, long sum) {
            this.id = id;
            this.sum = sum;
        }
    }

    public long maximumSubarraySum2(int[] nums, int k) {
        long ans = Long.MIN_VALUE;
        long sum = 0;
        Map<Integer, Long> mp = new HashMap<>();
        for (int x : nums) {
            if (mp.containsKey(x - k)) {
                ans = Math.max(ans, sum + x - mp.get(x - k));
            }
            if (mp.containsKey(x + k)) {
                ans = Math.max(ans, sum + x - mp.get(x + k));
            }
            if (!mp.containsKey(x) || mp.get(x) > sum) {
                mp.put(x, sum);
            }
            sum += x;
        }
        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}
/*
3026. 最大好子数组和
https://leetcode.cn/problems/maximum-good-subarray-sum/

第 123 场双周赛 T3。

给你一个长度为 n 的数组 nums 和一个 正 整数 k 。
如果 nums 的一个子数组中，第一个元素和最后一个元素 差的绝对值恰好 为 k ，我们称这个子数组为 好 的。换句话说，如果子数组 nums[i..j] 满足 |nums[i] - nums[j]| == k ，那么它是一个好子数组。
请你返回 nums 中 好 子数组的 最大 和，如果没有好子数组，返回 0 。
提示：
2 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
1 <= k <= 10^9

哈希分组 + 预处理。
分组后，每组由后往前处理 最大值。
查询的时候对于每个下标即可 O(logn) 查询到最大值。
时间复杂度 O(nlogn)
 */