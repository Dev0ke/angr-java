import java.util.Arrays;

public class Solution1300 {
    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = Arrays.stream(arr).max().orElseThrow();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(arr, target, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // left-1 < res <= left
        int sum1 = 0;
        int sum2 = 0;
        for (int i : arr) {
            sum1 += Math.min(i, left);
            sum2 += Math.min(i, left - 1);
        }
        return (target - sum2 <= sum1 - target) ? (left - 1) : left;
    }

    // 将数组中所有大于 mid 的值变成 mid 后，数组的和 大于等于 target，FFFTTT
    private boolean checkMid(int[] arr, int target, int mid) {
        int sum = 0;
        for (int i : arr) {
            sum += Math.min(i, mid);
        }
        return sum >= target;
    }
}
/*
1300. 转变数组后最接近目标值的数组和
https://leetcode.cn/problems/sum-of-mutated-array-closest-to-target/

给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，
数组的和最接近  target （最接近表示两者之差的绝对值最小）。
如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
请注意，答案不一定是 arr 中的数字。
提示：
1 <= arr.length <= 10^4
1 <= arr[i], target <= 10^5

二分查找。找到刚好大于 target 的最小 value，答案要么为 value，要么为 value-1。
时间复杂度 O(nlogn)
 */