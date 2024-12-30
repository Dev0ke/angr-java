import java.util.ArrayList;
import java.util.List;

public class SolutionP2647 {
    public int[][] colorRed(int size) {
        int n = 2 * size;
        List<int[]> res_l = new ArrayList<>();
        for (int i = size; i > 1; ) {
            for (int j = 1; j < n; j += 2) {
                res_l.add(new int[]{i, j});
            }
            if (i >= 3) {
                res_l.add(new int[]{i - 1, 2});
            }
            i -= 2;
            if (i >= 2) {
                for (int j = 3; j < n - 4; j += 2) {
                    res_l.add(new int[]{i, j});
                }
            }
            if (i >= 3) {
                res_l.add(new int[]{i - 1, 1});
            }
            i -= 2;
            n -= 8;
        }
        res_l.add(new int[]{1, 1});
        return res_l.toArray(int[][]::new);
    }
}
/*
$2647. 把三角形染成红色
https://leetcode.cn/problems/color-the-triangle-red/description/

现给定你一个整数 n 。考虑一个边长为 n 的等边三角形，被分成 n2 个单位等边三角形。这个三角形有 n 个 从 1 开始编号 的行，其中第 i 行有 2i - 1 个单位等边三角形。
第 i 行的三角形也是 从 1 开始编号 的，其坐标从 (i, 1) 到 (i, 2i - 1) 。下面的图像显示了一个边长为 4 的三角形及其三角形的索引。
如果两个三角形 共享一条边 ，则它们是 相邻 的。例如：
- 三角形 (1,1) 和 (2,2) 是相邻的。
- 三角形 (3,2) 和 (3,3) 是相邻的。
- 三角形 (2,2) 和 (3,3) 不相邻，因为它们没有共享任何边。
初始时，所有单位三角形都是 白色 的。你想选择 k 个三角形并将它们涂成 红色 。然后我们将运行以下算法：
1.选择一个 至少有两个 红色相邻三角形的白色三角形。
  - 如果没有这样的三角形，请停止算法。
2.将该三角形涂成 红色 。
3.回到步骤 1。
选择最小的 k 并在运行此算法之前将 k 个三角形涂成红色，使得在算法停止后，所有单元三角形都被涂成红色。
返回一个二维列表，其中包含你要最初涂成红色的三角形的坐标。答案必须尽可能小。如果有多个有效的解决方案，请返回其中任意一个。
提示：
1 <= n <= 1000

https://leetcode.cn/problems/color-the-triangle-red/solutions/2456256/python-108ms-by-nrib8zib57-pot3/
相似题目: LCP 70. 沙地治理
https://leetcode.cn/problems/XxZZjK/
 */
