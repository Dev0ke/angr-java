import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionP1063 {
    public int validSubarrays(int[] nums) {
        int n = nums.length;

        Deque<Integer> stack2 = new ArrayDeque<>();
        // 单调栈 找 右侧第一个严格小于 nums[i] 的下标
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && nums[i] <= nums[stack2.peek()]) {
                stack2.pop();
            }
            if (!stack2.isEmpty()) {
                right[i] = stack2.peek();
            }
            stack2.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += right[i] - i;
        }
        return res;
    }
}
/*
$1063. 有效子数组的数目
https://leetcode.cn/problems/number-of-valid-subarrays/

给定一个整数数组 nums ，返回满足下面条件的 非空、连续 子数组的数目：
- 子数组 是数组的 连续 部分。
- 子数组最左边的元素不大于子数组中的其他元素 。
提示：
1 <= nums.length <= 5 * 10^4
0 <= nums[i] <= 10^5

单调栈，找每个元素的贡献值。
 */