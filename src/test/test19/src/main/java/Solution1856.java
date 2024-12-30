import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1856 {
    private static final int MOD = (int) (1e9 + 7);

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        // 左侧和右侧第一个 < 和 <= nums[i] 的下标（为了去重）
        int[] L = new int[n], R = new int[n];

        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1); // 哨兵
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && nums[i] <= nums[st.peek()]) st.pop();
            L[i] = st.peek() + 1;
            st.push(i);
        }

        st.clear();
        st.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 1 && nums[i] < nums[st.peek()]) st.pop();
            R[i] = st.peek() - 1;
            st.push(i);
        }

        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (ps[R[i] + 1] - ps[L[i]]) * nums[i]);
        }
        return (int) (ans % MOD);
    }
}
/*
1856. 子数组最小乘积的最大值
https://leetcode.cn/problems/maximum-subarray-min-product/

一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。
- 比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。
给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  10^9 + 7 取余 的结果。
请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
子数组 定义为一个数组的 连续 部分。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^7

单调栈 + 贪心
时间复杂度 O(n)
相似题目: 1793. 好子数组的最大分数
https://leetcode.cn/problems/maximum-score-of-a-good-subarray/
2281. 巫师的总力量和
https://leetcode.cn/problems/sum-of-total-strength-of-wizards/
 */