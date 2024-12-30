public class Solution1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for (int i = 0; i + 2 < n; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}
/*
1550. 存在连续三个奇数的数组
https://leetcode.cn/problems/three-consecutive-odds/description/

给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
提示：
1 <= arr.length <= 1000
1 <= arr[i] <= 1000

遍历。
时间复杂度 O(n)。
 */