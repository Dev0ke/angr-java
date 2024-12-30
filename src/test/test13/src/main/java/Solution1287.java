import java.util.function.Function;

public class Solution1287 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int span = n / 4 + 1;
        for (int i = 0; i < n; i += span) {
            int finalI = i;
            int l = sortSearch(n, m -> arr[m] >= arr[finalI]); // lower_bound
            int r = sortSearch(n, m -> arr[m] > arr[finalI]); // upper_bound
            if (r - l >= span) {
                return arr[i];
            }
        }
        return -1;
    }

    // func Search(n int, f func(int) bool) int { ... }
    private int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
1287. 有序数组中出现次数超过25%的元素
https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/description/

给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
请你找到并返回这个整数
提示：
1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5

二分查找。
时间复杂度 O(logn)。
 */