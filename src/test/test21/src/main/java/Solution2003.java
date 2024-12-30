import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2003 {
    private int[] nums;
    private Map<Integer, List<Integer>> g;
    private Map<Integer, Boolean> inSet;

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        this.nums = nums;

        int n = parents.length;
        // 最小的不属于集合的元素(min excluded)
        int[] mex = new int[n];
        Arrays.fill(mex, 1);

        g = new HashMap<>();
        for (int w = 1; w < n; w++) {
            g.computeIfAbsent(parents[w], key -> new ArrayList<>()).add(w);
        }
        inSet = new HashMap<>();

        // 找到基因值等于 1 的节点 x
        int x = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                x = i;
                break;
            }
        }
        // x 顺着父节点往上走
        for (int cur = 2; x >= 0; x = parents[x]) {
            f(x);
            while (inSet.getOrDefault(cur, false)) {
                // 不断自增直至不在基因值集合中
                cur++;
            }
            mex[x] = cur;
        }
        return mex;
    }

    private void f(int v) {
        // 收集基因值
        inSet.put(nums[v], true);
        for (int w : g.getOrDefault(v, new ArrayList<>())) {
            // 避免重复访问节点
            if (!inSet.getOrDefault(nums[w], false)) {
                f(w);
            }
        }
    }
}
/*
2003. 每棵子树内缺失的最小基因值
https://leetcode.cn/problems/smallest-missing-genetic-value-in-each-subtree/

第 258 场周赛 T4。

有一棵根节点为 0 的 家族树 ，总共包含 n 个节点，节点编号为 0 到 n - 1 。给你一个下标从 0 开始的整数数组 parents ，其中 parents[i] 是节点 i 的父节点。由于节点 0 是 根 ，所以 parents[0] == -1 。
总共有 10^5 个基因值，每个基因值都用 闭区间 [1, 10^5] 中的一个整数表示。给你一个下标从 0 开始的整数数组 nums ，其中 nums[i] 是节点 i 的基因值，且基因值 互不相同 。
请你返回一个数组 ans ，长度为 n ，其中 ans[i] 是以节点 i 为根的子树内 缺失 的 最小 基因值。
节点 x 为根的 子树 包含节点 x 和它所有的 后代 节点。
提示：
n == parents.length == nums.length
2 <= n <= 10^5
对于 i != 0 ，满足 0 <= parents[i] <= n - 1
parents[0] == -1
parents 表示一棵合法的树。
1 <= nums[i] <= 10^5
nums[i] 互不相同。

解法二：利用无重复基因值的性质
https://leetcode.cn/problems/smallest-missing-genetic-value-in-each-subtree/solution/go-qi-fa-shi-he-bing-by-endlesscheng-kmff/
 */