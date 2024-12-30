import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution2813 {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (o1, o2) -> Integer.compare(o2[0], o1[0]));

        long total_profit = 0;
        int n = items.length;
        Set<Integer> vis = new HashSet<>();
        Deque<Integer> dup = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            total_profit += items[i][0];
            if (!vis.contains(items[i][1])) {
                vis.add(items[i][1]);
            } else {
                dup.push(items[i][0]);
            }
        }

        long sz = vis.size();
        long ans = total_profit + sz * sz;
        for (int i = k; i < n; i++) {
            if (!dup.isEmpty() && !vis.contains(items[i][1])) {
                vis.add(items[i][1]);
                total_profit = total_profit - dup.pop() + items[i][0];
                sz = vis.size();
                ans = Math.max(ans, total_profit + sz * sz);
            }
        }
        return ans;
    }
}
/*
2813. 子序列最大优雅度
https://leetcode.cn/problems/maximum-elegance-of-a-k-length-subsequence/

第 357 场周赛 T4。

给你一个长度为 n 的二维整数数组 items 和一个整数 k 。
items[i] = [profiti, categoryi]，其中 profiti 和 categoryi 分别表示第 i 个项目的利润和类别。
现定义 items 的 子序列 的 优雅度 可以用 total_profit + distinct_categories^2 计算，其中 total_profit 是子序列中所有项目的利润总和，distinct_categories 是所选子序列所含的所有类别中不同类别的数量。
你的任务是从 items 所有长度为 k 的子序列中，找出 最大优雅度 。
用整数形式表示并返回 items 中所有长度恰好为 k 的子序列的最大优雅度。
注意：数组的子序列是经由原数组删除一些元素（可能不删除）而产生的新数组，且删除不改变其余元素相对顺序。
提示：
1 <= items.length == n <= 10^5
items[i].length == 2
items[i][0] == profiti
items[i][1] == categoryi
1 <= profiti <= 10^9
1 <= categoryi <= n
1 <= k <= n

反悔贪心
找到一个 base
先选最大的 k 个利润，这可能是一个答案
考虑下一个项目要不要选
由于利润由大到小排序，利润和 total_profit 不会变大
所以重点就在 distinct_categories 能不能变大
分类讨论：
1、如果新添加的项目的类别之前选过了，那么 distinct_categories 不会变大
2、如果新添加的项目的类别之前没选过（没出现过）
 如果移除的项目的类别只有一个，那么 distinct_categories -1+1，不变，不行
 如果移除的项目的类别有多个，那么 distinct_categories +1，这种情况是可以的
 选一个利润最小的移除，用一个栈（数组）维护
 */