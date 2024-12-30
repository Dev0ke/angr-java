public class Solution391 {
    public boolean isRectangleCover(int[][] rectangles) {
        int[] r0 = rectangles[0];
        int mx = r0[0], my = r0[1], ma = r0[2], mb = r0[3];
        int s = 0, s1 = 0, s2 = 0, s3 = 0;
        for (int[] r : rectangles) {
            int x = r[0], y = r[1], a = r[2], b = r[3];
            mx = Math.min(mx, x);
            my = Math.min(my, y);
            ma = Math.max(ma, a);
            mb = Math.max(mb, b);
            int x1 = a - x, x2 = a * a - x * x, y1 = b - y, y2 = b * b - y * y;
            s += x1 * y1;
            s1 += x2 * y1;
            s2 += x1 * y2;
            s3 += x2 * y2;
        }
        return s == (ma - mx) * (mb - my)
                && s1 == (ma * ma - mx * mx) * (mb - my)
                && s2 == (ma - mx) * (mb * mb - my * my)
                && s3 == (ma * ma - mx * mx) * (mb * mb - my * my);
    }
}
/*
391. 完美矩形
https://leetcode.cn/problems/perfect-rectangle/description/

给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
提示：
1 <= rectangles.length <= 2 * 10^4
rectangles[i].length == 4
-10^5 <= xi, yi, ai, bi <= 10^5

格林公式
时间复杂度 O(n)
https://leetcode.cn/problems/perfect-rectangle/solutions/1105335/ge-lin-gong-shi-shuang-chao-100-by-aijk-h7x6
 */