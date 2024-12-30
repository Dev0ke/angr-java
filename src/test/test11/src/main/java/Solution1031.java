public class Solution1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(dp(nums, firstLen, secondLen), dp(nums, secondLen, firstLen));
    }

    private int dp(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        // f[i] 表示 [0, i) 之间长为 firstLen 的最大和
        int[] f = new int[n + 1];
        int l = 0, r = 0, sum = 0, max = 0;
        while (r < n) {
            sum += nums[r];
            while (r - l + 1 > firstLen) sum -= nums[l++];
            max = Math.max(max, sum);
            f[r + 1] = Math.max(f[r], max);
            r++;
        }
        r = l = sum = max = 0;
        while (r < n) {
            sum += nums[r];
            while (r - l + 1 > secondLen) sum -= nums[l++];
            max = Math.max(max, sum + f[l]);
            r++;
        }
        return max;
    }
}
/*
1031. 两个非重叠子数组的最大和
https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/

给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。（这里需要澄清的是，长为 L 的子数组可以出现在长为 M 的子数组之前或之后。）
从形式上看，返回最大的 V，而 V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) 并满足下列条件之一：
0 <= i < i + L - 1 < j < j + M - 1 < A.length, 或
0 <= j < j + M - 1 < i < i + L - 1 < A.length.
提示：
L >= 1
M >= 1
L + M <= A.length <= 1000
0 <= A[i] <= 1000

双指针 滑动窗口 动态规划
L + M
M + L
各判断一次
 */