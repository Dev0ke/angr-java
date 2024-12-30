import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP2832 {
    public int[] maximumLengthOfRanges(int[] nums) {
        int n = nums.length;
        // 左侧和右侧第一个 < 和 <= nums[i] 的下标（为了去重）
        int[] L = new int[n], R = new int[n];

        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1); // 哨兵
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && nums[i] >= nums[st.peek()]) st.pop();
            L[i] = st.peek() + 1;
            st.push(i);
        }

        st.clear();
        st.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 1 && nums[i] >= nums[st.peek()]) st.pop();
            R[i] = st.peek() - 1;
            st.push(i);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = R[i] - L[i] + 1;
        }
        return ans;
    }
}
/*
$2832. 每个元素为最大值的最大范围
https://leetcode.cn/problems/maximal-range-that-each-element-is-maximum-in-it/description/

现给定一个由 不同 整数构成的 0 索引数组 nums 。
我们用以下方式定义与 nums 长度相同的 0 索引数组 ans ：
- ans[i] 是子数组 nums[l..r] 的 最大 长度，该子数组中的最大元素等于 nums[i] 。
返回数组 ans 。
注意，子数组 是数组的连续部分。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
所有 nums 中的元素都是不重复的。

前后缀分解，单调栈预处理。
 */