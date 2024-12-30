import java.util.HashSet;
import java.util.Set;

public class Solution2249 {
    public int countLatticePoints(int[][] circles) {
        Set<String> hashSet = new HashSet<>();
        for (int[] circle : circles) {
            int xi = circle[0];
            int yi = circle[1];
            int ri = circle[2];
            for (int x = xi - ri; x <= xi + ri; x++) {
                for (int y = yi - ri; y <= yi + ri; y++) {
                    int diffX = x - xi;
                    int diffY = y - yi;
                    if (diffX * diffX + diffY * diffY <= ri * ri) {
                        hashSet.add(x + ":" + y);
                    }
                }
            }
        }
        return hashSet.size();
    }
}
/*
2249. 统计圆内格点数目
https://leetcode.cn/problems/count-lattice-points-inside-a-circle/

第 290 场周赛 T2。

给你一个二维整数数组 circles ，其中 circles[i] = [xi, yi, ri] 表示网格上圆心为 (xi, yi) 且半径为 ri 的第 i 个圆，返回出现在 至少一个 圆内的 格点数目 。
注意：
- 格点 是指整数坐标对应的点。
- 圆周上的点 也被视为出现在圆内的点。
提示：
1 <= circles.length <= 200
circles[i].length == 3
1 <= xi, yi <= 100
1 <= ri <= min(xi, yi)

找出所有符合要求的点，去重后返回数目。
时间复杂度 O(n^2 * C)，理论上界 100*100*200 = 2*10^6，可以过。
 */