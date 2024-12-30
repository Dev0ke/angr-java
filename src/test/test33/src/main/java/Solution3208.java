public class Solution3208 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] ps = new int[n * 2 + 1];
        for (int i = 1; i < n * 2; i++) {
            int ai = (colors[(i - 1) % n] + colors[i % n]) % 2 == 1 ? 0 : 1;
            ps[i] = ps[i - 1] + ai;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ps[k + i - 1] - ps[i] == 0) {
                ans++;
            }
        }
        return ans;
    }
}
/*
3208. 交替组 II
https://leetcode.cn/problems/alternating-groups-ii/description/

第 134 场双周赛 T3。

给你一个整数数组 colors 和一个整数 k ，colors表示一个由红色和蓝色瓷砖组成的环，第 i 块瓷砖的颜色为 colors[i] ：
- colors[i] == 0 表示第 i 块瓷砖的颜色是 红色 。
- colors[i] == 1 表示第 i 块瓷砖的颜色是 蓝色 。
环中连续 k 块瓷砖的颜色如果是 交替 颜色（也就是说除了第一块和最后一块瓷砖以外，中间瓷砖的颜色与它 左边 和 右边 的颜色都不同），那么它被称为一个 交替 组。
请你返回 交替 组的数目。
注意 ，由于 colors 表示一个 环 ，第一块 瓷砖和 最后一块 瓷砖是相邻的。
提示：
3 <= colors.length <= 10^5
0 <= colors[i] <= 1
3 <= k <= colors.length

前缀和。环形数组多一个下标取模。
时间复杂度 O(n)。
相似题目: 3152. 特殊数组 II
https://leetcode.cn/problems/special-array-ii/description/
 */