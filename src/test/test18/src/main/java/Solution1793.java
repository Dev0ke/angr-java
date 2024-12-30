import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1793 {
    public int maximumScore(int[] nums, int k) {
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

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = L[i], r = R[i];
            if (l <= k && k <= r) {
                ans = Math.max(ans, nums[i] * (r - l + 1));
            }
        }
        return ans;
    }
}
/*
1793. 好子数组的最大分数
https://leetcode.cn/problems/maximum-score-of-a-good-subarray/

给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
请你返回 好 子数组的最大可能 分数 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 2 * 10^4
0 <= k < nums.length

相似题目: 907. 子数组的最小值之和
https://leetcode.cn/problems/sum-of-subarray-minimums/
1856. 子数组最小乘积的最大值
https://leetcode.cn/problems/maximum-subarray-min-product/
 */