import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP2863 {
    public int maxSubarrayLength(int[] nums) {
        int n = nums.length;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty() || nums[i] < nums[st.peek()]) {
                st.push(i);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                int popIdx = st.pop();
                max = Math.max(max, popIdx - i + 1);
            }
        }
        return max;
    }
}
/*
$2863. 最长半递减子数组的长度
https://leetcode.cn/problems/maximum-length-of-semi-decreasing-subarrays/description/

给定一个整数数组 nums。
返回 nums 的 最长半递减子数组 的长度，如果没有这样的子数组则返回 0。
- 子数组 是数组内的连续非空元素序列。
- 一个非空数组是 半递减 的，如果它的第一个元素 严格大于 它的最后一个元素。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

https://leetcode.cn/problems/maximum-length-of-semi-decreasing-subarrays/solutions/2605989/onyong-zui-shou-xi-de-zhan-jiu-ke-yi-jie-s11i/
只有把小于最后一个数的数压进栈
如果把大于等于最后一个数的数压栈，毫无意义
因为这说明，最后一个是最小的
那么第一个数与最后一个数的距离，必然是最大的，都不需要计算。
---
一旦前面的数，发现了栈里有比它小的
因为前面第一个大于栈顶的数，必然是距离最远的
这个时候，就持续pop，因为可能栈底的数字可能
仍比当前数字小
利用内在的基于index的顺序
越靠前的数字，减去越靠后的数字，间距越大，也就越长
所以答案肯定与 第一个比栈顶大的数字 有关
 */