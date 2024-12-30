public class Solution1802 {
    public int maxValue(int n, int index, int maxSum) {
        int left = 0;
        int right = maxSum + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(n, index, maxSum, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // nums[index] 高度为 mid 时，sum 是否 <= maxSum TTTFFF
    private boolean checkMid(int n, int index, int maxSum, int mid) {
        // nums[i] 是 正整数
        mid -= 1;
        long sum = (long) mid * mid;
        sum += n;

        // 减去 left 越界部分 h = index+1
        if (index + 1 < mid) {
            // 宽: mid - index - 1
            // 首项: 1
            // 末项: 宽
            sum -= (mid - index) * (mid - index - 1L) / 2;
        }

        // 减去 right 越界部分 h = n-index
        if (n - index < mid) {
            // 宽: mid - n + index
            // 首项: 1
            // 末项: 宽
            sum -= (mid - n + index + 1L) * (mid - n + index) / 2;
        }

        return sum <= maxSum;
    }
}
/*
1802. 有界数组中指定下标处的最大值
https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/

给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
- nums.length == n
- nums[i] 是 正整数 ，其中 0 <= i < n
- abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
- nums 中所有元素之和不超过 maxSum
- nums[index] 的值被 最大化
返回你所构造的数组中的 nums[index] 。
注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
提示：
1 <= n <= maxSum <= 10^9
0 <= index < n
 */