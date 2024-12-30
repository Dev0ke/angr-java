public class SolutionP1228 {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int d1 = arr[1] - arr[0];
        int d2 = arr[n - 1] - arr[n - 2];
        if (d1 == 0 || d2 == 0) {
            return arr[0];
        }
        // 公差
        int d = (d1 / d2 == 2) ? d2 : d1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] != d) {
                return arr[i] - d;
            }
        }
        return -1;
    }
}
/*
$1228. 等差数列中缺失的数字
https://leetcode.cn/problems/missing-number-in-arithmetic-progression/

在某个数组 arr 中，值符合等差数列的数值规律：在 0 <= i < arr.length - 1 的前提下，arr[i+1] - arr[i] 的值都相等。
我们会从该数组中删除一个 既不是第一个 也 不是最后一个的值，得到一个新的数组  arr。
给你这个缺值的数组 arr，返回 被删除的那个数 。
提示：
3 <= arr.length <= 1000
0 <= arr[i] <= 10^5
给定的数组 保证 是一个有效的数组。

求出公差后枚举
 */