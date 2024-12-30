import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3113 {
    public long numberOfSubarrays(int[] nums) {
        long ans = 0;
        Deque<int[]> st = new ArrayDeque<>();
        st.push(new int[]{Integer.MAX_VALUE, 0}); // 哨兵
        for (int x : nums) {
            while (x > st.peek()[0]) {
                st.pop();
            }
            if (x == st.peek()[0]) {
                st.peek()[1]++;
            } else {
                st.push(new int[]{x, 1});
            }
            ans += st.peek()[1];
        }
        return ans;
    }
}
/*
3113. 边界元素是最大值的子数组数目
https://leetcode.cn/problems/find-the-number-of-subarrays-where-boundary-elements-are-maximum/description/

第 128 场双周赛 T4。

给你一个 正 整数数组 nums 。
请你求出 nums 中有多少个子数组，满足子数组中 第一个 和 最后一个 元素都是这个子数组中的 最大 值。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

单调栈。
时间复杂度 O(n)。
 */