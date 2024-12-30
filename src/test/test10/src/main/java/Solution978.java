public class Solution978 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int ans = 1;
        int l = 0, r = 0;
        while (r < n - 1) {
            if (l == r) {
                if (arr[l] == arr[l + 1]) {
                    l++;
                }
                r++;
            } else {
                if ((long) (arr[r - 1] - arr[r]) * (arr[r] - arr[r + 1]) < 0) {
                    r++;
                } else {
                    l = r;
                }
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
/*
978. 最长湍流子数组
https://leetcode.cn/problems/longest-turbulent-subarray/description/

给定一个整数数组 arr ，返回 arr 的 最大湍流子数组的长度 。
如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是 湍流子数组 。
更正式地来说，当 arr 的子数组 A[i], A[i+1], ..., A[j] 满足仅满足下列条件时，我们称其为湍流子数组：
- 若 i <= k < j ：
  - 当 k 为奇数时， A[k] > A[k+1]，且
  - 当 k 为偶数时，A[k] < A[k+1]；
- 或 若 i <= k < j ：
  - 当 k 为偶数时，A[k] > A[k+1] ，且
  - 当 k 为奇数时， A[k] < A[k+1]。
提示：
1 <= arr.length <= 4 * 10^4
0 <= arr[i] <= 10^9

滑动窗口 / 双指针
时间复杂度 O(n)
 */