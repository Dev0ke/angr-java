import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP2152 {
    public int minimumLines(int[][] points) {
        int n = points.length;
        int[] f = new int[1 << n];
        Arrays.fill(f, Integer.MAX_VALUE/2);
        for (int i = 1; i < (1 << n); ++i) {
            if (ok(points, i)) {
                f[i] = 1;
            } else {
                for (int j = 1; j < i; ++j) {
                    f[i] = Math.min(f[i], f[j & i] + f[~j & i]); // 这个是两个补集的表示方式
                }
            }
        }
        return f[(1 << n) - 1];
    }

    // 先验证是否能一条线穿掉
    private boolean ok(int[][] a, int st) {
        if (Integer.bitCount(st) < 3) {
            return true;
        }
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < a.length; ++i) {
            // if ((st & (1 << i)) != 0) b.add(i);
            if ((st >> i & 1) == 1) {
                b.add(i);
            }
        }
        int x = a[b.get(0)][0] - a[b.get(1)][0];
        int y = a[b.get(0)][1] - a[b.get(1)][1];
        for (int i = 2; i < b.size(); ++i) {
            int l = a[b.get(0)][0] - a[b.get(i)][0];
            int r = a[b.get(0)][1] - a[b.get(i)][1];
            if (l * y != x * r) {
                return false;
            }
        }
        return true;
    }
}
/*
$2152. 穿过所有点的所需最少直线数量
https://leetcode.cn/problems/minimum-number-of-lines-to-cover-points/description/

给定一个 points 数组，points[i] = [xi, yi] 表示直角坐标系 X-Y 的一个点。
现在考虑向 X-Y 坐标系中添加 直线，使得每个点 至少 在一条直线上。
返回能够穿过所有点的所需 最少直线 数量。
提示:
1 <= points.length <= 10
points[i].length == 2
-100 <= xi, yi <= 100
points 中元素都是唯一的

可以暴力枚举所有子集 状压的基调。
1 先判断一个子集是否所有点都共线 //两条边 有一个公共的点 且斜率相同 就是共线
2 如果不行 就把他拆分两个互补的更小的子集 然后去遍历所有的可能组合。。就必然能覆盖最优解。
https://leetcode.cn/problems/minimum-number-of-lines-to-cover-points/solutions/1755927/by-euyia-y2o9/
 */