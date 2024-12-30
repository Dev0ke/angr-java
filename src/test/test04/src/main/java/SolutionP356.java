import java.util.HashSet;
import java.util.Set;

public class SolutionP356 {
    private static final int INF = (int) 1e9;

    public boolean isReflected(int[][] points) {
        long offset = INF;
        int mnX = INF;
        int mxX = -INF;
        Set<Long> set = new HashSet<>();
        for (int[] p : points) {
            int x = p[0], y = p[1];
            mnX = Math.min(mnX, x);
            mxX = Math.max(mxX, x);
            set.add(x * offset + y);
        }

        // x = (minX + maxX) / 2 省去 / 2
        int ansX = mnX + mxX;
        for (int[] p : points) {
            int x = p[0], y = p[1];
            long key = (ansX - x) * offset + y;
            if (!set.contains(key)) return false;
        }
        return true;
    }
}
/*
$356. 直线镜像
https://leetcode.cn/problems/line-reflection/

在一个二维平面空间中，给你 n 个点的坐标。问，是否能找出一条平行于 y 轴的直线，让这些点关于这条直线成镜像排布？
注意：题目数据中可能有重复的点。
提示：
n == points.length
1 <= n <= 10^4
-10^8 <= points[i][j] <= 10^8

这条直线的 x 只能是 x 最小值 和 x 最大值的中点。
然后逐个判断即可。将二维压缩成一维存储。
时间复杂度 O(n)
 */