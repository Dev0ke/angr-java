import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1766 {
    static final int MX = 51;
    static final int[][] coprime = new int[MX][MX];

    static {
        // coprime[i] 保存 [1, MX) 中与 i 互质的所有元素
        for (int i = 1; i < MX; i++) {
            int k = 0;
            for (int j = 1; j < MX; j++) {
                if (getGCD(i, j) == 1) {
                    coprime[i][k++] = j;
                }
            }
        }
    }

    static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }

    private List<Integer>[] g;
    private int[] nums, ans;
    private int[] valDepth, valNodeId;

    public int[] getCoprimes(int[] nums, int[][] edges) {
        this.nums = nums;
        int n = nums.length;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            int x = p[0], y = p[1];
            g[x].add(y);
            g[y].add(x);
        }

        ans = new int[n];
        Arrays.fill(ans, -1);
        valDepth = new int[MX];
        valNodeId = new int[MX];
        dfs(0, -1, 1);
        return ans;
    }

    // DFS 记录节点值的深度和编号
    private void dfs(int x, int fa, int depth) {
        // 计算与 val 互质的祖先节点值中，节点深度最大的节点编号
        int val = nums[x];
        int maxDepth = 0;
        for (int j : coprime[val]) {
            if (j == 0) break;
            if (maxDepth < valDepth[j]) {
                maxDepth = valDepth[j];
                ans[x] = valNodeId[j];
            }
        }
        // tmpDepth 和 tmpNodeId 用于恢复现场
        int tmpDepth = valDepth[val];
        int tmpNodeId = valNodeId[val];
        valDepth[val] = depth;
        valNodeId[val] = x;
        for (Integer y : g[x]) {
            if (y == fa) continue;
            dfs(y, x, depth + 1);
        }
        valDepth[val] = tmpDepth;
        valNodeId[val] = tmpNodeId;
    }
}
/*
1766. 互质树
https://leetcode.cn/problems/tree-of-coprimes/description/

给你一个 n 个节点的树（也就是一个无环连通无向图），节点编号从 0 到 n - 1 ，且恰好有 n - 1 条边，每个节点有一个值。树的 根节点 为 0 号点。
给你一个整数数组 nums 和一个二维数组 edges 来表示这棵树。nums[i] 表示第 i 个点的值，edges[j] = [uj, vj] 表示节点 uj 和节点 vj 在树中有一条边。
当 gcd(x, y) == 1 ，我们称两个数 x 和 y 是 互质的 ，其中 gcd(x, y) 是 x 和 y 的 最大公约数 。
从节点 i 到 根 最短路径上的点都是节点 i 的祖先节点。一个节点 不是 它自己的祖先节点。
请你返回一个大小为 n 的数组 ans ，其中 ans[i]是离节点 i 最近的祖先节点且满足 nums[i] 和 nums[ans[i]] 是 互质的 ，如果不存在这样的祖先节点，ans[i] 为 -1 。
提示：
nums.length == n
1 <= nums[i] <= 50
1 <= n <= 10^5
edges.length == n - 1
edges[j].length == 2
0 <= uj, vj < n
uj != vj

DFS 中记录节点值的深度和编号，回溯写法
https://leetcode.cn/problems/tree-of-coprimes/solutions/2733992/dfs-zhong-ji-lu-jie-dian-zhi-de-shen-du-4v5d2/
时间复杂度 O(nU)。其中 U = max(nums[i]) = 50
 */