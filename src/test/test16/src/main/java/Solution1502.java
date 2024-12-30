import java.util.Arrays;

public class Solution1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        // 2 <= arr.length <= 1000
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
/*
1502. 判断能否形成等差数列
https://leetcode.cn/problems/can-make-arithmetic-progression-from-sequence/

第 196 场周赛 T1。

给你一个数字数组 arr 。
如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
提示：
2 <= arr.length <= 1000
-10^6 <= arr[i] <= 10^6

排序后比较即可。
时间复杂度 O(nlogn)
空间复杂度 O(1)
 */
