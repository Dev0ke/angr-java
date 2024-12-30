import java.util.ArrayList;
import java.util.List;

public class Solution1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();
        int from = rounds[0], to = rounds[rounds.length - 1];
        if (from <= to) {
            for (int i = from; i <= to; ++i) ans.add(i);
        } else {
            for (int i = 1; i <= to; ++i) ans.add(i);
            for (int i = from; i <= n; ++i) ans.add(i);
        }
        return ans;
    }
}
/*
1560. 圆形赛道上经过次数最多的扇区
https://leetcode.cn/problems/most-visited-sector-in-a-circular-track/description/

给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。
注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。
提示：
2 <= n <= 100
1 <= m <= 100
rounds.length == m + 1
1 <= rounds[i] <= n
rounds[i] != rounds[i + 1] ，其中 0 <= i < m

模拟。但无需模拟整个过程。
时间复杂度 O(n)。
 */