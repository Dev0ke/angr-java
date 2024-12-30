import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution823 {
    private static final int MOD = (int) (1e9 + 7);
    private int[] arr;
    private Map<Integer, Integer> mp;
    private long[] memo;

    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        this.arr = arr;

        mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(arr[i], i);
        }
        memo = new long[n];
        Arrays.fill(memo, -1);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dfs(i);
        }
        // 为什么只在最后取模也可以通过？
        // 我尝试用 183783600 的所有因子来 hack（去掉因子 1 后有 959 个因子），但离溢出还差很多。
        // @灵茶山艾府
        return (int) (ans % MOD);
    }

    private long dfs(int i) {
        if (memo[i] != -1) return memo[i];
        long res = 1;
        int val = arr[i];
        for (int j = 0; j < i; j++) {
            int x = arr[j];
            // 另一个因子 val/x 必须在 arr 中
            if (val % x == 0 && mp.containsKey(val / x)) {
                res += dfs(j) * dfs(mp.get(val / x));
            }
        }
        return memo[i] = res;
    }
}
/*
823. 带因子的二叉树
https://leetcode.cn/problems/binary-trees-with-factors/description/

给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
满足条件的二叉树一共有多少个？答案可能很大，返回 对 10^9 + 7 取余 的结果。
提示：
1 <= arr.length <= 1000
2 <= arr[i] <= 10^9
arr 中的所有值 互不相同

记忆化搜索。
时间复杂度 O(n^2)。
 */