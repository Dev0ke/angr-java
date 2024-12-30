import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2440 {
    private int[] nums;
    private Map<Integer, List<Integer>> adj;

    public int componentValue(int[] nums, int[][] edges) {
        this.nums = nums;
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().orElseThrow();
        // x:连通块大小
        for (int x = max; x < sum; x++) {
            if (sum % x == 0) {
                if (dfs(0, -1, x) == 0) {
                    // sum / x 个连通块
                    return sum / x - 1;
                }
            }
        }
        return 0;
    }

    // u:当前节点 fa:当前节点父节点 x:连通块大小 return:子树连通块大小
    private int dfs(int u, int fa, int x) {
        int sum = nums[u];
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (v != fa) {
                int res = dfs(v, u, x);
                if (res == -1) {
                    return -1;
                }
                sum += res;
            }
        }
        if (sum > x) {
            return -1;
        }
        return sum % x;
    }
}
/*
2440. 创建价值相同的连通块
https://leetcode.cn/problems/create-components-with-same-value/

第 89 场双周赛 T4。

有一棵 n 个节点的无向树，节点编号为 0 到 n - 1 。
给你一个长度为 n 下标从 0 开始的整数数组 nums ，其中 nums[i] 表示第 i 个节点的值。
同时给你一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 与 bi 之间有一条边。
你可以 删除 一些边，将这棵树分成几个连通块。一个连通块的 价值 定义为这个连通块中 所有 节点 i 对应的 nums[i] 之和。
你需要删除一些边，删除后得到的各个连通块的价值都相等。请返回你可以删除的边数 最多 为多少。
提示：
1 <= n <= 2 * 10^4
nums.length == n
1 <= nums[i] <= 50
edges.length == n - 1
edges[i].length == 2
0 <= edges[i][0], edges[i][1] <= n - 1
edges 表示一棵合法的树。

枚举连通块大小 x，1e6 数据范围内，最大因子个数 <= 240（720720） https://oeis.org/A066150
枚举每个满足要求的连通块大小，可以删除的边数为连通块数量-1
 */