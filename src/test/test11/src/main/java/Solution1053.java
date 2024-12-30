public class Solution1053 {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = n - 1;
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j--;
                }

                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                break;
            }
        }
        return arr;
    }
}
/*
1053. 交换一次的先前排列
https://leetcode.cn/problems/previous-permutation-with-one-swap/

给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
如果无法这么操作，就请返回原数组。
提示：
1 <= arr.length <= 10^4
1 <= arr[i] <= 10^4

贪心。尽可能地保持前面的元素不变是最优的。
时间复杂度 O(n)
空间复杂度 O(1)
 */