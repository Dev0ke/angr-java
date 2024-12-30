import java.util.Arrays;

public class Solution3047 {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;

        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, (o1, o2) -> {
            if (bottomLeft[o1][0] == bottomLeft[o2][0]) {
                return Integer.compare(bottomLeft[o1][1], bottomLeft[o2][1]);
            }
            return Integer.compare(bottomLeft[o1][0], bottomLeft[o2][0]);
        });

        long maxL = 0;
        for (int a = 0; a < n; a++) {
            int i = ids[a];
            for (int b = a + 1; b < n; b++) {
                int j = ids[b];

                int deltaX = Math.min(topRight[i][0], topRight[j][0]) - bottomLeft[j][0];
                int deltaY = Math.min(topRight[i][1], topRight[j][1]) - Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int delta = Math.min(deltaX, deltaY);
                maxL = Math.max(maxL, delta);
            }
        }
        return maxL * maxL;
    }
}
/*
3047. 求交集区域内的最大正方形面积
https://leetcode.cn/problems/find-the-largest-area-of-square-inside-two-rectangles/description/

第 386 场周赛 T2。

在二维平面上存在 n 个矩形。给你两个下标从 0 开始的二维整数数组 bottomLeft 和 topRight，两个数组的大小都是 n x 2 ，其中 bottomLeft[i] 和 topRight[i] 分别代表第 i 个矩形的 左下角 和 右上角 坐标。
我们定义 向右 的方向为 x 轴正半轴（x 坐标增加），向左 的方向为 x 轴负半轴（x 坐标减少）。同样地，定义 向上 的方向为 y 轴正半轴（y 坐标增加），向下 的方向为 y 轴负半轴（y 坐标减少）。
你可以选择一个区域，该区域由两个矩形的 交集 形成。你需要找出能够放入该区域 内 的 最大 正方形面积，并选择最优解。
返回能够放入交集区域的正方形的 最大 可能面积，如果矩形之间不存在任何交集区域，则返回 0。
提示：
n == bottomLeft.length == topRight.length
2 <= n <= 10^3
bottomLeft[i].length == topRight[i].length == 2
1 <= bottomLeft[i][0], bottomLeft[i][1] <= 10^7
1 <= topRight[i][0], topRight[i][1] <= 10^7
bottomLeft[i][0] < topRight[i][0]
bottomLeft[i][1] < topRight[i][1]

枚举。
排序使一维有序，再比较另一个维交集。
时间复杂度 O(n^2)
 */
