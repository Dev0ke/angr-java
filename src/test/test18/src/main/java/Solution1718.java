import java.util.Arrays;

public class Solution1718 {
    private int n;
    private int[] ans;

    // 类似于寻找 Langford 数列
    public int[] constructDistancedSequence(int n) {
        this.n = n;
        ans = new int[n * 2 - 1];
        Arrays.fill(ans, -1);
        dfs(0);
        return ans;
    }

    private boolean dfs(int cur) {
        if (cur == n * 2 - 1) return true;
        // 这个位置之前已经放过了
        if (ans[cur] != -1) return dfs(cur + 1);
        // 字典序最大的序列：优先看大的
        for (int num = n; num > 0; num--) {
            boolean has = false;
            for (int v : ans) {
                if (v == num) {
                    has = true;
                    break;
                }
            }
            if (!has) {
                int gap = num > 1 ? num : 0;
                // 可以填
                if (cur + gap < 2 * n - 1 && ans[cur] == ans[cur + gap] && ans[cur] == -1) {
                    ans[cur] = ans[cur + gap] = num;
                    if (dfs(cur + 1)) return true;
                    ans[cur] = ans[cur + gap] = -1;
                }
            }
        }
        return false;
    }
}
/*
1718. 构建字典序最大的可行序列
https://leetcode.cn/problems/construct-the-lexicographically-largest-valid-sequence/description/

给你一个整数 n ，请你找到满足下面条件的一个序列：
- 整数 1 在序列中只出现一次。
- 2 到 n 之间每个整数都恰好出现两次。
- 对于每个 2 到 n 之间的整数 i ，两个 i 之间出现的距离恰好为 i 。
序列里面两个数 a[i] 和 a[j] 之间的 距离 ，我们定义为它们下标绝对值之差 |j - i| 。
请你返回满足上述条件中 字典序最大 的序列。题目保证在给定限制条件下，一定存在解。
一个序列 a 被认为比序列 b （两者长度相同）字典序更大的条件是： a 和 b 中第一个不一样的数字处，a 序列的数字比 b 序列的数字大。比方说，[0,1,9,0] 比 [0,1,5,6] 字典序更大，因为第一个不同的位置是第三个数字，且 9 比 5 大。
提示：
1 <= n <= 20

回溯。
https://leetcode.cn/problems/construct-the-lexicographically-largest-valid-sequence/solutions/1155984/lei-si-yu-xun-zhao-langfordshu-lie-by-ca-mlbj/
1、回溯带上bool返回值表示找到一个解 此时不必再向下回溯寻找，而是层层返回
2、贪心，从最大的数看起，寻找最大的字典序(如果题目没要求字典序，这一步实际上也起到了剪枝的效果)
 */