import java.util.HashSet;
import java.util.Set;

public class SolutionP3237 {
    public int[] simulationResult(int[] windows, int[] queries) {
        int n = windows.length;
        int[] ans = new int[n];
        int j = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = queries.length - 1; i >= 0; i--) {
            int window = queries[i];
            if (!set.contains(window)) {
                set.add(window);
                ans[j++] = window;
            }
        }
        for (int window : windows) {
            if (!set.contains(window)) {
                ans[j++] = window;
            }
        }
        return ans;
    }
}
/*
$3237. Alt 和 Tab 模拟
https://leetcode.cn/problems/alt-and-tab-simulation/description/

有 n 个编号从  1 到 n 的打开的窗口，我们想要模拟使用 alt + tab 键在窗口之间导航。
给定数组 windows 包含窗口的初始顺序（第一个元素在最前面，最后一个元素在最后面）。
同时给定数组 queries 表示每一次查询中，编号为 queries[i] 的窗口被切换到最前面。
返回 windows 数组的最后状态。
提示：
1 <= n == windows.length <= 10^5
windows 是 [1, n] 的一个排列。
1 <= queries.length <= 10^5
1 <= queries[i] <= n

直接模拟时间复杂度是 O(nq)，该时间复杂度过高，需要优化。
由于查询顺序为数组 queries 从左到右的顺序，每次查询的窗口被切换到最前面，因此可以得到如下结论。
1、所有未查询过的窗口的相对顺序不变。
2、所有查询过的窗口都在所有未查询过的窗口前面。
3、所有查询过的窗口中，越晚查询的窗口在越前面。
ttps://leetcode.cn/problems/alt-and-tab-simulation/solutions/2868628/3237-alt-he-tab-mo-ni-by-stormsunshine-nbxs/
 */