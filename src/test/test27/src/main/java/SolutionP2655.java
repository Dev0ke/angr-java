import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SolutionP2655 {
    public int[][] findMaximalUncoveredRanges(int n, int[][] ranges) {
        List<int[]> uncovered = new ArrayList<>();
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int prev = -1;
        int length = ranges.length;
        for (int i = 0; i <= length; i++) {
            int[] range = i < length ? ranges[i] : new int[]{n, n};
            if (range[0] - prev > 1) {
                uncovered.add(new int[]{prev + 1, range[0] - 1});
            }
            prev = Math.max(prev, range[1]);
        }
        return uncovered.toArray(int[][]::new);
    }
}
/*
$2655. 寻找最大长度的未覆盖区间
https://leetcode.cn/problems/find-maximal-uncovered-ranges/description/

现给你一个长度为 n 的 索引从 0 开始的 数组 nums 和一个 索引从 0 开始的 2 维数组 ranges ，ranges 是 nums 的子区间列表（子区间可能 重叠 ）。
每行 ranges[i] 恰好有两个元素：
- ranges[i][0] 表示第i个区间的起始位置（包含）
- ranges[i][1] 表示第i个区间的结束位置（包含）
这些区间覆盖了 nums 的一些元素，并留下了一些 未覆盖 的元素。你的任务是找到所有 最大长度 的未覆盖区间。
返回按起始点 升序排序 的未覆盖区间的二维数组 answer 。
所有 最大长度 的 未覆盖 区间指满足两个条件：
- 每个未覆盖的元素应该属于 恰好 一个子区间。
- 不存在两个区间 (l1,r1) 和 (l2,r2) 使得 r1+1=l2 。
提示：
1 <= n <= 10^9
0 <= ranges.length <= 10^6
ranges[i].length = 2
0 <= ranges[i][j] <= n - 1
ranges[i][0] <= ranges[i][1]

按照起始位置升序顺序遍历所有区间，因此需要将数组 ranges 按照起始位置升序排序。
1、如果 range[0]−prev>1，则区间 [prev+1,range[0]−1] 未覆盖，将该区间添加到答案中。
2、当前区间覆盖的最大下标是 range[1]，将 prev 的值更新为 max(prev,range[1])。
时间复杂度 O(mlogm)。
 */