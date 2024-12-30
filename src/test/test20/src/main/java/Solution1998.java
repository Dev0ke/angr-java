import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1998 {
    public boolean gcdSort(int[] nums) {
        int n = nums.length;

        int mx = Arrays.stream(nums).max().orElseThrow();
        // 埃氏筛 预处理 最小质因子
        int[] lpf = new int[mx + 1];
        for (int i = 2; i <= mx; i++) {
            if (lpf[i] == 0) {
                for (int j = i; j <= mx; j += i) {
                    if (lpf[j] == 0) {
                        lpf[j] = i;
                    }
                }
            }
        }

        DSU dsu = new DSU(n + mx + 1);
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (x > 1) {
                int p = lpf[x];
                for (x /= p; lpf[x] == p; x /= p) {
                }
                dsu.union(n + p, i);
            }
        }

        // 分组排序
        Map<Integer, List<Integer>> groupsId = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = dsu.find(i) - n;
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

        // 判断数组是否有序
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) return false;
        }
        return true;
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
            // 路径压缩
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
}
/*
1998. 数组的最大公因数排序
https://leetcode.cn/problems/gcd-sort-of-an-array/

第 257 场周赛 T4。

给你一个整数数组 nums ，你可以在 nums 上执行下述操作 任意次 ：
- 如果 gcd(nums[i], nums[j]) > 1 ，交换 nums[i] 和 nums[j] 的位置。其中 gcd(nums[i], nums[j]) 是 nums[i] 和 nums[j] 的最大公因数。
如果能使用上述交换方式将 nums 按 非递减顺序 排列，返回 true ；否则，返回 false 。
提示：
1 <= nums.length <= 3 * 10^4
2 <= nums[i] <= 10^5

并查集连公因数，同一连通块分组排序，再判断
相似题目: 952. 按公因数计算最大组件大小
https://leetcode.cn/problems/largest-component-size-by-common-factor/
2709. 最大公约数遍历
https://leetcode.cn/problems/greatest-common-divisor-traversal/
 */