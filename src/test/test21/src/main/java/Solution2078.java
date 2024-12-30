public class Solution2078 {
    public int maxDistance(int[] colors) {
        int len = colors.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (colors[i] != colors[j]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}
/*
2078. 两栋颜色不同且距离最远的房子
https://leetcode.cn/problems/two-furthest-houses-with-different-colors/

第 268 场周赛 T1。

街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
返回 两栋 颜色 不同 房子之间的 最大 距离。
第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。
提示：
n == colors.length
2 <= n <= 100
0 <= colors[i] <= 100
生成的测试数据满足 至少 存在 2 栋颜色不同的房子

看到数据范围不超过 100，直接暴力即可。
时间复杂度 O(n^2)
 */