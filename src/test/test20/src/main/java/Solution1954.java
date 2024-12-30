public class Solution1954 {
    public long minimumPerimeter(long neededApples) {
        long[] sum = new long[62997];
        for (int i = 1; i < 62997; i++) {
            sum[i] = sum[i - 1] + 12L * i * i;
            if (sum[i] >= neededApples) {
                return i * 8;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // long[] sum = new long[n] n 可以先取一个较大的数，然后计算边界值时的 i，再缩小到临界值，降低判题时的内存使用率
        // 10^15 503968
        // 那么 n 可以取 503968 / 8 + 1, 即 62997
        long max = (long) Math.pow(10, 15);
        System.out.println(new Solution1954().minimumPerimeter(max));
    }

    public long minimumPerimeter2(long neededApples) {
        long n = (long) Math.cbrt(neededApples / 4.0);
        if (2 * n * (n + 1) * (2 * n + 1) < neededApples) {
            n++;
        }
        return 8 * n;
    }
}
/*
1954. 收集足够苹果的最小花园周长
https://leetcode.cn/problems/minimum-garden-perimeter-to-collect-enough-apples/

第 252 场周赛 T3。

给你一个用无限二维网格表示的花园，每一个 整数坐标处都有一棵苹果树。整数坐标 (i, j) 处的苹果树有 |i| + |j| 个苹果。
你将会买下正中心坐标是 (0, 0) 的一块 正方形土地 ，且每条边都与两条坐标轴之一平行。
给你一个整数 neededApples ，请你返回土地的 最小周长 ，使得 至少 有 neededApples 个苹果在土地 里面或者边缘上。
|x| 的值定义为：
- 如果 x >= 0 ，那么值为 x
- 如果 x < 0 ，那么值为 -x
提示：
1 <= neededApples <= 10^15

打表模拟。
边长为 2 时:
2 1 2
1 0 1
2 1 2
边长为 4 时:
4 3 2 3 4
3 2 1 2 3
2 1 0 1 2
3 2 1 2 3
4 3 2 3 4
边长为 6 时:
6 5 4 3 4 5 6
5 4 3 2 3 4 5
4 3 2 1 2 3 4
3 2 1 0 1 2 3
4 3 2 1 2 3 4
5 4 3 2 3 4 5
6 5 4 3 4 5 6
将正方形分成 4 等分:
    1 2      = (1 + 2) * 1
  3 2 3 4    = (2 + 4) * 2
5 4 3 4 5 6  = (3 + 6) * 3
即第 i 层和为 (i + 2i) * i, 一圈的和需乘 4，即 12 * i * i
对应周长为 8 * i
 */