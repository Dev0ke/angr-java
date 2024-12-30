import java.util.Arrays;

public class Solution593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int edge12 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int edge13 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        int edge14 = (p1[0] - p4[0]) * (p1[0] - p4[0]) + (p1[1] - p4[1]) * (p1[1] - p4[1]);
        int edge23 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        int edge24 = (p2[0] - p4[0]) * (p2[0] - p4[0]) + (p2[1] - p4[1]) * (p2[1] - p4[1]);
        int edge34 = (p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1]);

        // 1 2 3
        int[] triangle1 = {edge12, edge13, edge23};
        // 1 2 4
        int[] triangle2 = {edge12, edge14, edge24};
        // 1 3 4
        int[] triangle3 = {edge13, edge14, edge34};
        // 2 3 4
        int[] triangle4 = {edge23, edge24, edge34};

        Arrays.sort(triangle1);
        Arrays.sort(triangle2);
        Arrays.sort(triangle3);
        Arrays.sort(triangle4);

        // 边长非 0 && 等边 && 全等
        return triangle1[0] > 0 && triangle1[0] == triangle1[1] && Arrays.equals(triangle1, triangle2) && Arrays.equals(triangle1, triangle3) && Arrays.equals(triangle1, triangle4);
    }
}
/*
593. 有效的正方形
https://leetcode.cn/problems/valid-square/

给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
一个 有效的正方形 有四条等边和四个等角(90度角)。
提示:
p1.length == p2.length == p3.length == p4.length == 2
-10^4 <= xi, yi <= 10^4

任意两个三角形全等，且为等腰三角形
 */