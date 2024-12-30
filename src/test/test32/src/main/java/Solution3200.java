public class Solution3200 {
    public int maxHeightOfTriangle(int red, int blue) {
        int h1 = getH(new int[]{red, blue});
        int h2 = getH(new int[]{blue, red});
        return Math.max(h1, h2);
    }

    private int getH(int[] a) {
        int i = 0, h = 0;
        while (a[i] - (h + 1) >= 0) {
            a[i] -= (h + 1);
            i = i ^ 1;
            h++;
        }
        return h;
    }
}
/*
3200. 三角形的最大高度
https://leetcode.cn/problems/maximum-height-of-a-triangle/description/

第 404 场周赛 T1。

给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第 3 行有 3 个球，依此类推。
每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。
返回可以实现的三角形的 最大 高度。
提示：
1 <= red, blue <= 100

模拟。
时间复杂度 O(sqrt(red) + sqrt(blue))。
 */