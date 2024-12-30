import java.util.HashMap;
import java.util.Map;

public class Solution3003 {
    private char[] cs;
    private int k;
    private Map<Long, Integer> memo;

    public int maxPartitionsAfterOperations(String s, int k) {
        this.cs = s.toCharArray();
        this.k = k;
        memo = new HashMap<>();
        return dfs(0, 0, 0);
    }

    private int dfs(int i, int mask, int changed) {
        if (i == cs.length) {
            return 1;
        }
        long argsKey = ((long) i << 32) | ((long) mask << 1) | changed;
        if (memo.containsKey(argsKey)) {
            return memo.get(argsKey);
        }

        int res;
        // 不改 s[i]
        int bit = 1 << (cs[i] - 'a');
        int newMask = mask | bit;
        if (Integer.bitCount(newMask) > k) {
            res = dfs(i + 1, bit, changed) + 1;
        } else {
            res = dfs(i + 1, newMask, changed);
        }
        if (changed == 0) {
            // 枚举把 s[i] 改成 a,b,c,...,z
            for (int j = 0; j < 26; j++) {
                bit = 1 << j;
                newMask = mask | bit;
                if (Integer.bitCount(newMask) > k) {
                    res = Math.max(res, dfs(i + 1, bit, 1) + 1);
                } else {
                    res = Math.max(res, dfs(i + 1, newMask, 1));
                }
            }
        }
        memo.put(argsKey, res);
        return res;
    }
}
/*
3003. 执行操作后的最大分割数量
https://leetcode.cn/problems/maximize-the-number-of-partitions-after-operations/description/

第 379 场周赛 T4。

给你一个下标从 0 开始的字符串 s 和一个整数 k。
你需要执行以下分割操作，直到字符串 s 变为 空：
- 选择 s 的最长前缀，该前缀最多包含 k 个 不同 字符。
- 删除 这个前缀，并将分割数量加一。如果有剩余字符，它们在 s 中保持原来的顺序。
执行操作之 前 ，你可以将 s 中 至多一处 下标的对应字符更改为另一个小写英文字母。
在最优选择情形下改变至多一处下标对应字符后，用整数表示并返回操作结束时得到的最大分割数量。
提示：
1 <= s.length <= 10^4
s 只包含小写英文字母。
1 <= k <= 26

记忆化搜索。
时间复杂度 O(n * 26^2)
https://leetcode.cn/problems/maximize-the-number-of-partitions-after-operations/solutions/2595072/ji-yi-hua-sou-suo-jian-ji-xie-fa-pythonj-6g5z/
本题还有 O(n) 的前后缀分解解法。
 */