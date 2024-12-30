public class Solution1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        for (int num1 : arr1) {
            if (check(arr2, d, num1)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean check(int[] arr2, int d, int num) {
        for (int num2 : arr2) {
            if (Math.abs(num2 - num) <= d) {
                return false;
            }
        }
        return true;
    }
}
/*
1385. 两个数组间的距离值
https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/

给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
提示：
1 <= arr1.length, arr2.length <= 500
-10^3 <= arr1[i], arr2[j] <= 10^3
0 <= d <= 100

暴力。
时间复杂度 O(n^2) 理论上界 <= 500 * 500
 */