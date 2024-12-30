public class Solution1131 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j);
                ans = Math.max(ans, val);
            }
        }
        return ans;
    }

    public int maxAbsValExpr2(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int mxA = Integer.MIN_VALUE, mnA = Integer.MAX_VALUE;
        int mxB = Integer.MIN_VALUE, mnB = Integer.MAX_VALUE;
        int mxC = Integer.MIN_VALUE, mnC = Integer.MAX_VALUE;
        int mxD = Integer.MIN_VALUE, mnD = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = arr1[i], y = arr2[i];
            int a = x + y + i, b = x + y - i;
            mxA = Math.max(mxA, a);
            mnA = Math.min(mnA, a);
            mxB = Math.max(mxB, b);
            mnB = Math.min(mnB, b);
            int c = x - y + i, d = x - y - i;
            mxC = Math.max(mxC, c);
            mnC = Math.min(mnC, c);
            mxD = Math.max(mxD, d);
            mnD = Math.min(mnD, d);
        }
        int a = mxA - mnA;
        int b = mxB - mnB;
        int c = mxC - mnC;
        int d = mxD - mnD;
        return Math.max(Math.max(a, b), Math.max(c, d));
    }
}
/*
1131. 绝对值表达式的最大值
https://leetcode.cn/problems/maximum-of-absolute-value-expression/description/

给你两个长度相等的整数数组，返回下面表达式的最大值：
|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
其中下标 i，j 满足 0 <= i, j < arr1.length。
提示：
2 <= arr1.length == arr2.length <= 40000
-10^6 <= arr1[i], arr2[i] <= 10^6

暴力会 TLE。
时间复杂度 O(n)。
 */