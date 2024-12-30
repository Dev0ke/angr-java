import java.util.ArrayList;
import java.util.List;

public class SolutionP3189 {
    public int minMoves(int[][] rooks) {
        List<Integer> s = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        for (int[] p : rooks) {
            int i = p[0], j = p[1];
            s.add(i);
            t.add(j);
        }
        s.sort(null);
        t.sort(null);
        int n = s.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(i - s.get(i)) + Math.abs(i - t.get(i));
        }
        return sum;
    }
}
/*
$3189. 得到一个和平棋盘的最少步骤
https://leetcode.cn/problems/minimum-moves-to-get-a-peaceful-board/description/

给定一个长度为 n 的二维数组 rooks，其中 rooks[i] = [xi, yi] 表示 n x n 棋盘上一个车的位置。你的任务是每次在垂直或水平方向上移动 1 格 车（到一个相邻的格子）使得棋盘变得 和平。
如果每行每列都 只有 一个车，那么这块棋盘就是和平的。
返回获得和平棋盘所需的 最少 步数。
注意 任何时刻 两个车都不能在同一个格子。
提示：
1 <= n == rooks.length <= 500
0 <= xi, yi <= n - 1
输入保证没有两个车在相同的格子。

如果存在y挡住了x前往目标点x'，那么先将y移动到目标的y'，如果y目标点y'被x挡住了，那么交换xy的目标点不会增加步数，因此不需要考虑阻挡的情况，只需要考虑最终结果。
考虑一维的情况，假设数轴上有[a0,a1,...,an]n个点目标是[b0,b1,...,bn]（a(i+1)>=ai且b(i+1)>bi），那么其中一个最小方案一定有将ai移动到bi上，移动步数为sum(abs(bi-ai))。
同理本题中二维互不干扰互相独立，可以当成两次一维情况来考虑，即先按横坐标排序，再按纵坐标排序，得到对应结果。
https://leetcode.cn/problems/minimum-moves-to-get-a-peaceful-board/solutions/2816159/shu-xue-pai-xu-dan-xing-ji-jian-100fu-fa-v0av/
 */