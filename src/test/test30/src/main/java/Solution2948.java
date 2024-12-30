import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2948 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        int[][] newnums = new int[n][2];
        for (int i = 0; i < n; i++) {
            newnums[i][0] = nums[i];
            newnums[i][1] = i;
        }
        Arrays.sort(newnums, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        DSU dsu = new DSU(n);
        for (int i = 1; i < n; i++) {
            if (newnums[i][0] - newnums[i - 1][0] <= limit) {
                dsu.union(newnums[i][1], newnums[i - 1][1]);
            }
        }

        // 分组排序
        Map<Integer, List<Integer>> groupsId = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = dsu.find(i);
            groupsId.computeIfAbsent(p, key -> new ArrayList<>()).add(i);
        }
        for (List<Integer> ids : groupsId.values()) {
            List<Integer> vals = new ArrayList<>(ids.size());
            for (Integer id : ids) {
                vals.add(nums[id]);
            }
            vals.sort(null);
            int i = 0;
            for (Integer id : ids) {
                nums[id] = vals.get(i++);
            }
        }
        return nums;
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
        }
    }

    // 时间复杂度 O(nlogn)
    public int[] lexicographicallySmallestArray2(int[] nums, int limit) {
        int n = nums.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> nums[o]));

        int[] ans = new int[n];
        int i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && nums[ids[i]] - nums[ids[i - 1]] <= limit; i++) {
            }
            Integer[] subIds = Arrays.copyOfRange(ids, st, i);
            Arrays.sort(subIds);
            for (int j = 0; j < subIds.length; j++) {
                ans[subIds[j]] = nums[ids[st + j]];
            }
        }
        return ans;
    }
}
/*
2948. 交换得到字典序最小的数组
https://leetcode.cn/problems/make-lexicographically-smallest-array-by-swapping-elements/description/

第 373 场周赛 T3。

给你一个下标从 0 开始的 正整数 数组 nums 和一个 正整数 limit 。
在一次操作中，你可以选择任意两个下标 i 和 j，如果 满足 |nums[i] - nums[j]| <= limit ，则交换 nums[i] 和 nums[j] 。
返回执行任意次操作后能得到的 字典序最小的数组 。
如果在数组 a 和数组 b 第一个不同的位置上，数组 a 中的对应元素比数组 b 中的对应元素的字典序更小，则认为数组 a 就比数组 b 字典序更小。例如，数组 [2,10,3] 比数组 [10,2,3] 字典序更小，下标 0 处是两个数组第一个不同的位置，且 2 < 10 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= limit <= 10^9

并查集分组排序
或者 把 nums[i] 及其下标 i 绑在一起排序（也可以单独排序下标），然后把 nums 分成若干段，每一段都是递增的且相邻元素之差不超过 limit，那么这一段可以随意排序。
思考题：如果只允许交换相邻元素，要怎么做？
牛客练习赛 116 C
相似题目: 1202. 交换字符串中的元素
https://leetcode.cn/problems/smallest-string-with-swaps/
1998. 数组的最大公因数排序
https://leetcode.cn/problems/gcd-sort-of-an-array/
 */