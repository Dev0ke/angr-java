public class SolutionP573 {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        // 每个 坚果 到树的距离（乘以 2 表示往返）
        int tot = 0;
        for (int[] nut : nuts) {
            tot += manhattan(tree, nut) * 2;
        }
        int min = Integer.MAX_VALUE;
        for (int[] nut : nuts) {
            min = Math.min(min, tot - manhattan(tree, nut) + manhattan(squirrel, nut));
        }
        return min;
    }

    private int manhattan(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }
}
/*
$573. 松鼠模拟
https://leetcode.cn/problems/squirrel-simulation/

现在有一棵树，一只松鼠和一些坚果。位置由二维网格的单元格表示。你的目标是找到松鼠收集所有坚果的最小路程，且坚果是一颗接一颗地被放在树下。
松鼠一次最多只能携带一颗坚果，松鼠可以向上，向下，向左和向右四个方向移动到相邻的单元格。移动次数表示路程。
注意:
所有给定的位置不会重叠。
松鼠一次最多只能携带一颗坚果。
给定的坚果位置没有顺序。
高度和宽度是正整数。 3 <= 高度 * 宽度 <= 10,000。
给定的网格至少包含一颗坚果，唯一的一棵树和一只松鼠。

贪心。除了起始节点外，其他坚果都是往返走两遍。
让起始路程替换掉一步坚果到松树的距离，取最小值即可。
 */