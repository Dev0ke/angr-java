public class Solution2202 {
    public int maximumTop(int[] nums, int k) {
        int len = nums.length;

        // 执行完 k 次操作以后，栈一定为空，请你返回 -1 。
        if (len == 1 && k % 2 == 1) {
            return -1;
        }

        int max = 0;
        if (len >= k) {
            // k-1 次删除，第 k 次放回
            for (int i = 0; i < k - 1; i++) {
                max = Math.max(max, nums[i]);
            }
            // k 次删除
            if (k <= len - 1) {
                max = Math.max(max, nums[k]);
            }
        } else {
            for (int i = 0; i < len; i++) {
                max = Math.max(max, nums[i]);
            }
        }
        return max;
    }
}
/*
2202. K 次操作后最大化顶端元素
https://leetcode.cn/problems/maximize-the-topmost-element-after-k-moves/

第 284 场周赛 T3。

给你一个下标从 0 开始的整数数组 nums ，它表示一个 栈 ，其中 nums[0] 是栈顶的元素。
每一次操作中，你可以执行以下操作 之一 ：
- 如果栈非空，那么 删除 栈顶端的元素。
- 如果存在 1 个或者多个被删除的元素，你可以从它们中选择任何一个，添加 回栈顶，这个元素成为新的栈顶元素。
同时给你一个整数 k ，它表示你总共需要执行操作的次数。
请你返回 恰好 执行 k 次操作以后，栈顶元素的 最大值 。如果执行完 k 次操作以后，栈一定为空，请你返回 -1 。
提示：
1 <= nums.length <= 10^5
0 <= nums[i], k <= 10^9

贪心。只需考虑两种边界情况：
case1: k-1 次删除，第 k 次放回
case2: k 次删除
时间复杂度 O(n)
 */