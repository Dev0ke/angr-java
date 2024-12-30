import java.util.TreeMap;

public class SolutionP3009 {
    public int maxIntersectionCount(int[] y) {
        int n = y.length;
        for (int i = 0; i < n; i++) {
            y[i] *= 2;
        }
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (int i = 1; i < n; i++) {
            int l = Math.min(y[i], y[i - 1]), r = Math.max(y[i], y[i - 1]);
            d.merge(l, 1, Integer::sum);
            d.merge(r + 1, -1, Integer::sum);
            d.merge(y[i], -1, Integer::sum);
            d.merge(y[i] + 1, 1, Integer::sum);
        }
        d.merge(y[n - 1], 1, Integer::sum);
        d.merge(y[n - 1] + 1, -1, Integer::sum);
        int s = 0, res = 0;
        for (Integer c : d.values()) {
            s += c;
            res = Math.max(res, s);
        }
        return res;
    }
}
/*
3009. 折线图上的最大交点数量
https://leetcode.cn/problems/maximum-number-of-intersections-on-the-chart/description/

有一条由 n 个点连接而成的折线图。给定一个 下标从 1 开始 的整数数组 y，第 k 个点的坐标是 (k, y[k])。图中没有水平线，即没有两个相邻的点有相同的 y 坐标。
假设在图中任意画一条无限长的水平线。请返回这条水平线与折线相交的最多交点数。
提示：
2 <= y.length <= 10^5
1 <= y[i] <= 10^9
对于范围 [1, n - 1] 内的所有 i，都有 y[i] != y[i + 1]

本题如果使用差分数组解决，细节会比较多，我将尽可能地为大家理清思路，把题目转化为差分数组的模板。
对于两个相邻的点，假设它们的纵坐标分别为 y1 和 y2 。不失一般性，我们不妨假设 y1 <y2 ，如果只考虑纵坐标为整数的水平线，那么这两个点形成的折线会对纵坐标在 [y1 ,y2 ] 这个区间内的水平线产生一个贡献，可以用差分数组来完成区间修改。假设 d 是差分数组，那么就有 d[y1] 加 1，d[y2 +1] 减 1。
但是这样计算会有重复，对于三个相邻的点，假设它们的纵坐标分别为 y1,y2,y3，那么纵坐标为 y2 的水平线就会多出一个贡献。回到两个相邻点的情况，假设它们的纵坐标分别为 y1 和 y2 ，注意这里不再假设 y1 <y2 。我们要减少一次 y2  的贡献，具体到差分数组来说就是 d[y2 ] 减 1，d[y2 +1] 加 1。当然对于最后一个点 yn ，因为后续没有折线，yn  不会产生重复贡献，所以最后要单独为纵坐标为 yn  的水平线再增加一个贡献。
但是这样就结束了吗？注意我们之前探讨的都是纵坐标为整数的水平线，但是答案有可能是纵坐标为小数的水平线，比如用例 1 的最优水平线纵坐标就是在 (1,2) 这个开区间内。对于这种情况，我们可以只考虑纵坐标小数部分为 0.5 的水平线，然后将纵轴坐标扩展一倍，也即将输入的 y 数组所有数都乘 2，就能考虑到原先情况下的小数情况。
经过这几层转化之后，本题就是一个差分数组 + 离散化的模板了，离散化的部分可以用 std::map 实现。
https://leetcode.cn/problems/maximum-number-of-intersections-on-the-chart/solutions/2809495/c-chai-fen-shu-zu-by-mo-du-zuo-ti-jia-na1k/
 */