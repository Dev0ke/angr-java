public class Solution1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // 预处理 否则 TLE
        boolean[] asc = new boolean[n];
        asc[n - 1] = true;
        // 右到左
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                asc[i] = true;
            } else {
                break;
            }
        }

        int min = n;
        // i=-1 左侧一个都不取
        for (int i = -1; i < n - 1; i++) {
            // [0,i] 段非递增，结束循环
            if (i - 1 >= 0 && arr[i - 1] > arr[i]) {
                break;
            }

            // 固定 i，[i+1,n-1] 二分找 minJ
            int left = i + 1;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                int pre = (i == -1) ? 0 : arr[i];
                if (checkMid(arr, asc, pre, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int minJ = left;
            // 距离
            int dist = (i == -1) ? minJ : minJ - i - 1;
            min = Math.min(min, dist);
        }
        return min;
    }

    // [0,i] [i+1,n-1] FFFTTT
    private boolean checkMid(int[] arr, boolean[] asc, int pre, int mid) {
        return arr[mid] >= pre && asc[mid];
    }
}
/*
1574. 删除最短的子数组使剩余数组有序
https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/

给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
一个子数组指的是原数组中连续的一个子序列。
请你返回满足题目要求的最短子数组的长度。
提示：
1 <= arr.length <= 10^5
0 <= arr[i] <= 10^9

二分
时间复杂度 O(nlogn)
 */