import java.util.Arrays;

public class Solution1471 {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int m = arr[(n - 1) / 2]; // 题目重新定义中位数
        int[] ans = new int[k];
        int l = 0, r = n - 1;
        for (int i = 0; i < k; i++) {
            if (compare(arr, l, r, m) > 0) ans[i] = arr[l++];
            else ans[i] = arr[r--];
        }
        return ans;
    }

    private int compare(int[] arr, int i, int j, int m) {
        int abs1 = Math.abs(arr[i] - m);
        int abs2 = Math.abs(arr[j] - m);
        if (abs1 == abs2) return arr[i] - arr[j];
        return abs1 - abs2;
    }
}
/*
1471. 数组中的 k 个最强值
https://leetcode.cn/problems/the-k-strongest-values-in-an-array/description/

给你一个整数数组 arr 和一个整数 k 。
设 m 为数组的中位数，只要满足下述两个前提之一，就可以判定 arr[i] 的值比 arr[j] 的值更强：
- |arr[i] - m| > |arr[j] - m|
- |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
请返回由数组中最强的 k 个值组成的列表。答案可以以 任意顺序 返回。
中位数 是一个有序整数列表中处于中间位置的值。形式上，如果列表的长度为 n ，那么中位数就是该有序列表（下标从 0 开始）中位于 ((n - 1) / 2) 的元素。
- 例如 arr = [6, -3, 7, 2, 11]，n = 5：数组排序后得到 arr = [-3, 2, 6, 7, 11] ，数组的中间位置为 m = ((5 - 1) / 2) = 2 ，中位数 arr[m] 的值为 6 。
- 例如 arr = [-7, 22, 17, 3]，n = 4：数组排序后得到 arr = [-7, 3, 17, 22] ，数组的中间位置为 m = ((4 - 1) / 2) = 1 ，中位数 arr[m] 的值为 3 。
提示：
1 <= arr.length <= 10^5
-10^5 <= arr[i] <= 10^5
1 <= k <= arr.length

双指针 + 中位数。
距离中位数越远的数越强。注意这个中位数的定义 跟普遍理解上的差异。
时间复杂度 O(nlogn)。
 */