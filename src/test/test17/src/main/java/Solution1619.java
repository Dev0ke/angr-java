import java.util.Arrays;

public class Solution1619 {
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = n / 20; i < n - n / 20; i++) {
            sum += arr[i];
        }
        return sum / (n * 0.9);
    }
}
/*
1619. 删除某些元素后的数组均值
https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/description/

给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
与 标准答案 误差在 10^-5 的结果都被视为正确结果。
提示：
20 <= arr.length <= 1000
arr.length 是 20 的 倍数
0 <= arr[i] <= 10^5

模拟。
时间复杂度 O(nlogn)。
 */