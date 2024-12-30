import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution907 {
    private static final long MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        // step1: 求左侧第一个 "严格小于" arr[i] 的下标，如没有则为 -1
        Deque<Integer> stack1 = new ArrayDeque<>();
        int[] left = new int[n];
        Arrays.fill(left, -1);
        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && arr[i] <= arr[stack1.peek()]) {
                stack1.pop();
            }
            if (!stack1.isEmpty()) {
                left[i] = stack1.peek();
            }
            stack1.push(i);
        }

        // step2: 求右侧第一个 "小于等于" arr[i] 的下标，如没有则为 n
        Deque<Integer> stack2 = new ArrayDeque<>();
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = n - 1; i >= 0; i--) {
            // <= 为避免重复计算
            while (!stack2.isEmpty() && arr[i] < arr[stack2.peek()]) {
                stack2.pop();
            }
            if (!stack2.isEmpty()) {
                right[i] = stack2.peek();
            }
            stack2.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long cnt = (long) (i - left[i]) * (right[i] - i) % MOD;
            sum += arr[i] * cnt % MOD;
            sum %= MOD;
        }
        return (int) sum;
    }
}
/*
907. 子数组的最小值之和
https://leetcode.cn/problems/sum-of-subarray-minimums/

给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
由于答案可能很大，因此 返回答案模 10^9 + 7 。
提示：
1 <= arr.length <= 3 * 10^4
1 <= arr[i] <= 3 * 10^4

单调栈分别求出左右两侧第一个比 arr[i] 小的下标。
假设 arr[i] 为 arr[l,r] 区间内的最小值，其贡献值为 arr[i] 本身乘以 arr[l,r] 区间内包含 arr[i] 子数组的数量，即为 (i-l)*(r-i) 的乘积。
时间复杂度 O(n)
 */