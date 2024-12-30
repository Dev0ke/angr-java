public class Solution2481 {
    public int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return n / 2;
        }
        return n;
    }
}
/*
2481. 分割圆的最少切割次数
https://leetcode.cn/problems/minimum-cuts-to-divide-a-circle/

第 92 场双周赛 T1。

圆内一个 有效切割 ，符合以下二者之一：
- 该切割是两个端点在圆上的线段，且该线段经过圆心。
- 该切割是一端在圆心另一端在圆上的线段。
一些有效和无效的切割如下图所示。
给你一个整数 n ，请你返回将圆切割成相等的 n 等分的 最少 切割次数。
提示：
1 <= n <= 100

数学，切割成相等的 n 等分，当 n 为奇数使，需切 n 到（n == 1 时需特判）
 */