import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP1950 {
    public int[] findMaximums(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && nums[i] <= nums[st.peek()]) st.pop();
            L[i] = st.peek();
            st.push(i);
        }

        st.clear();
        st.push(n);
        int[] R = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 1 && nums[i] <= nums[st.peek()]) st.pop();
            R[i] = st.peek();
            st.push(i);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int size = R[i] - L[i] - 2;
            ans[size] = Math.max(ans[size], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        return ans;
    }
}
/*
$1950. 所有子数组最小值中的最大值
https://leetcode.cn/problems/maximum-of-minimum-values-in-all-subarrays/description/

给你一个长度为 n 的整数数组 nums ，你需要处理 n 个查询。
对于第 i （0 <= i < n）个查询：
1.你需要先找出 nums 的所有长度为 i + 1 的子数组中的 最小值 。
2.在这些最小值中找出 最大值 作为答案。
返回一个 下标从 0 开始 的长度为 n 的整数数组 ans ，ans[i] 代表第 i 个查询的答案。
提示：
n == nums.length
1 <= n <= 10^5
0 <= nums[i] <= 10^9

单调栈。
时间复杂度 O(n)。
相似题目: B. Mike and Feet
https://codeforces.com/contest/547/problem/B
 */