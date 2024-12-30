public class Solution941 {
    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return false;
        }
        // 从左往右找 "山顶"
        int left = 0;
        for (int i = 1; i < len; ) {
            if (arr[i] > arr[i - 1]) {
                i++;
            } else if (arr[i] == arr[i - 1]) {
                return false;
            } else {
                // 山顶
                left = i - 1;
                break;
            }
        }
        // 从右往左找 "山顶"
        int right = len - 1;
        for (int i = len - 2; i >= 0; ) {
            if (arr[i] > arr[i + 1]) {
                i--;
            } else if (arr[i] == arr[i + 1]) {
                return false;
            } else {
                right = i + 1;
                break;
            }
        }
        // 判断两个 "山顶" 是否同一个
        return left == right;
    }
}
/*
941. 有效的山脉数组
https://leetcode.cn/problems/valid-mountain-array/

第 111 场周赛 T1。

给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
- arr.length >= 3
- 在 0 < i < arr.length - 1 条件下，存在 i 使得：
  - arr[0] < arr[1] < ... arr[i-1] < arr[i]
  - arr[i] > arr[i+1] > ... > arr[arr.length - 1]
提示：
1 <= arr.length <= 10^4
0 <= arr[i] <= 10^4

分别 从左往右 从右往左 找 "山顶"，看是否同一个 "山顶" 即可。
 */