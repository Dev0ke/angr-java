import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1840 {
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, Comparator.comparingInt(o -> o[0])); // 按编号排序
        List<int[]> st = new ArrayList<>();
        st.add(new int[]{1, 0}); // 单调栈
        for (int[] p : restrictions) {
            int id = p[0], h = p[1];
            while (st.get(st.size() - 1)[1] - (id - st.get(st.size() - 1)[0]) > h) { // 如果左侧高度超标，弹出
                st.remove(st.size() - 1);
            }
            st.add(new int[]{id, Math.min(h, st.get(st.size() - 1)[1] + id - st.get(st.size() - 1)[0])}); // 限制右侧的最大高度并入栈
        }
        int ans = 0;
        for (int i = 1; i < st.size(); i++) { // 依次遍历
            ans = Math.max(ans, (st.get(i)[1] + st.get(i - 1)[1] + (st.get(i)[0] - st.get(i - 1)[0])) / 2); // 通过上面的公式求最大值
        }
        if (st.get(st.size() - 1)[0] < n) { // 考虑栈中最后元素的情况
            ans = Math.max(ans, n - st.get(st.size() - 1)[0] + st.get(st.size() - 1)[1]);
        }
        return ans;
    }
}
/*
1840. 最高建筑高度
https://leetcode.cn/problems/maximum-building-height/description/

在一座城市里，你需要建 n 栋新的建筑。这些新的建筑会从 1 到 n 编号排成一列。
这座城市对这些新建筑有一些规定：
- 每栋建筑的高度必须是一个非负整数。
- 第一栋建筑的高度 必须 是 0 。
- 任意两栋相邻建筑的高度差 不能超过  1 。
除此以外，某些建筑还有额外的最高高度限制。这些限制会以二维整数数组 restrictions 的形式给出，其中 restrictions[i] = [idi, maxHeighti] ，表示建筑 idi 的高度 不能超过 maxHeighti 。
题目保证每栋建筑在 restrictions 中 至多出现一次 ，同时建筑 1 不会 出现在 restrictions 中。
请你返回 最高 建筑能达到的 最高高度 。
提示：
2 <= n <= 10^9
0 <= restrictions.length <= min(n - 1, 10^5)
2 <= idi <= n
idi 是 唯一的 。
0 <= maxHeighti <= 10^9

单调栈。
https://leetcode.cn/problems/maximum-building-height/solutions/1723742/python-dan-diao-zhan-by-qin-qi-shu-hua-2-iudn
 */