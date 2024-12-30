import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Solution2612 {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int x : banned) {
            bannedSet.add(x);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[p] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(p);
        List<TreeSet<Integer>> unVisitedSets = new ArrayList<>();
        unVisitedSets.add(new TreeSet<>());
        unVisitedSets.add(new TreeSet<>());
        for (int i = 0; i < n; i++) {
            if (i != p && !bannedSet.contains(i)) {
                unVisitedSets.get(i & 1).add(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.remove();

                // a [0, k-1]
                // a+b=k-1 即 b=k-1-a
                // x 由 a 点翻转到 b 点
                // y=x-a+b 即 0 <= y=x+k-1-2a <= n-1
                // x-k+1 <= y=x+k-1-2a <= x+k-1

                // min = 0+(k-1)-x, max = (n-k)+(n-1)-x
                int down = Math.max((k - 1) - x, x - k + 1);
                int up = Math.min((n - k) + (n - 1) - x, x + k - 1);
                TreeSet<Integer> unVisitedSet = unVisitedSets.get(down & 1);
                for (Integer y = unVisitedSet.ceiling(down); y != null && y <= up; y = unVisitedSet.higher(y)) {
                    queue.add(y);
                    ans[y] = ans[x] + 1;
                    unVisitedSet.remove(y);
                }
            }
        }
        return ans;
    }
}
/*
2612. 最少翻转操作数
https://leetcode.cn/problems/minimum-reverse-operations/

第 339 场周赛 T4。

给你一个整数 n 和一个在范围 [0, n - 1] 以内的整数 p ，它们表示一个长度为 n 且下标从 0 开始的数组 arr ，数组中除了下标为 p 处是 1 以外，其他所有数都是 0 。
同时给你一个整数数组 banned ，它包含数组中的一些位置。banned 中第 i 个位置表示 arr[banned[i]] = 0 ，题目保证 banned[i] != p 。
你可以对 arr 进行 若干次 操作。一次操作中，你选择大小为 k 的一个 子数组 ，并将它 翻转 。在任何一次翻转操作后，你都需要确保 arr 中唯一的 1 不会到达任何 banned 中的位置。换句话说，arr[banned[i]] 始终 保持 0 。
请你返回一个数组 ans ，对于 [0, n - 1] 之间的任意下标 i ，ans[i] 是将 1 放到位置 i 处的 最少 翻转操作次数，如果无法放到位置 i 处，此数为 -1 。
- 子数组 指的是一个数组里一段连续 非空 的元素序列。
- 对于所有的 i ，ans[i] 相互之间独立计算。
- 将一个数组中的元素 翻转 指的是将数组中的值变成 相反顺序 。
提示：
1 <= n <= 10^5
0 <= p <= n - 1
0 <= banned.length <= n - 1
0 <= banned[i] <= n - 1
1 <= k <= n 
banned[i] != p
banned 中的值 互不相同 。

BFS+平衡树/并查集
时间复杂度 O(nlogn)
相似题目: 1851. 包含每个查询的最小区间
https://leetcode.cn/problems/minimum-interval-to-include-each-query/
2382. 删除操作后的最大子段和
https://leetcode.cn/problems/maximum-segment-sum-after-removals/
2334. 元素值大于变化阈值的子数组
https://leetcode.cn/problems/subarray-with-elements-greater-than-varying-threshold/
 */