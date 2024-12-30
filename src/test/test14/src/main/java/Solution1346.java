public class Solution1346 {
    public boolean checkIfExist(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*
1346. 检查整数及其两倍数是否存在
https://leetcode.cn/problems/check-if-n-and-its-double-exist/

给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
更正式地，检查是否存在两个下标 i 和 j 满足：
- i != j
- 0 <= i, j < arr.length
- arr[i] == 2 * arr[j]
提示：
2 <= arr.length <= 500
-10^3 <= arr[i] <= 10^3

模拟。
时间复杂度 O(n^2)
 */