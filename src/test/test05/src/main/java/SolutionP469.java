import java.util.List;

public class SolutionP469 {
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long pre = 0;
        for (int i = 0; i < n; i++) {
//            long x1 = points.get((i + 1) % n).get(0) - points.get(i).get(0);
//            long y1 = points.get((i + 1) % n).get(1) - points.get(i).get(1);
//            long x2 = points.get((i + 2) % n).get(0) - points.get((i + 1) % n).get(0);
//            long y2 = points.get((i + 2) % n).get(1) - points.get((i + 1) % n).get(1);
//            long crossProduct = x1 * y2 - x2 * y1;
            long crossProduct = crossProduct(points.get(i), points.get((i + 1) % n), points.get((i + 2) % n));
            if (crossProduct != 0) {
                if (crossProduct * pre < 0) {
                    return false;
                }
                pre = crossProduct;
            }
        }
        return true;
    }

    // 叉乘
    private long crossProduct(List<Integer> p, List<Integer> q, List<Integer> r) {
        long x1 = q.get(0) - p.get(0);
        long y1 = q.get(1) - p.get(1);
        long x2 = r.get(0) - q.get(0);
        long y2 = r.get(1) - q.get(1);
        return x1 * y2 - x2 * y1;
    }
}
/*
$469. 凸多边形
https://leetcode.cn/problems/convex-polygon/

给定 X-Y 平面上的一组点 points ，其中 points[i] = [xi, yi] 。这些点按顺序连成一个多边形。
如果该多边形为 凸 多边形（凸多边形的定义）则返回 true ，否则返回 false 。
你可以假设由给定点构成的多边形总是一个 简单的多边形（简单多边形的定义）。换句话说，我们要保证每个顶点处恰好是两条边的汇合点，并且这些边 互不相交 。
提示:
3 <= points.length <= 10^4
points[i].length == 2
-10^4 <= xi, yi <= 10^4
所有点都 不同

二维几何。
叉乘。顶点凹凸性法
https://blog.csdn.net/houyichaochao/article/details/81141893
相似题目: 587. 安装栅栏
https://leetcode.cn/problems/erect-the-fence/
 */