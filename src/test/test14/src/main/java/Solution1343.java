public class Solution1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int sum = 0, ans = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= k * threshold) ans++;
        for (int i = k; i < n; i++) {
            sum -= arr[i - k];
            sum += arr[i];
            if (sum >= k * threshold) ans++;
        }
        return ans;
    }
}
/*
1343. 大小为 K 且平均值大于等于阈值的子数组数目
https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

给你一个整数数组 arr 和两个整数 k 和 threshold 。
请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
提示：
1 <= arr.length <= 10^5
1 <= arr[i] <= 10^4
1 <= k <= arr.length
0 <= threshold <= 10^4

定长滑动窗口。
时间复杂度 O(n)
 */