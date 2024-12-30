import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3316 {
    private char[] source, pattern;
    private Set<Integer> targetSet;
    private int[][] memo;

    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        this.source = source.toCharArray();
        this.pattern = pattern.toCharArray();
        targetSet = new HashSet<>();
        for (int index : targetIndices) targetSet.add(index);

        int n = source.length();
        int m = pattern.length();
        memo = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(n - 1, m - 1);
    }

    private int dfs(int i, int j) {
        if (i < j) return Integer.MIN_VALUE;
        if (i < 0) return 0;
        // j+1 避免数组越界
        if (memo[i][j + 1] != -1) return memo[i][j + 1];
        int res = dfs(i - 1, j) + (targetSet.contains(i) ? 1 : 0);
        if (j >= 0 && source[i] == pattern[j]) {
            res = Math.max(res, dfs(i - 1, j - 1));
        }
        return memo[i][j + 1] = res;
    }
}
/*
3316. 从原字符串里进行删除操作的最多次数
https://leetcode.cn/problems/find-maximum-removals-from-source-string/description/

第 141 场双周赛 T3。

给你一个长度为 n 的字符串 source ，一个字符串 pattern 且它是 source 的 子序列 ，和一个 有序 整数数组 targetIndices ，整数数组中的元素是 [0, n - 1] 中 互不相同 的数字。
定义一次 操作 为删除 source 中下标在 idx 的一个字符，且需要满足：
- idx 是 targetIndices 中的一个元素。
- 删除字符后，pattern 仍然是 source 的一个 子序列 。
执行操作后 不会 改变字符在 source 中的下标位置。比方说，如果从 "acb" 中删除 'c' ，下标为 2 的字符仍然是 'b' 。
请你返回 最多 可以进行多少次删除操作。
子序列指的是在原字符串里删除若干个（也可以不删除）字符后，不改变顺序地连接剩余字符得到的字符串。
提示：
1 <= n == source.length <= 3 * 10^3
1 <= pattern.length <= n
1 <= targetIndices.length <= n
targetIndices 是一个升序数组。
输入保证 targetIndices 包含的元素在 [0, n - 1] 中且互不相同。
source 和 pattern 只包含小写英文字母。
输入保证 pattern 是 source 的一个子序列。

记忆化搜索。
时间复杂度 O(nm)。
 */